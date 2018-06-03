package effectiveJava.chap4;

/**
 * 此类作为一个具体策略类，是无状态的（stateless），没有域，所以作为一个Singleton是很适合的
 * 缺点：客户端将无法出传递更多的比较策略，必须定义比较策略接口
 *
 * @author luoyalan
 * @date 2018/6/3
 */
public class StringLengthComparatorV2 {
    private StringLengthComparatorV2() {
    }

    public static final StringLengthComparatorV2 INSTANCE = new StringLengthComparatorV2();

    public int compare(String s1, String s2) {
        return s1.length() - s2.length();
    }
}
