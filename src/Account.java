public class Account extends Thread {
    private double balance;

    public Account(int balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance+=amount;
        System.out.println("deposited: " + amount);
    }

    public synchronized void withdraw(double amount) {
        System.out.println("Thread ID: " + Thread.currentThread().getId() + " - Checking if user have balance to withdraw...");
            if(balance>=amount) {
                balance-=amount;
                System.out.println("\u001B[32mThread ID: " + Thread.currentThread().getId() + " - Successful withdrawal: " + amount+"\u001B[0m");
            } else {
                System.err.println("Error Thread ID: " + Thread.currentThread().getId() + " - Don't have enough balance.");
            }
    }

    public synchronized double getBalance() {
        return balance;
    }
}
