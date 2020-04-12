package thread;

/**
 * Description
 * Date 2020-03-19 17:25
 */
public class VolatileTest {

    private int x = 2;

    private int m = 0;

    private void addX() {
        for (int i = 0; i < 100000; i++) {
            synchronized (this) {
                System.out.println(x++);
            }
        }
    }

    private void fuzhi() {
        m =42;
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileTest volatileTest = new VolatileTest();
        Thread thread1 = new Thread(() -> {
            volatileTest.addX();
        });
        Thread thread2 = new Thread(() -> {
            volatileTest.addX();
        });
        thread1.wait();
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println();
    }
}
