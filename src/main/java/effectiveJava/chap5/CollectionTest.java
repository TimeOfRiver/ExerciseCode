package effectiveJava.chap5;

import java.util.Set;

/**
 * 不要在新代码中使用原生类型
 *
 * @author luoyalan
 * @date 2018/6/4
 */
public class CollectionTest {

    /**
     * 使用原生类型，是不安全的
     *
     * @param s1
     * @param s2
     * @return
     */
    static int numElementsInCommon(Set s1, Set s2) {
        int result = 0;
        for (Object o1 : s1) {
            if (s2.contains(o1)) {
                result++;
            }
        }
        return result;
    }

    /**
     * 使用无限制的通配符类型，下面的例子是Set<E>的无限制通配符类型，使用此类型是安全的
     *
     * @param s1
     * @param s2
     * @return
     */
    static int numElementsInCommonV2(Set<?> s1, Set<?> s2) {
        int result = 0;
        for (Object o1 : s1) {
            if (s2.contains(o1)) {
                result++;
            }
        }
        return result;
    }

}
