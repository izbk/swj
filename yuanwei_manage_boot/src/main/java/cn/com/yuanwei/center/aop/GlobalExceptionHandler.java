package cn.com.yuanwei.center.aop;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.yuanwei.center.enums.ReturnInfoEnum;
import cn.com.yuanwei.center.util.ValidateUtil;
import cn.com.yuanwei.center.web.response.base.Result;

/**
 * 统一异常处理
 * @author sky
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler {
	Log logger = LogFactory.getLog(GlobalExceptionHandler.class);
	@ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result jsonErrorHandler(HttpServletRequest req, Exception e) throws Exception {
		logger.error(e.getMessage(), e);
		Result r = new Result();
		if(e.getMessage()!=null){
			try{
				ReturnInfoEnum re = ReturnInfoEnum.valueOf(e.getMessage());
				r.setCode(re.getCode());
				r.setMessage(re.getDesc());
			}catch(Exception f){
				if(!ValidateUtil.isEmpty(e.getMessage())&&e.getMessage().length()>50){
					r.setMessage(ReturnInfoEnum.UnknownError.getDesc());
				}else{
					r.setMessage(e.getMessage());
				}
		        r.setCode(ReturnInfoEnum.UnknownError.getCode());
			}
		}else{
	        r.setMessage(ReturnInfoEnum.UnknownError.getDesc());
	        r.setCode(ReturnInfoEnum.UnknownError.getCode());
		}
        return r;
    }
}
