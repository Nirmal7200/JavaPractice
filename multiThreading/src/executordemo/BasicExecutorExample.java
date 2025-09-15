package executordemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BasicExecutorExample {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(2);


        for (int i = 0; i< 6; i ++){
            Runnable task = new Task(i);
            executorService.execute(task);
        }

        executorService.shutdown();



    }

    public static class Task implements Runnable{

        private final int taskId;


        public Task(int taskId){

            this.taskId = taskId;
        }

        @Override
        public void run(){

            System.out.println( "Task "+ taskId + "running " +Thread.currentThread().getName());

            try {

                Thread.sleep(2000);

            } catch (Exception e){
                throw new RuntimeException(e);
            }

            System.out.println( "Task "+ taskId + "Completed " +Thread.currentThread().getName());


        }
    }
}
