package effectiveJava.chap3;

import java.util.HashMap;
import java.util.Map;

/**
 * 重写equals方法必须同时重写hashCode方法
 *
 * @author luoyalan
 * @date 2018/5/26
 */
public final class PhoneNumber {
    private final short areaCode;
    private final short prefix;
    private final short lineNumber;

    public PhoneNumber(int areaCode, int prefix, int lineNumber) {
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
        if (!(obj instanceof PhoneNumber)) {
            return false;
        }
        PhoneNumber phoneNumber = (PhoneNumber) obj;
        return phoneNumber.lineNumber == this.lineNumber
                && phoneNumber.prefix == this.prefix
                && phoneNumber.areaCode == this.areaCode;
    }

    public static void main(String[] args) {
        Map<PhoneNumber, String> map = new HashMap<PhoneNumber, String>();
        map.put(new PhoneNumber(707, 867, 5309), "Jenny");
        // 得到的肯定是null，因为PhoneNumber类的hasaCode方法未重写，使用了Object的hashCode方法，导致两个本应相等的实例拥有不同的hashCode
        String name = map.get(new PhoneNumber(707, 867, 5309));
        System.out.println(name);
    }
}
