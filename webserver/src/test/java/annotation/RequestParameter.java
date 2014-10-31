package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface RequestParameter {

	/**
	 * 请求参数名字
	 * @return
	 */
	String name() ;
	/**
	 * 请求参数值
	 * @return
	 */
	String value() ;

}
