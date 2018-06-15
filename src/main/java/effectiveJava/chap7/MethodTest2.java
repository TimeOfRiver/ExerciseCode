package effectiveJava.chap7;

import java.util.Arrays;
import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author luoyalan
 * @date 2018/6/15
 */
public class MethodTest2 {
    public static void main(String[] args) {
        System.out.println(sum(1, 2, 3));
        System.out.println(sum());// 0

        // 此种方法推荐使用
        List<String> list = Arrays.asList("A", "B", "C");
        System.out.println(list);
    }

    // 慎用可变参数
    static int sum(int... args) {
        int sum = 0;
        for (int i : args) {
            sum += i;
        }
        return sum;
    }

    // 缺点：（1）当不传值时，出现异常是在运行期而不是编译期 （2）必须在args中包含显式的有效性检查
    static int min(int... args) {
        if (args == null || args.length == 0) {
            throw new IllegalArgumentException("args length is null");
        }
        int min = args[0];
        for (int arg : args) {
            if (min > arg) {
                min = arg;
            }
        }
        return min;
    }

    // 改进版本，可避免上述问题
    static int minV2(int firstArg, int... remainingArgs) {
        int min = firstArg;
        for (int arg : remainingArgs) {
            if (arg < min) {
                min = arg;
            }
        }
        return min;
    }
}


