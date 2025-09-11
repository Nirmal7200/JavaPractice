public class ExampleThreads {

    public static void main (String[] args) {

        MyThread thread1 = new MyThread();
        MyThread thread2 = new MyThread();
        Thread thread3 = new Thread(new myRunnable());

        thread1.setName("Thread 1");
        thread2.setName("Thread 2");
        thread3.setName("Thread 3");

        thread1.start();
        thread2.start();
        thread3.start();


    }
}
