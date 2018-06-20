package effectiveJava.chap7;


import java.math.BigInteger;
import java.util.*;

/**
 * ${DESCRIPTION}
 *
 * @author luoyalan
 * @date 2018/6/14
 */
public class MethodTest {

    public static void main(String[] args) {
        Collection<?>[] collections = {
                new HashSet<String>(),
                new ArrayList<BigInteger>(),
                new HashMap<String, String>().values()
        };

        for (Collection<?> c : collections) {
            System.out.println(CollectionClassifier.classify(c));
        }
        // V1
        //// 希望程序去除非负整数，但是结果却不是所想，产生混乱
        //Set<Integer> set = new TreeSet<Integer>();
        //List<Integer> list = new ArrayList<Integer>();
        //for(int i = -3; i < 3; i++) {
        //    set.add(i);
        //    list.add(i);
        //}
        //
        //for(int i = 0; i < 3; i++) {
        //    set.remove(i);
        //    list.remove(i);
        //}
        //
        //System.out.println(set + " " + list);// [-3, -2, -1] [-2, 0, 2]

        // V2 改进版
        Set<Integer> set = new TreeSet<Integer>();
        List<Integer> list = new ArrayList<Integer>();
        for (int i = -3; i < 3; i++) {
            set.add(i);
            list.add(i);
        }

        for (int i = 0; i < 3; i++) {
            set.remove(i);
            list.remove((Integer) i);

        }

        System.out.println(set + " " + list);// [-3, -2, -1] [-3, -2, -1]
    }

    // 谨慎地选择方法的名称
    // 不要过于追求提供便利的方法
    // 避免过长的参数列表:
    // (1)把方法分解成多个方法，缺点是导致方法变多
    //（2）创建辅助类，用来保存参数的分组
    // (3) 从对象构建到方法调用都采用Builder模式
    //  对于参数类型，要优先使用接口，而不是类
    //  对于boolean参数，要优先使用两个元素的枚举
    //  谨慎重载
    //  返回类型为数组或集合的方法没理由返回null，而不是返回一个零长度的数组或者集合
    //  为所有导出的API元素编写文档注释
}

enum TemperatureScale {FAHREHEIT, CELSIUS}

// 慎用重载
class CollectionClassifier {
    public static String classify(Set<?> s) {
        return "set";
    }

    public static String classify(List<?> list) {
        return "list";

    }

    public static String classify(Collection<?> c) {
        return "Unknown Collection";

    }
}