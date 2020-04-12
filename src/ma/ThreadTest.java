package ma;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Description ddd
 * Date 2020-01-07 10:46
 */
public class ThreadTest {

    public static void main(String[] args) throws Exception{
        AtomicInteger i = new AtomicInteger();
        final boolean[] lock = {true};
        Thread thread = new Thread(() -> {
            while (true) {
                if (lock[0]) {
                    System.out.println("1___" + i.getAndIncrement());
                    lock[0] = !lock[0];
                }
            }
        });
        Thread thread1 = new Thread(() -> {
            while (true) {
                if (!lock[0]) {
                    System.out.println("2___" + i.getAndIncrement());
                    lock[0] = !lock[0];
                }
            }
        });
//        thread.setUncaughtExceptionHandler((t, e) -> {
//            System.out.println(t.getName());
//            e.printStackTrace();
//        });
        thread.start();
        thread1.start();

    }
}
