import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.TimeZone;
import java.util.Timer;

public class Account extends Thread {
    private double balance;

    public Account(int balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        try {
            Thread.sleep(40);
            balance+=amount;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("\u001B[32m Thread ID: " + Thread.currentThread().getId() + " - Deposited: " + amount+"\u001B[0m" + " " + LocalTime.now());
    }

    public synchronized void withdraw(double amount) {
        System.out.println("Thread ID: " + Thread.currentThread().getId() + " - Checking if user have balance to withdraw...");
        System.out.println("Your balance: " + balance);
            if(balance>=amount) {
                balance-=amount;
                System.out.println("\u001B[32mThread ID: " + Thread.currentThread().getId() + " - Successful withdrawal: " + amount+"\u001B[0m" + " " + LocalTime.now());
            } else {
                System.err.println("Error Thread ID: " + Thread.currentThread().getId() + " - Don't have enough balance.");
            }
    }

    public synchronized double getBalance() {
        return balance;
    }
}
