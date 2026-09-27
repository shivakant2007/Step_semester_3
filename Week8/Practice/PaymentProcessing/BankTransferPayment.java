package Week8.Practice.PaymentProcessing;

/**
 * Bank transfer payment: always succeeds in demo.
 */
class BankTransferPayment implements PaymentMethod {
    @Override
    public String getName() { return "Bank Transfer"; }
    @Override
    public boolean processPayment(double amount) {
        System.out.println("Processing Bank Transfer payment of $" + String.format("%.2f", amount) + "...");
        return true;
    }
}
