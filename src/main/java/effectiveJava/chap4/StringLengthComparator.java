package effectiveJava.chap4;

/**
 * 此类的实例被称为函数对象，一般用于在方法中传递，等同于一个指向改方法的指针
 *
 * @author luoyalan
 * @date 2018/6/3
 */
public class StringLengthComparator {
    public int compare(String s1,String s2){
        return  s1.length() - s2.length();
    }
}


