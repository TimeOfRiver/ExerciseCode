package effectiveJava.chap6;

import java.util.*;

/**
 * 用实例域代替序数
 *
 * @author luoyalan
 * @date 2018/6/10
 */
public class EnumTestV3 {
    public static void main(String[] args) {
        System.out.println(Ensemble.DECTET.numberOfMusicians());

        // 将EnumSet实例传递给applyStyles方法的客户端代码
        Text text = new Text();
        text.applyStyles(EnumSet.of(Text.Style.BOLD, Text.Style.ITALIC));

        // 用EnumMap代替序数索引
        Herb[] garden = new Herb[]{};// 测试数据暂未添加
        Map<Herb.Type, Set<Herb>> herbsByType = new EnumMap<Herb.Type, Set<Herb>>(Herb.Type.class);
        for (Herb.Type t : Herb.Type.values()) {
            herbsByType.put(t, new HashSet<Herb>());
        }
        for (Herb h : garden) {
            herbsByType.get(h.getType()).add(h);
            System.out.println(herbsByType);
        }
    }
}

// 用实例域代替序数
// 注意：大多数程序员都不需要ordinal方法，它是设计成用于像EnumSet和EnumMap这种基于枚举的通用数据结构的
enum Ensemble {
    SOLO(1), DUET(2), TRIO(3), QUAYTET(4), QUINTET(5),
    SEXTET(6), SEPTET(7), OCTET(8), NONET(9), DECTET(10);

    private final int numberOfMusicians;

    Ensemble(int size) {
        this.numberOfMusicians = size;
    }

    public int numberOfMusicians() {
        return numberOfMusicians;
    }
}

// 用EnumSet代替位域
class Text {
    public enum Style {BOLD, ITALIC, UNDERLINE, STRIKETHROUGH}

    public void applyStyles(Set<Style> styles) {
    }
}

// 用EnumMap代替序数索引 case one
class Herb {
    public enum Type {ANNUAL, PERENNIAL, BIENNIAL}

    private final String name;
    private final Type type;

    Herb(String name, Type type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String toString() {
        return name;
    }

    public Type getType() {
        return type;
    }
}

// 用EnumMap代替序数索引 case two
enum Phase {
    SOLID, LIQUID, GAS;

    enum Transition {
        MELT(SOLID, LIQUID), FREEZE(LIQUID, SOLID),
        BOIL(LIQUID, GAS), CONDENSE(GAS, LIQUID),
        SUBLIME(SOLID, GAS), DEPOSIT(GAS, SOLID);

        private final Phase src;
        private final Phase dst;

        Transition(Phase src, Phase dst) {
            this.src = src;
            this.dst = dst;
        }

        private static final Map<Phase, Map<Phase, Transition>> m = new EnumMap<Phase, Map<Phase, Transition>>(Phase.class);

        static {
            for (Phase p : Phase.values()) {
                m.put(p, new EnumMap<Phase, Transition>(Phase.class));
            }

            for (Transition trans : Transition.values()) {
                m.get(trans.src).put(trans.dst, trans);
            }
        }

        public static Transition from(Phase src, Phase dst) {
            return m.get(src).get(dst);
        }
    }
}