package AdvanceSynchronization;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SharedData {

    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    private int data = 0;

    public void readData() {
        lock.readLock().lock();

        try {
            System.out.println(Thread.currentThread().getName()+ "read data :  "+ data);

        }finally {
            lock.readLock().unlock();
        }
    }

    public void writeData(int value){
        lock.writeLock().lock();

        try {
            data = value;
            System.out.println(Thread.currentThread().getName()+ "write data :  "+ data);
        }finally {
        lock.writeLock().unlock();
        }
    }




}
