package thread;

public class BankAccount extends Thread{
    
    int amount;

    public BankAccount() {
        amount = 0;
    }

    public BankAccount(int amount) {
        this.amount = amount;
    }

    void setAmount( int amount ) {
        this.amount = amount;
    }

    void deposit( int depositAmount ) {
        amount += depositAmount;
        System.out.println("deposit balance " + amount);
    }

    void withdraw( int withdrawAmount ) {
        if( withdrawAmount < amount ) {
            amount -= withdrawAmount;
            System.out.println("withdraw balance " + amount);
        }
        else {
            System.out.println("withdraw stopped.....Insufficient funds....");
        }
    }

}
