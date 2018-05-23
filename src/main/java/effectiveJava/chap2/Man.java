package effectiveJava.chap2;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * 避免创建不必要的对象
 *
 * @author luoyalan
 * @date 2018/5/23
 */
public class Man {

    private final Date birthDate;

    private static final Date BOOM_START;
    private static final Date BOOM_END;

    static {// 避免频繁的创建对象
        Calendar gmtCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        gmtCal.set(1946, Calendar.JANUARY, 1, 0, 0, 0);
        BOOM_START = gmtCal.getTime();
        gmtCal.set(1965, Calendar.JANUARY, 1, 0, 0, 0);
        BOOM_END = gmtCal.getTime();
    }

    public Man(Date date) {
        birthDate = date;
    }

    public boolean isBabyBoomer() {
        return birthDate.compareTo(BOOM_START) >= 0 && birthDate.compareTo(BOOM_END) < 0;
    }


}
