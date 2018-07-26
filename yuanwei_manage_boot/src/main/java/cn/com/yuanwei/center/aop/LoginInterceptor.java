package cn.com.yuanwei.center.aop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import cn.com.yuanwei.center.annotation.Auth;
import cn.com.yuanwei.center.enums.ReturnInfoEnum;
import cn.com.yuanwei.center.enums.SourceEnum;
import cn.com.yuanwei.center.redis.po.UserInfo;
import cn.com.yuanwei.center.redis.service.impl.AccessService;
import cn.com.yuanwei.center.redis.service.impl.OnLineService;
import cn.com.yuanwei.center.treadLocal.LoginUserThread;
import cn.com.yuanwei.center.util.ValidateUtil;
/**
 * 权限拦截
 * @author sky
 *
 */
public class LoginInterceptor implements HandlerInterceptor {

	@Autowired
	OnLineService onLineService;
	@Autowired
	AccessService accessService;
	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler) throws Exception {
		Auth auth = ((HandlerMethod) handler).getMethodAnnotation(Auth.class);
		BeanFactory factory = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
		
		/*if (accessService == null) {//解决service为null无法注入问题 
	         accessService = (AccessService) factory.getBean("accessService"); 
	      } 
		//限制同一ip访问接口频率
		if(!"/types/common".equals(request.getRequestURI())){//下拉接口不限制访问频率
			if(!accessService.VerifyIp(CommonUtils.getIpAddress(request))){
				throw new Exception(ReturnInfoEnum.ACCESS_TOO_FAST.toString());
			}
		}*/
		String source = request.getHeader("source");
		if(ValidateUtil.isEmpty(source)){
			source = "1";//无来源则默认为移动端
		}
		LoginUserThread.setSource(Integer.valueOf(source));
		String url = request.getRequestURI();
		if("1".equals(source)){//移动端
			if (auth == null) {
				return true;
			}
		}else{
			//PC端除了登录和微信接口都需要登录
			String method = request.getMethod();
			if((url.indexOf("users/login")>=0&&method.equalsIgnoreCase("POST"))||url.indexOf("wechats")>=0){
				return true;
			}
		}
		
		String voucher = request.getHeader("voucher");
		if(ValidateUtil.isEmpty(voucher)){
			throw new Exception(ReturnInfoEnum.SidError.toString());
		}
		if (onLineService == null) {//解决service为null无法注入问题 
	         onLineService = (OnLineService) factory.getBean("onLineService"); 
	      } 
		UserInfo userInfo = onLineService.get(voucher, SourceEnum.getDesc(Integer.valueOf(source)));
		if(userInfo == null){
			throw new Exception(ReturnInfoEnum.SidError.toString());
		}
		LoginUserThread.setUser(userInfo);
		LoginUserThread.setVoucher(voucher);
	return true;
	}

}
