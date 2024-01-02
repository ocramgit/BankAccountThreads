public class Main {
    public static void main(String[] args) throws InterruptedException {
        Account marco1 = new Account(10);

        Thread t1 = new Thread(marco1) {
            @Override
            public void run() {
                marco1.withdraw(10);
            }
        };

        Thread t2 = new Thread(marco1) {
            @Override
            public void run() {
                marco1.withdraw(10);
            }
        };


        Thread t3 = new Thread(marco1) {
            @Override
            public void run() {
                marco1.withdraw(10);
            }
        };

        Thread t4 = new Thread(marco1) {
            @Override
            public void run() {
                marco1.withdraw(10);
            }
        };

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}