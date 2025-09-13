package Resource;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Resource {

    private final Lock lock = new ReentrantLock();

    public synchronized void method1(Resource resource){
        try{
            if (lock.tryLock()){
                System.out.println(Thread.currentThread().getName() + "Locked resources1");
                Thread.sleep(100);
            }else {
                System.out.println(Thread.currentThread().getName() + "Not available for lock and a backing off");
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (lock.tryLock()){
                lock.unlock();
            }

        }

    }

    public synchronized void method2(Resource resource){
        System.out.println(Thread.currentThread().getName()+ " is executing method 2");
    }
}
