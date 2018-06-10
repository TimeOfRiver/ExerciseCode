package effectiveJava.chap6;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 注解类型
 *
 * @author luoyalan
 * @date 2018/6/10
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Test {// 指定简单的测试，可自动运行，并在抛出异常时失败
}

