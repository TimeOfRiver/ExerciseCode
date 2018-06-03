package effectiveJava.chap4;

/**
 * 特别注意：接口一旦发行，并且被广泛使用，那么再想改动这个接口几乎是不可能的
 * 接口只用于定义类型，下面做法不推荐使用
 *
 * @author luoyalan
 * @date 2018/6/3
 */
public interface PhysicalConstants {
    // 常量接口模式是对接口的不良使用
    // Avogadro's number(1/mol)
    static final double AVOGADROS_NUMBER = 6.02214199e23;

}
