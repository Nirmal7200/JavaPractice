public class RaceCondition {

    private int balance = 100;

    public   void  withDraw(int amt) throws InterruptedException {

        synchronized (this) {
            if (balance >= amt) {
                System.out.println(Thread.currentThread().getName() + " is about to withdraw ");

                balance -= amt;

                try {
                    Thread.sleep(2000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName() + " withdraw has been completed. Remaining balance is  " + balance);
            } else {
                System.out.println(Thread.currentThread().getName() + " not enough balance to withdraw" + balance);
            }
        }
    }
}
