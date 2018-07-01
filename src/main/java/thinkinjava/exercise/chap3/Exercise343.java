package thinkinjava.exercise.chap3;

/**
 * 创建一个 switch 语句，为每一种 case 都显示一条消息。
 * 并将 switch 置入一个 for 循环里， 令其尝试每一种 case。
 * 在每个 case 后面都放置一个 break，并对其进行测试。然后，删除 break，看看会有什么情况出现。
 *
 * @author luoyalan
 * @date 2018/7/1
 */
public class Exercise343 {
    public static void main(String[] args) {
        for (int i = 1; i < 10; i++) {
            testSwitch(i);
        }
    }

    public static void testSwitch(int day) {
        switch (day) {
            case 1:
                System.out.println("星期一");
                break;
            case 2:
                System.out.println("星期二");
                break;
            case 3:
                System.out.println("星期三");
                break;
            case 4:
                System.out.println("星期四");
                break;
            case 5:
                System.out.println("星期五");
                break;
            case 6:
                System.out.println("星期六");
                break;
            case 7:
                System.out.println("星期日");
                break;
            default:
                System.out.println("unknow day");
        }
    }
}

