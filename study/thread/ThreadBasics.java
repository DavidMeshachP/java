package study.thread;

public class ThreadBasics extends Thread {
    
    private static boolean isEvenTrue = true;
    final static Object lock = new Object();
    
    void sum ( int a, int b) {
        System.out.println(" The sum is " + (a+b) );
    }

    void multiply( int a, int b) {
        System.out.println(" The multiplication is " + (a*b) );
    }

    public static void main(String[] args) {
        
        ThreadBasics threadBasics = new ThreadBasics();
        for(int i = 0; i < 4; i++ ) {
            System.out.println("iteration : " + i);
            threadBasics.sum( i, i+1 );
            try{
                threadBasics.sleep(1000);
            }
            catch( Exception e) {
                System.err.println(e);
            }
            threadBasics.multiply(i, i+1 );
            try{
                threadBasics.sleep(1000);
            }
            catch( Exception e) {
                System.err.println(e);
            }
        }
        if(threadBasics.isAlive() ) {
            System.out.println(threadBasics.getName() + " is alive");
        }
        else {
            System.out.println(threadBasics.getName() + " is dead");
        }
        oddAndEvenThread();

    }

    public static void oddAndEvenThread() {

        Thread oddThread = new Thread(() -> {
            for( int i = 1; i < 5; i+=2 ) {
                synchronized(lock) {
                    while(!isEvenTrue) {
                        try{
                            lock.wait();
                        }
                        catch(Exception e) {
                            System.err.println(e);
                        }
                    }
                    System.out.println("From odd thread : " + i);
                    isEvenTrue = false;
                    lock.notify();
                }
            }
        });

        Thread evenThread = new Thread( () -> {
            for( int i = 2; i < 6; i+=2 ) {
                synchronized(lock) {
                    while(isEvenTrue) {
                        try{
                            lock.wait();
                        }
                        catch(Exception e) {
                            System.err.println(e);
                        }
                    }
                    System.out.println("From even thread : " + i);
                    isEvenTrue = true;
                    lock.notify();
                }
            }
        });

        oddThread.start();
        evenThread.start();
    }

}