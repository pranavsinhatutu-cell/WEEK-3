class MessWallet {
    private double balance;

    public MessWallet(double openingBalance) {
        if (openingBalance < 0) {
            balance = 0;
            System.out.println("Warning: negative opening balance. Starting at 0.");
        } else {
            balance = openingBalance;
        }
    }

    public void topUp(double amount) {
        if (amount <= 0) {
            System.out.println("Top-up rejected: amount must be greater than 0");
            return;
        }
        balance += amount;
        System.out.println("Balance after top-up: " + balance);
    }

    public void deduct(double amount) {
        if (amount <= 0) {
            System.out.println("Deduct rejected: amount must be greater than 0");
            return;
        }
        if (amount > balance) {
            System.out.println("Deduct rejected: insufficient balance");
            return;
        }
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }
}

public class Main {
    public static void main(String[] args) {
        if (args.length > 0 && args[0].equals("validate")) {
            MessWallet validationWallet = new MessWallet(-25);
            validationWallet.topUp(0);
            validationWallet.deduct(-5);
            validationWallet.deduct(1);
            System.out.println("Validation balance: " + validationWallet.getBalance());
            return;
        }

        MessWallet wallet = new MessWallet(500);
        wallet.topUp(200);
        wallet.deduct(1000);
        System.out.println("Final balance: " + wallet.getBalance());
    }
}
