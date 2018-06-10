package effectiveJava.chap6;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * ${DESCRIPTION}
 *
 * @author luoyalan
 * @date 2018/6/10
 */
public class RunTests {
    public static void main(String[] args) {
        int tests = 0;
        int passed = 0;
        try {
            Class testClass = Class.forName("effectiveJava.chap6.Sample");
            for (Method m : testClass.getDeclaredMethods()) {
                if (m.isAnnotationPresent(Test.class)) {
                    tests++;
                    try {
                        m.invoke(null);
                        passed++;
                    } catch (InvocationTargetException e) {
                        Throwable exc = e.getCause();
                        System.out.println(m + " failed: " + exc);
                    } catch (Exception ex) {
                        System.out.println("INVALID @Test: " + m);
                    }
                }
            }
            System.out.printf("Passed: %d,Faild: %d%n", passed, tests - passed);
        } catch (Exception e) {
            System.out.println(e.getCause());
        }
    }
}
