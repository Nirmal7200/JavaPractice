package AdvanceSynchronization;

import java.util.concurrent.Semaphore;

public class LimitedResouce {

    private final Semaphore semaphore = new Semaphore(1);


    public void accessResource(){
        try{
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName() + "is access the resource");
            Thread.sleep(1000);

        } catch (Exception e){

        } finally {
            System.out.println(Thread.currentThread().getName()+ " releasing the resource");

            semaphore.release();
        }

    }
}
