package thinkinjava.exercise.chap4;

import java.util.ArrayList;
import java.util.List;

/**
 * ${DESCRIPTION}
 *
 * @author luoyalan
 * @date 2018/7/4
 */
public class Exercise471 {
    // 用默认构建器创建一个类（没有自变量），用它打印一条消息。创建属于这个类的一个对象


    public Exercise471() {
        System.out.println("This is  Exercise471");
    }

    public Exercise471(String name) {
        System.out.println("This is Exercise471: " + name);
    }

    public static void main(String[] args) {
        Exercise471 e = new Exercise471();
        Exercise471 e2 = new Exercise471("Neo");

        List<Exercise471> exercise = new ArrayList<Exercise471>();
        exercise.add(new Exercise471("Neo"));
        exercise.add(new Exercise471("Java"));
        exercise.add(new Exercise471("Python"));

    }

}
