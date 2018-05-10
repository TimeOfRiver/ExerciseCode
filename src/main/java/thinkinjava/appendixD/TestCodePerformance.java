package thinkinjava.appendixD;

/**
 * 检测代码性能
 *
 * @author luoyalan
 * @date 2018/5/8
 */
public class TestCodePerformance {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000000000; i++) {
            int j = 0;
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
