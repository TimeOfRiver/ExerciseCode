package effectiveJava.chap4;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

/**
 * 组合优于继承，此为反面教材
 * 继承机制会把超类的缺陷也带到子类中，而复合允许设计新的API来隐藏这些缺陷
 *
 * @author luoyalan
 * @date 2018/5/28
 */
public class InstrumentedHashSet<E> extends HashSet<E> {

    private int addCount = 0;

    public InstrumentedHashSet() {
    }

    public InstrumentedHashSet(int initCap, float loadFactory) {
        super(initCap, loadFactory);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        addCount += c.size();
        return super.addAll(c);
    }

    @Override
    public boolean add(E e) {
        addCount++;
        return super.add(e);
    }

    public int getAddCount() {
        return addCount;
    }

    public static void main(String[] args) {
        InstrumentedHashSet<String> instrumentedHashSet = new InstrumentedHashSet<String>();
        instrumentedHashSet.addAll(Arrays.asList("a","b","c"));
        System.out.println(instrumentedHashSet.getAddCount()); // 结果并不是3，而是6，因为addAll方法的内部实现依赖于add方法
    }

}
