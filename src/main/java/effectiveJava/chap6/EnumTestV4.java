package effectiveJava.chap6;

import java.util.Arrays;
import java.util.Collection;

/**
 * 虽然无法编写可扩展的枚举类型，却可以通过编写接口以及实现该接口的基础枚举类型，对它进行模拟
 *
 * @author luoyalan
 * @date 2018/6/10
 */
public class EnumTestV4 {
    public static void main(String[] args) {
        double x = 2;
        double y = 4;
        test(ExtendedOperation.class, x, y);
        testV2(Arrays.asList(ExtendedOperation.values()), x, y);
    }

    private static <T extends Enum<T> & OperationV2> void test(Class<T> opSet, double x, double y) {
        for (OperationV2 operationV2 : opSet.getEnumConstants()) {
            System.out.printf("%f %s %f = %f%n", x, operationV2, y, operationV2.apply(x, y));
        }
    }

    private static void testV2(Collection<? extends OperationV2> opSet, double x, double y) {
        for (OperationV2 op : opSet) {
            System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
        }
    }
}

// 用接口模拟可伸缩的枚举
interface OperationV2 {
    double apply(double x, double y);
}

enum BasicOperation implements OperationV2 {
    PLUS("+") {
        @Override
        public double apply(double x, double y) {
            return x + y;
        }
    },
    MINUS("-") {
        @Override
        public double apply(double x, double y) {
            return x - y;
        }
    },
    TIMES("*") {
        @Override
        public double apply(double x, double y) {
            return x * y;
        }
    },
    DIVIDE("/") {
        @Override
        public double apply(double x, double y) {
            return x / y;
        }
    };

    private final String symbol;

    BasicOperation(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }
}

enum ExtendedOperation implements OperationV2 {

    EXP("^") {
        @Override
        public double apply(double x, double y) {
            return Math.pow(x, y);
        }
    },
    REMAINDER("%") {
        @Override
        public double apply(double x, double y) {
            return x % y;
        }
    };

    private final String symbol;

    ExtendedOperation(String symbol) {
        this.symbol = symbol;
    }


    @Override
    public String toString() {
        return symbol;
    }
}
