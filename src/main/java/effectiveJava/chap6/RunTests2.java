package effectiveJava.chap6;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * ${DESCRIPTION}
 *
 * @author luoyalan
 * @date 2018/6/10
 */
public class RunTests2 {
    public static void main(String[] args) {
        int tests = 0;
        int passed = 0;
        try {
            Class testClass = Class.forName("effectiveJava.chap6.Sample2");
            for (Method m : testClass.getDeclaredMethods()) {
                if (m.isAnnotationPresent(ExceptionTest.class)) {
                    tests++;
                    try {
                        m.invoke(null);
                        System.out.printf("Test %s failed: no exception%n",m);
                    } catch (InvocationTargetException e) {
                        Throwable exc = e.getCause();
                        Class<? extends Exception> excType = m.getAnnotation(ExceptionTest.class).value();
                        if(excType.isInstance(exc)) {
                            passed++;
                        } else {
                            System.out.printf("Test %s failed: expected %s , got %s%n",m,excType.getName(),exc);
                        }
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
