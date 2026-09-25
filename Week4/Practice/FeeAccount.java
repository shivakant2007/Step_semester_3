// FeeAccount.java
public class FeeAccount {
    String name;
    double amount;

    public FeeAccount(String name, double amount) {
        this.name = name;
        this.amount = amount;
    }

    public void pay(double amount) {
        this.amount -= amount;
    }
}

class HostelFeeAccount extends FeeAccount {
    public HostelFeeAccount(String name, double amount) {
        super(name, amount);
    }

    public void pay(double amount) {
        this.amount -= amount;
        System.out.println("Paid in two installments (hostel account)");
    }
}

class FeeProcessor {
    public static void processPayment(FeeAccount account, double amount) {
        if (account instanceof HostelFeeAccount) {
            account.pay(amount / 2);
            account.pay(amount / 2);
        } else {
            account.pay(amount);
            System.out.println("Paid in one go (day-scholar account)");
        }
    }

    public static void main(String[] args) {
        FeeAccount[] accounts = new FeeAccount[4];
        accounts[0] = new HostelFeeAccount("Alice", 10000);
        accounts[1] = new FeeAccount("Bob", 5000);
        accounts[2] = new HostelFeeAccount("Charlie", 8000);
        accounts[3] = new FeeAccount("Divya", 6000);
        int hc = 0, dc = 0;
        for (FeeAccount acc : accounts) {
            processPayment(acc, 1000);
            if (acc instanceof HostelFeeAccount) hc++; else dc++;
        }
        System.out.println("Hostel accounts processed: " + hc + " | Day-scholar accounts processed: " + dc);
    }
}
