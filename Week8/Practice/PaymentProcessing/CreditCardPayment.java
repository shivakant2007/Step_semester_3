package Week8.Practice.PaymentProcessing;

/**
 * Credit card payment: always succeeds in demo.
 */
class CreditCardPayment implements PaymentMethod {
    @Override
    public String getName() { return "Credit Card"; }
    @Override
    public boolean processPayment(double amount) {
        System.out.println("Processing Credit Card payment of $" + String.format("%.2f", amount) + "...");
        return true;
    }
}
