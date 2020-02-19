/*
    设计四个线程，两个加一，两个减一
 */
public class ThreadTest implements Runnable {

    private static int count;
    private int i = 0;

    @Override
    public void run() {
        i++;
        while (i < 100){
            if (Thread.currentThread().getName().startsWith("add")) {
                count++;
            } else if (Thread.currentThread().getName().startsWith("sub")) {
                count--;
            }
            System.out.println(count);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ThreadTest t = new ThreadTest();

        Thread t1 = new Thread(t,"add");
        Thread t2 = new Thread(t,"sub");
        Thread t3 = new Thread(t,"add");
        Thread t4 = new Thread(t,"sub");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
