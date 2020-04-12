package javatest.arraytest;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Description 线程
 * Date 2019-10-22 16:09
 */
public class ThreadTest {
    private static int i = 1;

    public static void main(String[] args) {

        Thread thread1 = new Thread(() -> {
            int k = 0;
            while (k < 100) {
                System.out.println("1111-"+(++i));
                k++;
            }
        });
        Thread thread2 = new Thread(() -> {
            int k = 0;
            while (k < 100) {
                System.out.println("2222-"+(--i));
                k++;
            }
        });

        thread1.start();
        thread2.start();
    }
}
