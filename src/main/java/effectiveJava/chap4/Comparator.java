package effectiveJava.chap4;

import java.util.Arrays;

/**
 * 为了传递更多的比较类型，所以定义一个比较接口
 *
 * @author luoyalan
 * @date 2018/6/3
 */
public interface Comparator<T> {
    public int compare(T t1, T t2);
}

class StringLengthComparatorV3 implements Comparator<String> {
    private StringLengthComparatorV3() {
    }

    public static final StringLengthComparatorV3 INSTANCE = new StringLengthComparatorV3();

    @Override
    public int compare(String t1, String t2) {
        return t1.length() - t2.length();
    }
}

class Test {
    public static void main(String[] args) {
        String[] stringArray = {"q", "as", "fdg", "ab"};
        // 使用匿名类进行参数额传递，如果需要进行多次调用的话，建议将函数对象存储到一个私有的静态final域里，并重用它
        Arrays.sort(stringArray, new java.util.Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                //return o1.length() - o2.length();// 正序
                return o2.length() - o1.length();// 倒序
            }
        });
        for (int i = 0; i < stringArray.length; i++) {
            System.out.println(stringArray[i]);
        }
    }
}
