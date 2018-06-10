package effectiveJava.chap6;

/**
 * 使用自定义注解
 *
 * @author luoyalan
 * @date 2018/6/10
 */
public class Sample {

    @Test
    public static void m1() {
        System.out.println("This is m1");
    } // success

    public static void m2() {
    }

    @Test
    public static void m3() {
        throw new RuntimeException("boom");
    } // fail

    public static void m4() {
        System.out.println("This is m4");
    }

    @Test
    public void m5() {
        System.out.println("This is m5");
    } // 无效的使用，因为是非静态方法

    public static void m6() {
    }

    @Test
    public static void m7() {
        throw new RuntimeException("Crash");
    }

}


