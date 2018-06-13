package effectiveJava.chap7;

import java.util.Date;

/**
 * ${DESCRIPTION}
 *
 * @author luoyalan
 * @date 2018/6/13
 */
// 看似不可变 其实是可变的
public final class Period {
    private final Date start;
    private final Date end;

    public Period(Date start, Date end) {
        if (start.compareTo(end) > 0) {
            throw new IllegalArgumentException(start + " after " + end);
        }
        this.start = start;
        this.end = end;
    }

    public Date getStart() {
        return start;
    }

    public Date getEnd() {
        return end;
    }

    @Override
    public String toString() {
        return start + " ~ " + end;
    }

    public static void main(String[] args) {
        Date start = new Date();
        Date end = new Date();

        Period period = new Period(start, end);
        System.out.println(period);
        end.setYear(78);// 违反了Period类的可变性
        System.out.println(period);
    }
}


final class PeriodV2 {
    private final Date start;
    private final Date end;

    public PeriodV2(Date start, Date end) {// 使用保护性拷贝之后 上述操作不再有效
        this.start = new Date(start.getTime());
        this.end = new Date(end.getTime());
        if (this.start.compareTo(this.end) > 0) { // 避免在危险阶段期间从另一个线程改变类的参数，危险阶段指从检查参数开始直到拷贝参数之间的时间段
            throw new IllegalArgumentException(start + " after " + end);
        }
    }

    public Date getStart() {// 防止p.getStart().setYear(87)此类攻击
        return new Date(start.getTime());
    }

    public Date getEnd() {
        return new Date(end.getTime());
    }
}