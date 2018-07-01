package thinkinjava.exercise.chap3;

/**
 * (1) 写一个程序，打印出 1 到 100 间的整数
 *
 * @author luoyalan
 * @date 2018/7/1
 */
public class Exercise341 {
    public static void main(String[] args) {
        new Exercise341().printOneToNum(100);
    }

    /**
     * 打印从1到num间的整数
     * @param num
     */
    public void printOneToNum(int num) {
        if (num < 1) {
            System.out.println(1);
            return;
        }
        for (int i = 1; i < num; i++) {
            if(i == 47) { // 练习2 当值为47时使用break 或 return
                break;
            }
            System.out.println(i);
        }
    }
}
