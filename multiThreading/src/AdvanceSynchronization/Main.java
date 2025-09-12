package AdvanceSynchronization;

public class Main {

    public static void  main(String[] args){

//        SharedResouce resouce = new SharedResouce();
//
//        Thread t1 = new Thread(resouce::increment, "Thread 1");
//        Thread t2 = new Thread(() -> resouce.increment(), "Thread 2");
//
//        t1.start();
//        t2.start();


//        SharedData resouse = new SharedData();
//
//        Thread t1 = new Thread(resouse::readData, " Thread 1");
//        Thread t2 = new Thread(resouse::readData, "Thread 2");
//
//        Thread t3 = new Thread(() -> resouse.writeData(33), "Thread 3");
//
//
//        t1.start();
//        t2.start();
//        t3.start();


        LimitedResouce limitedResouce = new LimitedResouce();

        Thread t1 = new Thread(limitedResouce::accessResource, "Thread 1");

        Thread t2 = new Thread(limitedResouce::accessResource, "Thread 2");

        Thread t3 = new Thread(limitedResouce::accessResource, "Thread 3");


        t1.start();
        t2.start();
        t3.start();




    }
}
