package ma;

import java.util.Calendar;
import java.util.Date;

public class CalendarTest {

    public static void main(String[] args) {
        Date date = ma.DateUtil.getDateByDateStr("1970-1-1 11:00:00","yyyy-MM-dd HH:mm:ss");
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        long l = System.currentTimeMillis();

        long i  =l/(24*60*60*1000);

        instance.add(Calendar.DATE, (int) i);

        System.out.println(instance.getTime());
        System.out.println(DateUtil.getFormatTime(instance.getTime(),"yyyy-MM-dd HH_mm_ss"));
    }
}
