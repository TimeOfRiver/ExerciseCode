package other;

/**
 * ${DESCRIPTION}
 *
 * @author luoyalan
 * @date 2018/6/19
 */
public class Algorithm {

    /**
     * 使用辗转相除法求最大公约数（）
     *
     * @return
     */
    public static int getGCD(int a, int b) {
        int temp;
        while (a % b != 0) {
            temp = b;
            b = a % b;
            a = temp;
        }
        return b;
    }

    // 辗转相除法：递归形式
    public static int getGCDV2(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        return getGCDV2(b, a % b);
    }

    public static void main(String[] args) {
        System.out.println(getGCD(48, 32));
        System.out.println(getGCDV2(48, 32));
    }
}
