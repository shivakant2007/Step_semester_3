package Week8.Practice.PaymentProcessing;

/**
 * Represents a product in an order.
 */
public class Product {
    private final String productId;
    private final String name;
    private final double price;

    public Product(String productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public String getProductId() { return productId; }
    public String getName() { return name; }
    public double getPrice() { return price; }

    @Override
    public String toString() { return name + " ($" + price + ")"; }
}
