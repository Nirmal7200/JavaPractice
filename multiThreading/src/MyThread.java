public class MyThread  extends Thread{

    @Override
    public void run(){
        for (int i =0 ; i<6; i++){

            System.out.println(Thread.currentThread().getName()+ " :" + i);

            try {
                    Thread.sleep(1000);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }
    }
}
