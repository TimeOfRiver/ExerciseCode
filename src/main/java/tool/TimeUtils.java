package tool;

import java.util.Calendar;
import java.util.Date;

/**
 * ${DESCRIPTION}
 *
 * @author luoyalan
 * @date 2018/5/22
 */
public class TimeUtils {
    public static Date getPreviousMonthFirstDay() {
        Calendar calendar1 = Calendar.getInstance();
        calendar1.add(Calendar.MONTH, -1);
        calendar1.set(Calendar.DAY_OF_MONTH, 1);
        // String firstDay = sdf.format(calendar1.getTime());
        return calendar1.getTime();

    }

    public static Date getPreviousMonthLastDay() {
        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(Calendar.DAY_OF_MONTH, 0);
        // String lastDay = sdf.format(calendar2.getTime());
        return calendar2.getTime();
    }

    public static void main(String[] args) {
        System.out.println(getPreviousMonthFirstDay());
        System.out.println(getPreviousMonthLastDay());
    }
}
