package effectiveJava.chap8;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

/**
 * ${DESCRIPTION}
 *
 * @author luoyalan
 * @date 2018/6/19
 */
public class ProgramDesign {
    // 将局部变量的作用域最小化:要使局部变量的作用域最小化，最有力的方法就是在第一次使用它的地方声明
    // for-each循环优于传统的for循环
    public static void main(String[] args) {
        Collection<Face> collection = Arrays.asList(Face.values());
        // 存在问题，打印如下
        //ONE ONE
        //TWO TWO
        //THREE THREE
        //FOUR FOUR
        //FIVE FIVE
        //SIX SIX
        //for (Iterator<Face> i = collection.iterator(); i.hasNext(); ) {
        //    for (Iterator<Face> j = collection.iterator(); j.hasNext(); ) {
        //        System.out.println(i.next() + " " + j.next());
        //    }
        //}

        // 可以解决问题 但是代码不美观
        //for (Iterator<Face> i = collection.iterator(); i.hasNext(); ) {
        //    Face face = i.next();
        //    for (Iterator<Face> j = collection.iterator(); j.hasNext(); ) {
        //        System.out.println(face + " " + j.next());
        //    }
        //}

        // 完美解决问题
        for (Face face : collection) {// 可以遍历任何实现Iterable接口的对象
            for (Face face2 : collection) {
                System.out.println(face + " " + face2);
            }
        }

    }

    enum Face {ONE, TWO, THREE, FOUR, FIVE, SIX}
}
