class BankAccount {
    private int balance = 1000;
    public synchronized void deposit(int amount) {
        balance += amount;
        System.out.println(
            "Deposited: Rs." + amount +
            " | Balance: Rs." + balance
        );
    }

    public synchronized void withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(
                "Withdrawn: Rs." + amount +
                " | Balance: Rs." + balance
            );
        } else {
            System.out.println(
                "Withdrawal failed! Insufficient balance."
            );
        }
    }
}

class DepositTask implements Runnable {
    private BankAccount account;
    DepositTask(BankAccount account) {
        this.account = account;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            account.deposit(500);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }
}

class WithdrawalTask implements Runnable {
    private BankAccount account;
    WithdrawalTask(BankAccount account) {
        this.account = account;
    }
    public void run() {
        for (int i = 1; i <= 5; i++) {
            account.withdraw(300);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }
}

public class RunnableBank {

    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        DepositTask deposit = new DepositTask(account);
        WithdrawalTask withdrawal = new WithdrawalTask(account);
        Thread t1 = new Thread(deposit);
        Thread t2 = new Thread(withdrawal);
        t1.start();
        t2.start();
    }
}