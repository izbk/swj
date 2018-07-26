package cn.com.yuanwei.center.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/** 注解：标注即进行权限认证 */
@Documented							//文档化功能
@Inherited							//注解继承
@Target(ElementType.METHOD)			//使用范围：只允许修饰方法
@Retention(RetentionPolicy.RUNTIME)	//保持性策略：被加载时将被读取
public @interface Auth {

}