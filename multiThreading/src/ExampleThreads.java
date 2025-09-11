public class ExampleThreads {
    public static void main(String[] args) {
        ThreadLifeCycle threadLifeCycle = new ThreadLifeCycle();
        threadLifeCycle.setName("LifeCycle-Thread");

        System.out.println("Thread state before starting : " + threadLifeCycle.getState());

        threadLifeCycle.start();

        System.out.println("Thread state after starting : " + threadLifeCycle.getState());

        try {
            Thread.sleep(1000); // ✅ Pause main thread to let threadLifeCycle run
            System.out.println("Thread state after some time : " + threadLifeCycle.getState());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            threadLifeCycle.join(); // Wait for thread to finish
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Thread state after join completion : " + threadLifeCycle.getState());


        // Priority Thread

        ThreadPriority task1 = new ThreadPriority();

        Thread thread1 = new Thread(task1);

        thread1.setName("Thread 1");

        thread1.setPriority(Thread.MAX_PRIORITY);

        ThreadPriority task2 = new ThreadPriority();

        Thread thread2 = new Thread(task2);

        thread2.setName("Thread 2");

        thread2.setPriority(Thread.NORM_PRIORITY);

        ThreadPriority task3 = new ThreadPriority();

        Thread thread3 = new Thread(task3);

        thread3.setName("Thread 3");

        thread3.setPriority(Thread.MIN_PRIORITY);


        thread3.start();
        thread2.start();
        thread1.start();









    }
}