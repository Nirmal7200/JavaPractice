public class ThreadPriority implements Runnable{

    @Override
    public void run(){
        for(int i = 0; i< 6; i++){
            System.out.println(Thread.currentThread().getName() + " with Priority : "+ Thread.currentThread().getPriority());
        }
    }
}
