package cn.com.yuanwei.center.web;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.vo.NormalExcelConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.riversoft.weixin.common.oauth2.AccessToken;
import com.riversoft.weixin.mp.oauth2.MpOAuth2s;

import cn.com.yuanwei.center.annotation.Auth;
import cn.com.yuanwei.center.component.CacheManager;
import cn.com.yuanwei.center.config.SysConfig;
import cn.com.yuanwei.center.entity.User;
import cn.com.yuanwei.center.entity.UserVo;
import cn.com.yuanwei.center.enums.SourceEnum;
import cn.com.yuanwei.center.service.UserService;
import cn.com.yuanwei.center.treadLocal.LoginUserThread;
import cn.com.yuanwei.center.util.ExcelUtils;
import cn.com.yuanwei.center.util.ValidateUtil;
import cn.com.yuanwei.center.web.request.ChangePwdReq;
import cn.com.yuanwei.center.web.request.LoginReq;
import cn.com.yuanwei.center.web.request.UserReq;
import cn.com.yuanwei.center.web.response.UserLtResp;
import cn.com.yuanwei.center.web.response.base.Result;

@Controller
@RequestMapping("/users")
public class UserController {
	Log logger = LogFactory.getLog(UserController.class);
	@Autowired
	private UserService userService;
	@Autowired
	private SysConfig sysConfig;
	
	/**
	 * Desc:新增用户
	 * @param @param req
	 * @param @return
	 * @param @throws Exception
	 * @return Result
	 * @author sky
	 * @date 2017年4月10日  下午4:02:02
	 */
	@PostMapping
	@ResponseBody
	public Result createUser(@RequestBody User req) throws Exception{
		userService.createUser(req);
		return  new Result();
	}
	/**
	 * Desc:编辑用户
	 * @param @param req
	 * @param @return
	 * @param @throws Exception
	 * @return Result
	 * @author sky
	 * @date 2017年4月10日  下午4:03:08
	 */
	@PutMapping
	@ResponseBody
	public Result editUser(@RequestBody User req) throws Exception{
		userService.updateUser(req);
		return  new Result();
	}
	
	@DeleteMapping
	@ResponseBody
	public Result delUser(@RequestParam(value="ids") List<Integer> req) throws Exception{
		userService.delUser(req);
		return  new Result();
	}
	
	/**
	 * Desc:用户登录
	 * @param @param req
	 * @param @return
	 * @param @throws Exception
	 * @return Result
	 * @author sky
	 * @date 2017年4月10日  下午4:01:15
	 */
	@PostMapping(value="/login")
	@ResponseBody
	public Result login(@RequestBody LoginReq req) throws Exception{
		logger.info("接收到了"+req.getUsername()+"的消息");
		return  new Result(userService.getAuth(req));
	}

	/**
	 * Desc:注销
	 * @param @param req
	 * @param @return
	 * @param @throws Exception
	 * @return Result
	 * @author sky
	 * @date 2017年4月10日  下午4:05:11
	 */
	@DeleteMapping(value="/login")
	@ResponseBody
	@Auth
	public Result loginout() throws Exception{
		logger.info("用户注销");
		userService.deleteAuth(LoginUserThread.getVoucher(), SourceEnum.manage.getDesc());
		return  new Result();
	}
	
	/**
	 * Desc:修改密码
	 * @param @param req
	 * @param @return
	 * @param @throws Exception
	 * @return Result
	 * @author sky
	 * @date 2017年4月10日  下午4:05:43
	 */
	@PutMapping(value="/passwd")
	@ResponseBody
	@Auth
	public Result chgPwd(@RequestBody ChangePwdReq req) throws Exception{
		logger.info("接收到了"+req.getLoginName()+"的消息");
		//用户修改密码流程
		userService.changePasswd(req);
		return  new Result();
	}
	/**
	 * Desc:重置密码
	 * @param @param id
	 * @param @return
	 * @param @throws Exception
	 * @return Result
	 * @author sky
	 * @date 2017年4月10日  下午4:05:43
	 */
	@PutMapping(value="/resetPwd")
	@ResponseBody
	@Auth
	public Result resetPwd(@RequestBody User req) throws Exception{
		userService.resetPasswd(req.getId());
		return  new Result();
	}
	/**
	 * Desc:获取用户列表(分页)
	 * @param @param pageIndex
	 * @param @param pageSize
	 * @param @return
	 * @param @throws Exception
	 * @return Result
	 * @author sky
	 * @date 2017年4月10日  下午4:06:13
	 */
	@GetMapping
	@ResponseBody
	public Result getUserList(UserReq req) throws Exception{
		//获取用户列表流程
		UserLtResp resp=userService.getUserLt(req);
		Result re = new Result(resp.getUserLt());
		re.setCount(resp.getCount());
		return re;
	}
	
	@GetMapping(value="/menu")
	@ResponseBody
	@Auth
	public Result getUserMenu() throws Exception{
		return  new Result(userService.getUserMenu());
	}
	
	@GetMapping(value="/authRedirect")
	public String auth() throws Exception{
		String authenticationUrl = MpOAuth2s.defaultOAuth2s().authenticationUrl(sysConfig.getAdminServer()+"/users/bind", "snsapi_base");
		return "redirect:"+authenticationUrl;
	}
	
	@GetMapping(value="/bind")
	public String bindWechat(String code,String state) throws Exception{
		CacheManager cache = CacheManager.getInstance();
		String cacheUrl = (String)cache.getValue(code);
		if(StringUtils.isEmpty(cacheUrl)){
			AccessToken accessToken = MpOAuth2s.defaultOAuth2s().getAccessToken(code);
			String url = sysConfig.getFrontServer()+"/#/?openId="+accessToken.getOpenId();
			if(!ValidateUtil.isEmpty(state)){
				url = url +"&index="+state;
			}
			cache.addOrUpdateCache(code, url);
			return "redirect:"+url;
		}else{
			return "redirect:"+cacheUrl;
		}
	}
	
	@PostMapping(value="/bind")
	@ResponseBody
	@Auth
	public Result doBindWechat(@RequestBody User req) throws Exception{
		Integer userId = LoginUserThread.getUser().getId();
		return new Result(userService.bindWechat(req.getOpenId(),userId));
	}
	
	/**
	 * 导出excel数据
	 * @param req
	 * @param request
	 * @param response
	 * @return 
	 * @throws Exception
	 * @author zbk
	 * @date 2017-06-02 17:44:00
	 */
	@GetMapping(value="export")
	public void exportXls(UserReq req,HttpServletRequest request, HttpServletResponse response) throws Exception {
		//获取数据
		Map<String, Object> model = new HashMap<String,Object>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		model.put(NormalExcelConstants.FILE_NAME,"用户信息表");
		model.put(NormalExcelConstants.CLASS,UserVo.class);
		model.put(NormalExcelConstants.PARAMS,new ExportParams("用户信息表", "导出时间:"+sdf.format(new Date()),"导出信息"));
		model.put(NormalExcelConstants.DATA_LIST,userService.queryForExport(req));
		ExcelUtils.exportDataToSingleExcel(model, request, response);
	}
}
