package AdvanceSynchronization;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SharedResouce {

    private final Lock lock= new ReentrantLock();

    private int counter = 0;

    public void increment(){
        if (lock.tryLock()){
            try {
                counter++;

                System.out.println(Thread.currentThread().getName()+ "incremented the counter to :  "+ counter);
            }finally {

                lock.unlock();

            }
        }else {
            System.out.println(Thread.currentThread().getName()+ "could not get the lock to the counter and do something :  "+ counter);

        }

        }
}
