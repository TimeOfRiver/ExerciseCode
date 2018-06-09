package effectiveJava.chap5;

import java.util.*;

/**
 * 优先使用泛型，对于静态方法，尤其应该如此
 *
 * producer-extends consumer-super(PECS):所有的comparable和comparator都是消费者
 *
 * @author luoyalan
 * @date 2018/6/9
 */
public class CollectionTestV2 {

    /**
     * 对方法使用泛型
     *
     * @param s1
     * @param s2
     * @param <E>
     * @return
     */
    public static <E> Set<E> union(Set<? extends E> s1, Set<? extends E> s2) {
        Set<E> newSet = new HashSet<E>(s1);
        newSet.addAll(s2);
        return newSet;
    }

    // 泛型静态工厂方法来消除定义时的冗余
    public static <K, V> HashMap<K, V> newHashMap() {
        return new HashMap<K, V>();
    }

    // 使用泛型单例
    private static UnaryFunction<Object> IDENTITY_FUNCTIONI = new UnaryFunction<Object>() {
        @Override
        public Object apply(Object arg) {
            return arg;
        }
    };

    @SuppressWarnings("unchecked")
    public static <T> UnaryFunction<T> identityFunction() {
        return (UnaryFunction<T>) IDENTITY_FUNCTIONI;
    }

    // 使用泛型方法查找集合最大值
    public static <T extends Comparable<? super T>> T max(List<? extends T> list) {
        Iterator<? extends T> i = list.iterator();
        T result = i.next();
        while (i.hasNext()) {
            T t = i.next();
            if (t.compareTo(result) > 0) {
                result = t;
            }
        }
        return result;
    }

    public static void swap(List<?> list, int i, int j) {
        swapHelper(list, i, j);
    }

    private static <E> void swapHelper(List<E> list, int i, int j) {
        list.set(i, list.set(j, list.get(i)));
    }

    public static void main(String[] args) {
        Set<String> s1 = new HashSet<String>(Arrays.asList("A", "B", "C"));
        Set<String> s2 = new HashSet<String>(Arrays.asList("D", "E", "F"));
        Set<String> all = union(s1, s2);
        System.out.println(all);


        Map<String, String> map = newHashMap();


        String[] strings = {"jute", "hemp", "nylon"};
        UnaryFunction<String> sameString = identityFunction();
        for (String s : strings) {
            System.out.println(sameString.apply(s));
        }

        Number[] numbers = {1, 2.0, 3L};
        UnaryFunction<Number> sameNumber = identityFunction();
        for (Number number : numbers) {
            System.out.println(sameNumber.apply(number));
        }


        List<Integer> integerList = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4));
        swap(integerList, 1, 2);
        System.out.println(integerList.toString());

    }
}
