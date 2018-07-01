package effectiveJava.chap11;

import effectiveJava.chap7.Period;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

/**
 * ${DESCRIPTION}
 *
 * @author luoyalan
 * @date 2018/7/1
 */
public class SerializableOne {

    // 谨慎地实现Serializable接口：
    // （1）实现Serializable接口而付出的最大代价是，一旦一个类被发布，就大大降低了"改变这个类的实现"的灵活性
    // 流的唯一标识符,通常被称作序列版本UID（serial version UID）
    // 为了继承而设计的类应该尽可能少地去实现Serializable接口，用户的接口也应该尽可能少的基础Serializable接口，然而当需要加入某个框架时，是可以违反这个规则的
    // 对于为继承而设计的不可序列化的类，应该考虑提供一个无参构造器
    // 考虑使用自定义的序列化形式
    // 不管选择哪种序列化形式，都要显示的声明序列版本UID
    // private static final long serialVersionUID = randomLongValue;
    // 保护性地编写readObject方法
    // 对于实例控制，枚举类型优先于readResolve

    // 考虑用序列化代理代替序列化实例
    private static class SerializationProxy implements Serializable {
        private final Date start;
        private final Date end;

        SerializationProxy(Period p) {
            this.start = p.getStart();
            this.end = p.getEnd();
        }

        private static final long serialVersionUID = 23425435436546456L;

    }

    // 这个方法被添加到外围类中，通过序列化代理，这个方法可以逐字复制到任何类中
    //private Object writeReplace() {
    //    return new SerializationProxy(this);
    //}
    private void readObject(ObjectInputStream stream) throws InvalidObjectException {
        throw new InvalidObjectException("Proxy required");
    }
    //private Object readResolve() {
    //    return new Period(start,end);
    //}


    public static void main(String[] args) {

    }
}

//// 这是一个有问题的Singleton
//class Elvis implements Serializable {
//    public static final Elvis INSTANCE = new Elvis();
//    private  Elvis() {}
//
//    private String[] favoriteSongs = {"Hound Dog" , "HeartBreak Hotel"};
//    public void printFavorites() {
//        System.out.println(Arrays.toString(favoriteSongs));
//    }
//
//    private Object readObject() {
//        return INSTANCE;
//    }
//
//}
//
//// 盗用者类
//class ElvisStealer implements Serializable {
//    static Elvis impersonator;
//    private Elvis payload;
//
//    private Object readResolve() {
//        impersonator = payload;
//
//        return new String[] {"A Fool Such as I"};
//    }
//    private static final long serialVersionUID = 0;
//
//}

// 下面是把Elvis写成枚举的形式
enum Elvis {
    INSTANCE;
    private String[] favoriteSongs = {"Hound Dog", "Heartbreak Hotel"};

    public void printFavorites() {
        System.out.println(Arrays.toString(favoriteSongs));
    }
}

