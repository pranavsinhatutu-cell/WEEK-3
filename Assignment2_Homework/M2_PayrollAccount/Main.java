class PayrollAccount {
    private double basicSalary;
    private double bonus;

    public PayrollAccount(double openingBasicSalary) {
        if (openingBasicSalary < 0) {
            basicSalary = 0;
            System.out.println("Warning: negative basic salary. Starting at 0.");
        } else {
            basicSalary = openingBasicSalary;
        }
    }

    public void creditBonus(double amount) {
        if (amount <= 0) {
            System.out.println("Bonus rejected: amount must be greater than 0");
            return;
        }
        bonus += amount;
        System.out.println("Bonus credited: Rs " + amount);
    }

    public void deductTax(double percent) {
        if (percent < 0 || percent > 100) {
            System.out.println("Tax deduction rejected: percent must be between 0 and 100");
            return;
        }
        basicSalary -= basicSalary * percent / 100;
        if (percent == Math.floor(percent)) {
            System.out.println("Tax deducted: " + (int) percent + "%");
        } else {
            System.out.println("Tax deducted: " + percent + "%");
        }
    }

    public double getNetSalary() {
        return basicSalary + bonus;
    }
}

public class Main {
    public static void main(String[] args) {
        if (args.length > 0 && args[0].equals("validate")) {
            PayrollAccount validationAccount = new PayrollAccount(-100);
            validationAccount.creditBonus(0);
            validationAccount.deductTax(-1);
            validationAccount.deductTax(101);
            System.out.println("Validation net salary: Rs " + validationAccount.getNetSalary());
            return;
        }

        PayrollAccount account = new PayrollAccount(50000);
        account.creditBonus(5000);
        account.deductTax(10);
        System.out.println("Net salary: Rs " + account.getNetSalary());
    }
}
