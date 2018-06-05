package effectiveJava.chap5;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * （1）消除非受检异常
 * （2）列表优于数组
 *
 * @author luoyalan
 * @date 2018/6/5
 */
public class NoUncheckedConversion {
    public static void main(String[] args) {
        Set<Persion> set = new HashSet<Persion>();
        // 下面代码片段是合法的，但是会抛异常ArrayStoreException
        Object[] objects = new Long[1];
        objects[0] = "hello world!";
        // 下面这段代码都不允许编译通过
        //List<Object> objectList = new ArrayList<Long>();
        //objectList.add("hello world!");

    }
}

class Persion {
}
