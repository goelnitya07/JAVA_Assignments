class BankAccount {
    private int balance = 1000;
    public synchronized void deposit(int amount) {
        balance = balance + amount;
        System.out.println(
            "Deposit: Rs." + amount +
            " | Balance: Rs." + balance
        );
    }

    public synchronized void withdraw(int amount) {
        if (balance >= amount) {
            balance = balance - amount;

            System.out.println(
                "Withdrawal: Rs." + amount +
                " | Balance: Rs." + balance
            );

        } else {
            System.out.println(
                "Withdrawal: Rs." + amount +
                " | Insufficient Balance"
            );
        }
    }
}

class DepositThread extends Thread {
    private BankAccount account;
    DepositThread(BankAccount account) {
        this.account = account;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            account.deposit(500);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

class WithdrawThread extends Thread {
    private BankAccount account;
    WithdrawThread(BankAccount account) {
        this.account = account;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            account.withdraw(300);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

public class BankTransaction {

    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        DepositThread deposit =
                new DepositThread(account);

        WithdrawThread withdraw =
                new WithdrawThread(account);

        deposit.start();
        withdraw.start();
    }
}