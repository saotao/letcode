package ma;

/*
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
*/

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    public static final long FOUR_HOUR_TIME = 4 * 60 * 60 * 1000;
    public static final long ONE_DAY_TIME = 24 * 60 * 60 * 1000;
//    private static Logger logger = LoggerFactory.getLogger(DateUtil.class);
    public static final String DEFAULT_PATTERN = "yyyy-MM-dd HH:mm:ss";
    public static final String GPS_DATE_PATTERN = "yyMMddHHmmss";
    public static final String DEFAULT_PATTERN_FORMAT ="yyyyMMddHHmmss";
    public static final String GPS_DATE_PATTERN_FORMAT = "yyMMddHHmmss";
    public static final String NEW_CAR_STATUS_BATCH_NO_FORMAT = "yyyyMMddHH";

    public static long getTimeByDateStr(String dateStr, String pattern) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat(pattern);
            Date date = formatter.parse(dateStr);
            return date.getTime();
        } catch (ParseException e) {
//            logger.error("【DateUtil】日期解析异常，param:{}, pattern:{}", dateStr, pattern);
        }
        return 0;
    }

    public static long getTimeByDateStrDoubleCheck(String dateStr, String pattern1, String pattern2) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat(pattern1);
            Date date = formatter.parse(dateStr);
            return date.getTime();
        } catch (ParseException e) {
            try {
                SimpleDateFormat formatter = new SimpleDateFormat(pattern2);
                Date date = formatter.parse(dateStr);
                return date.getTime();
            } catch (ParseException ee) {
//                logger.error("【DateUtil】日期解析异常，param:{}, pattern1:{}, pattern2:{}", dateStr, pattern1, pattern2);
            }
        }
        return 0;
    }

    public static Date getDateByDateStr(String dateStr, String pattern) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat(pattern);
            return formatter.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
//            logger.error("【DateUtil】日期解析异常，param:{}, pattern:{}", dateStr, pattern);
        }
        return null;
    }

    public static boolean isMoreThanOneMonth(Date date) {
        Calendar oneMonthAgoCalendar = Calendar.getInstance();
        oneMonthAgoCalendar.add(Calendar.MONTH, -1);
        Date oneMonthAgoDate = oneMonthAgoCalendar.getTime();
        return date.before(oneMonthAgoDate);
    }

    public static Date getDateByTime(long time) {
        return new Date(time);
    }

    public static String getFormatTime(Date date, String pattern) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        return dateFormat.format(date);
    }

    public static String getNowFormatTime(String pattern) {
        return getFormatTime(new Date(), pattern);
    }

    public static String getDataByTimestamps(long time, String pattern) {
        Date date = new Date(time);
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        return formatter.format(date);
    }

    /*
    将时间转换为byte[]格式的yyMMddhhmmss
     */
    public static byte[] getByteByDate(Date date) {
        String dateStr = getFormatTime(date, GPS_DATE_PATTERN);
        int yy = Integer.parseInt(dateStr.substring(0, 2));
        int MM = Integer.parseInt(dateStr.substring(2, 4));
        int dd = Integer.parseInt(dateStr.substring(4, 6));
        int hh = Integer.parseInt(dateStr.substring(6, 8));
        int mm = Integer.parseInt(dateStr.substring(8, 10));
        int ss = Integer.parseInt(dateStr.substring(10, 12));
        byte[] ans = new byte[6];
        ans[0] = (byte)yy;
        ans[1] = (byte)MM;
        ans[2] = (byte)dd;
        ans[3] = (byte)hh;
        ans[4] = (byte)mm;
        ans[5] = (byte)ss;
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(getDateByTime(1546481527000l).toString());

        String formatTime = getFormatTime(getDateByTime(1546481527000l), DEFAULT_PATTERN);
        String formatTime1 = getFormatTime(getDateByTime(1546481527000l), "yyyy-mm-dd");
        System.out.println(formatTime);
        System.out.println(formatTime1);

    }


}
