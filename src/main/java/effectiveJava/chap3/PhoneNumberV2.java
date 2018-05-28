package effectiveJava.chap3;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeSet;

/**
 * 重写equals方法时必须重写hashCode方法
 *
 * @author luoyalan
 * @date 2018/5/27
 */
public class PhoneNumberV2 {
    private final short areaCode;
    private final short prefix;
    private final short lineNumber;

    private volatile int hashCode;

    public PhoneNumberV2(int areaCode, int prefix, int lineNumber) {
        rangeCheck(areaCode, 999, "areaCode");
        rangeCheck(prefix, 999, "prefix");
        rangeCheck(lineNumber, 9999, "lineNumber");
        this.areaCode = (short) areaCode;
        this.prefix = (short) prefix;
        this.lineNumber = (short) lineNumber;
    }

    private static void rangeCheck(int arg, int max, String name) {
        if (arg < 0 || arg > max) {
            throw new IllegalArgumentException(name + " : " + arg);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        // 无需判空
        if (!(obj instanceof PhoneNumberV2)) {
            return false;
        }
        PhoneNumberV2 phoneNumber = (PhoneNumberV2) obj;
        return phoneNumber.lineNumber == this.lineNumber
                && phoneNumber.prefix == this.prefix
                && phoneNumber.areaCode == this.areaCode;
    }

    // 这种实现虽然满足要求，但是性能稍差，因为每次调用都要重新计算，可以考虑将hashCode值缓存起来；
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + areaCode;
        result = 31 * result + lineNumber;
        result = 31 * result + prefix;
        return result;
    }

    // 使用缓存hashCode方法
    public int hashCodeV2() {
        int result = hashCode;
        if (hashCode == 0) {
            result = 17;
            result = 31 * result + areaCode;
            result = 31 * result + lineNumber;
            result = 31 * result + prefix;
            hashCode = result;
        }
        return result;
    }

    @Override
    public String toString() {// 始终要覆盖toString方法
        return String.format("(%03d) %03d-%04d", areaCode, prefix, lineNumber);
    }

    public static void main(String[] args) {
        Map<PhoneNumberV2, String> map = new HashMap<PhoneNumberV2, String>();
        map.put(new PhoneNumberV2(707, 867, 5309), "Jenny");
        String name = map.get(new PhoneNumberV2(707, 867, 5309));
        System.out.println(name);
        System.out.println(new PhoneNumberV2(707, 867, 5309));

        // 考虑实现comparable接口
        HashSet<BigDecimal> hashSet1 = new HashSet<BigDecimal>();
        hashSet1.add(new BigDecimal("1.0"));
        hashSet1.add(new BigDecimal("1.00"));
        System.out.println(hashSet1);// 包含两个元素，因为添加时通过equals方法比较时两个对象是不相等的
        TreeSet<BigDecimal> treeSet1 = new TreeSet<BigDecimal>();
        treeSet1.add(new BigDecimal("1.0"));
        treeSet1.add(new BigDecimal("1.00"));
        System.out.println(treeSet1);// 包含一个元素，因为通过compareTo方法比较时两个对象是相等的
    }
}
