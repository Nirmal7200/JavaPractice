public class Main {

    public static void main(String[] args) {

        RaceCondition account1 = new RaceCondition();

        Thread t1 = new Thread(() -> {
            try {
                account1.withDraw(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "Thread 1");

        Thread t2 = new Thread(() -> {
            try {
                account1.withDraw(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "Thread 2");


        t1.start();
        t2.start();

    }
}
