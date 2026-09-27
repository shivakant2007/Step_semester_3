package Week8.Practice.PaymentProcessing;

/**
 * Interface for payment methods. Each implementation processes payment differently.
 */
public interface PaymentMethod {
    String getName();
    boolean processPayment(double amount);
}
