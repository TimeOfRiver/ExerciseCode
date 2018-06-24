package effectiveJava.chap8;

import effectiveJava.chap4.Comparator;

import java.math.BigDecimal;

/**
 * ${DESCRIPTION}
 *
 * @author luoyalan
 * @date 2018/6/20
 */
public class ProgramDesignV2 {
    // 如果需要精确的答案 请避免使用float和double，尤其用于货币计算时

    public static void main(String[] args) {
        System.out.println(1.03 - .42);

        final BigDecimal TEN_CENTS = new BigDecimal(".10");
        int itemsBought = 0;
        BigDecimal funds = new BigDecimal("1.00");
        for (BigDecimal price = TEN_CENTS;
             funds.compareTo(price) >= 0;
             price = price.add(TEN_CENTS)) {
            itemsBought++;
            funds = funds.subtract(price);
        }
        System.out.println(itemsBought + " items bought.");
        System.out.println("Money left over: $" + funds);

        // 基本类型优先与装箱基本类型
        Comparator<Integer> naturalOrder = new Comparator<Integer>() {
            @Override
            public int compare(Integer t1, Integer t2) {
                int s1 = t1;
                int s2 = t2;
                return s1 < s2 ? -1 : (s1 == s2 ? 0 : 1);
            }
        };
        System.out.println(naturalOrder.compare(1, 2));
        System.out.println(naturalOrder.compare(new Integer(1), new Integer(2)));

        // 如果其他类型更合适，则尽量避免使用字符串

        /**
         * 字符串不适合代替其他的值类型
         * 字符串不适合代替枚举类型
         * 字符串不适合代替聚集类型
         * 字符串不适合代替能力表
         */

        // 当心字符串连接的性能：不适合用在大规模的场景中，为连接n个字符串而重复地使用字符串连接操作符，需要n的平方级的时间，请使用StringBuilder

        // 通过接口引用对象

        // 接口优先于反射机制，反射的缺点：丧失了编译时的类型检查；执行反射访问所需的代码非常笨拙和冗长；性能损失

        // 谨慎地使用本地方法

        // 谨慎地进行优化，要努力编写好的程序而不是快的程序，好的模块体现了信息隐藏

        // 要考虑API设计决策的性能后果

        // 遵守普遍接受的命名惯例：字面的、语法的


    }
}

final class ThreadLocal<T> {
    public ThreadLocal() {
    }

    public void set(T value) {
    }
    //public T get(){return T;}
}
