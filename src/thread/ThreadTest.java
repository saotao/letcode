package thread;

/**
 * Description
 * Date 2020-03-17 15:17
 */
public class ThreadTest {
    private int count = 0;

    private void add10k() {
        for (int i = 0; i < 10000; i++ ) {
            count++;
        }
    }

    public static void main(String[] args) throws InterruptedException {

        final ThreadTest threadTest = new ThreadTest();
        Thread thread1 = new Thread(threadTest::add10k);

        Thread thread2 = new Thread(threadTest::add10k);

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(threadTest.count);
    }
}
