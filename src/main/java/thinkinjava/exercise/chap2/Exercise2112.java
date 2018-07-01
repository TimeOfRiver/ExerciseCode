package thinkinjava.exercise.chap2;

/**
 * ${DESCRIPTION}
 *
 * @author luoyalan
 * @date 2018/7/1
 */
// 写一个程序，打印出从命令行获取的三个自变量
public class Exercise2112 {
    public static void main(String[] args) {
        if (args == null || args.length < 1) {
            System.out.println("args is null or length is 0");
        }
        for (String s : args) {
            System.out.println(s);
        }
    }
}
