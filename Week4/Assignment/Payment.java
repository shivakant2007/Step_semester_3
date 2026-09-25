// Payment.java
public class Payment {
    public void pay(double amount) {
        System.out.println("Paid (cash): Rs " + amount);
    }
}

class CardPayment extends Payment {
    public void payWithProcessingFee(double amount) {
        double fee = amount * 1.02;
        System.out.println("Charged (card, incl. fee): Rs " + fee);
    }
}

class TransactionProcessor {
    public static void processTransaction(Payment payment, double amount) {
        if (payment instanceof CardPayment) {
            ((CardPayment) payment).payWithProcessingFee(amount);
        } else {
            payment.pay(amount);
        }
    }

    public static void main(String[] args) {
        Payment[] payments = new Payment[5];
        double[] amounts = {100, 50, 200, 75, 120};
        payments[0] = new CardPayment();
        payments[1] = new Payment();
        payments[2] = new CardPayment();
        payments[3] = new Payment();
        payments[4] = new CardPayment();
        double total = 0;
        for (int i = 0; i < payments.length; i++) {
            if (payments[i] instanceof CardPayment) total += amounts[i] * 1.02;
            else total += amounts[i];
            processTransaction(payments[i], amounts[i]);
        }
        System.out.println("Total Collected: Rs " + total);
    }
}
