package Week8.Practice.PaymentProcessing;

/**
 * PayPal payment: can succeed or fail based on scenario.
 */
class PayPalPayment implements PaymentMethod {
    private final boolean success;
    public PayPalPayment(boolean success) { this.success = success; }
    @Override
    public String getName() { return "PayPal"; }
    @Override
    public boolean processPayment(double amount) {
        System.out.println("Processing PayPal payment of $" + String.format("%.2f", amount) + "...");
        return success;
    }
}
