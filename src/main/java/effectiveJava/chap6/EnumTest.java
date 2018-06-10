package effectiveJava.chap6;

import java.util.HashMap;
import java.util.Map;

/**
 * 使用枚举替代常量
 *
 * @author luoyalan
 * @date 2018/6/10
 */
public class EnumTest {

    public static void main(String[] args) {
        System.out.println(Apple.FUJI.toString());

        // 根据某个物体在地球上的重量打印出该物体在所有8颗行星上的重量
        double earthWeight = 1;
        double mass = earthWeight / Planet.EARTH.getSurfaceGravity();
        for (Planet p : Planet.values()) {
            System.out.printf("Weight on %s is %f%n", p, p.getSufaceWeight(mass));
        }

        // 使用算术表达式
        double x = 2;
        double y = 4;
        for (Operation operation : Operation.values()) {
            System.out.printf("%f %s %f = %f%n", x, operation, y, operation.apply(x, y));
        }

    }
}

// 单例的泛型化
enum Apple {
    FUJI, PIPPIN, GRANNY_SMILE
}

enum Orange {NAVEL, TEMPLE, BLOOD}

enum Planet {
    MERCURY(3.302e+23, 2.439e6),
    VENUS(4.869e+24, 6.052e6),
    EARTH(5.975e+24, 6.378e6),
    MARS(6.419e+23, 3.393e6),
    JUPITER(1.899e+27, 7.149e7),
    SATURN(5.685e+26, 6.027e7),
    URANUS(8.683e+25, 2.556e7),
    UEPTUNE(1.024e+26, 2.477e7);

    private final double mass;
    private final double radius;
    private final double surfaceGravity;
    ;

    private static final double G = 6.67300E-11;

    Planet(double mass, double radius) {
        this.mass = mass;
        this.radius = radius;
        surfaceGravity = G * mass / (radius * radius);
    }

    public double getMass() {
        return mass;
    }

    public double getRadius() {
        return radius;
    }

    public double getSurfaceGravity() {
        return surfaceGravity;
    }

    public double getSufaceWeight(double mass) {
        return mass * surfaceGravity;
    }

}

enum Operation {
    PLUS("+") {
        @Override
        double apply(double x, double y) {
            return x + y;
        }
    },
    MINUS("-") {
        @Override
        double apply(double x, double y) {
            return x - y;
        }
    },
    TIMES("*") {
        @Override
        double apply(double x, double y) {
            return x * y;
        }
    },
    DIVIDE("/") {
        @Override
        double apply(double x, double y) {
            return x / y;
        }
    };

    private final String symbol;
    private static final Map<String, Operation> stringToEnum = new HashMap<String, Operation>();

    static {
        for (Operation op : Operation.values()) {
            stringToEnum.put(op.toString(), op);
        }
    }

    public static Operation fromString(String symbol) {
        return stringToEnum.get(symbol);
    }

    Operation(String symbol) {
        this.symbol = symbol;
    }

    abstract double apply(double x, double y);

    @Override
    public String toString() {
        return symbol;
    }
}

