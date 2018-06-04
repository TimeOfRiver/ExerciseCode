package effectiveJava.chap4;

import java.io.Serializable;

/**
 * 使用策略模式的比较器,使用场景是需要重复使用时，如果只使用一次那么使用匿名比较器就好
 *
 * @author luoyalan
 * @date 2018/6/3
 */
public class Host {

    private static class StrLenCmp implements Comparator<String>, Serializable {
        public int compare(String s1, String s2) {
            return s1.length() - s2.length();
        }

        // 通过此域导出一个可被序列化的比较类
        public static final Comparator<String> STRING_LENGTH_COMPARATOR = new StrLenCmp();
    }
}
