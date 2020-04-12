package other;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Description
 * Date 2019-11-08 14:27
 */
public class PossibleReordering {
    private static int x = 0, y = 0;
    private static int a = 0, b = 0;

    private static Pattern pattern = Pattern.compile("^(a+)+$");

    public static void main(String[] args) throws InterruptedException {

//        Thread one = new Thread(() -> {
//            a = 1;
//            x = b;
//        });
//        Thread other = new Thread(() -> {
//            b = 1;
//            y = a;
//        });
//        other.start();
//        one.start();
//
//        one.join();
//        other.join();
//        System.out.println(x + ":" + y);
        System.out.println(System.currentTimeMillis());
        Matcher aaaaaaaaaaaaaaX = pattern.matcher("aaaaaaaaaaaaaaaaaaaaaaaaaaaX");
        boolean matches = aaaaaaaaaaaaaaX.matches();

        System.out.println(matches + "" + System.currentTimeMillis());

        //
        System.out.println(System.currentTimeMillis());
        Matcher aaaaaaaaaaaaaaaaax = pattern.matcher("aaaaaaaaaaaaaaaX");
        aaaaaaaaaaaaaaaaax.matches();
        System.out.println(matches + ""+System.currentTimeMillis());
    }
}
