package starvation;

import java.util.concurrent.locks.ReentrantLock;

public class Starvation {

    private static ReentrantLock lock = new ReentrantLock(true);


    public static void main(String[] args) {
//
//        Thread hpThread = new Thread(new Task(), "High priority thread");
//        Thread mpThread = new Thread(new Task(), "Mid priority thread");
//        Thread lpThread = new Thread(new Task(), "Low priority thread");
//
//        hpThread.setPriority(Thread.MAX_PRIORITY);
//        mpThread.setPriority(Thread.NORM_PRIORITY);
//        lpThread.setPriority(Thread.MIN_PRIORITY);
//
//        hpThread.start();
//        mpThread.start();
//        lpThread.start();
//

        Thread t1 = new Thread(new Task(), "T1");
        Thread t2 = new Thread(new Task(), "T2");
        Thread t3 = new Thread(new Task(), "T3");

        t1.start();
        t2.start();
        t3.start();




    }

    public static class Task implements Runnable{


//        @Override
//        public void run() {
//            while (true){
//
//                System.out.println(Thread.currentThread().getName() + " is running ...");
//                    Thread.yield();
//
//
//            }
//        }


        @Override
        public void run(){
            while (true){

                lock.lock();

                try {
                    System.out.println(Thread.currentThread().getName() + "is working" );

                    Thread.sleep(2000);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }finally {
                    lock.unlock();
                }

            }
        }
    }





}
