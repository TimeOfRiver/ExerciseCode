package effectiveJava.chap6;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用捕捉特定异常的注解2
 *
 * @author luoyalan
 * @date 2018/6/10
 */
public class Sample3 {

    @ExceptionTest2({IndexOutOfBoundsException.class,NullPointerException.class})
    public static void doublyBad(){
        List<String> list = new ArrayList<String>();
        list.addAll(5,null);

    }
}
