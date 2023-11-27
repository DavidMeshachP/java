package thread;

public class BankaccountWithConcurrentWithdrawalAndDepositUsingThreads {

    public static void main(String args[]) {

        BankAccount account1 = new BankAccount();

        account1.setAmount(25000);

        Thread thread1 = new Thread(() -> {
            account1.deposit(1000);
        });
        Thread thread2 = new Thread(() -> {
            account1.deposit(20000);
        });
        Thread thread3 = new Thread(() -> {
            account1.withdraw(100000);
        });
        Thread thread4 = new Thread(() -> {
            account1.withdraw(2000);
        });

        try {

            thread1.start();
            thread1.join();
            thread2.start();
            thread2.join();
            thread3.start();
            thread3.join();
            thread4.start();
            thread4.join();

        } catch (Exception e) {
            System.err.println(e);
        }

    }

}