package Week8.Practice.PaymentProcessing;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents an order that can contain multiple products.
 * Status: PENDING -> PAID (only after successful payment).
 */
public class Order {
    public enum OrderStatus { PENDING, PAID }

    private final String orderId;
    private final Customer customer;
    private final List<Product> products;
    private OrderStatus status;
    private double totalAmount;

    public Order(String orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
        this.products = new ArrayList<>();
        this.status = OrderStatus.PENDING;
        this.totalAmount = 0.0;
    }

    public void addProduct(Product product, int quantity) {
        if (status == OrderStatus.PAID) {
            throw new IllegalStateException("Cannot add products to a paid order.");
        }
        products.add(product);
        // Adjust total if product was already added - in this simple model we just add once
    }

    /**
     * Adds a product with a specific quantity to the order.
     */
    public void addProductWithQuantity(Product product, int quantity) {
        if (status == OrderStatus.PAID) {
            throw new IllegalStateException("Cannot add products to a paid order.");
        }
        for (int i = 0; i < quantity; i++) {
            products.add(product);
        }
        recalculateTotal();
    }

    private void recalculateTotal() {
        double total = 0;
        for (Product p : products) total += p.getPrice();
        this.totalAmount = total;
    }

    public double getTotalAmount() { return totalAmount; }
    public OrderStatus getStatus() { return status; }
    public String getOrderId() { return orderId; }
    public Customer getCustomer() { return customer; }
    public List<Product> getProducts() { return products; }

    /**
     * Attempts to process payment using the given payment method.
     * Order is only marked PAID on success.
     */
    public boolean processPayment(PaymentMethod paymentMethod) {
        if (products.isEmpty()) {
            System.out.println("Cannot process payment: order has no items.");
            return false;
        }
        System.out.println("Payment initiated via " + paymentMethod.getName() + " for Order " + orderId + ".");
        boolean success = paymentMethod.processPayment(totalAmount);
        if (success) {
            this.status = OrderStatus.PAID;
            System.out.println("Payment for Order " + orderId + " successful.");
            System.out.println("Order status: " + this.status);
        } else {
            System.out.println("Payment for Order " + orderId + " failed.");
            System.out.println("Order status remains: " + this.status);
        }
        return success;
    }

    @Override
    public String toString() {
        return "Order[" + orderId + "] for " + customer.getName()
                + " - " + products.size() + " item(s), Total: $" + String.format("%.2f", totalAmount)
                + ", Status: " + status;
    }
}
