package cn.com.yuanwei.center.aop;

import java.util.Arrays;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import cn.com.yuanwei.center.util.CommonUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
/**
 * 接口日志记录
 * @author sky
 *
 */
@Aspect
@Component
public class WebLogAspect {
	 private Log logger =  LogFactory.getLog(this.getClass());
	   
	    ThreadLocal<Long> startTime = new ThreadLocal<Long>();
	   
	    /**
	     * 定义一个切入点.
	     * 解释下：
	     *
	     * ~ 第一个 * 代表任意修饰符及任意返回值.
	     * ~ 第二个 * 任意包名
	     * ~ 第三个 * 代表任意方法.
	     * ~ 第四个 * 定义在web包或者子包
	     * ~ 第五个 * 任意方法
	     * ~ .. 匹配任意数量的参数.
	     */
	     @Pointcut("execution(public * cn.com.yuanwei.*.web..*.*(..))")
	     public void webLog(){}
	     
	     @Before("webLog()")
	     public void doBefore(JoinPoint joinPoint){
	        startTime.set(System.currentTimeMillis());
	       // 接收到请求，记录请求内容
	        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
	         HttpServletRequest request = attributes.getRequest();
	        
	        
	      // 记录下请求内容
	        logger.info("请求URL : " + request.getRequestURL().toString());
	        logger.info("请求方式 : " + request.getMethod());
	        logger.info("请求IP : " + CommonUtils.getIpAddress(request));
	        logger.info("请求方法 : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
	        logger.info("方法接收参数 : " + Arrays.toString(joinPoint.getArgs()));
	       //获取所有参数方法一：
	        Enumeration<String> enu=request.getParameterNames(); 
	        while(enu.hasMoreElements()){ 
	            String paraName=(String)enu.nextElement(); 
	            logger.info("请求传递参数:"+paraName+": "+request.getParameter(paraName));
	        } 
	     }
	     
	     @AfterReturning(returning = "ret",pointcut="webLog()")
	     public void  doAfterReturning(Object ret) throws JsonProcessingException{
	       // 处理完请求，返回内容
	    	 ObjectMapper mapper = new ObjectMapper();
	    	 logger.info("接口返回 : " + mapper.writeValueAsString(ret));
	    	 
	        logger.info("耗时（毫秒） : " + (System.currentTimeMillis() - startTime.get()));
	     }
}
