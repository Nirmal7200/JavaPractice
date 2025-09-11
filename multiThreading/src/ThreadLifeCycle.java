public class ThreadLifeCycle extends Thread{

    @Override
    public void run(){

        System.out.println("This thread is running ...");


        try {
            Thread.sleep(2000);

        }catch (InterruptedException e){
            System.out.println(e);
        }
    }

}
