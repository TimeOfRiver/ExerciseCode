package effectiveJava.chap6;

/**
 * 使用捕捉特定异常的注解
 *
 * @author luoyalan
 * @date 2018/6/10
 */
public class Sample2 {

    @ExceptionTest(ArithmeticException.class)
    public static void m1() {// pass
        int i = 0;
        i = i / i;
    }

    @ExceptionTest(ArithmeticException.class)
    public static void m2() {// fail
        int[] a = new int[0];
        int i = a[1];
    }

    @ExceptionTest(ArithmeticException.class)
    public static void m3() {// fail
    }

}
