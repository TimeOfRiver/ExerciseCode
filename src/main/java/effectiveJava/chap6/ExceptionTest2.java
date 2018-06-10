package effectiveJava.chap6;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 只针对异常类型的注解
 *
 * @author luoyalan
 * @date 2018/6/10
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ExceptionTest2 {
    Class<? extends Exception>[] value();
}
