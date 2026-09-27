package Week8.Practice.PaymentProcessing;

/**
 * Demo class for the Payment Processing module.
 */
public class PaymentProcessingSystem {
    public static void main(String[] args) {
        System.out.println("=== Payment Processing System Demo ===\n");

        Product productA = new Product("PA", "Product A", 25.0);
        Product productB = new Product("PB", "Product B", 50.0);
        Product productC = new Product("PC", "Product C", 30.0);

        Customer custX = new Customer("CX", "Customer X");
        Customer custY = new Customer("CY", "Customer Y");
        Customer custZ = new Customer("CZ", "Customer Z");

        // Customer X creates order with Product A (qty 2) and Product B (qty 1)
        System.out.println("-- Customer X creates order --");
        Order orderX = new Order("ORD-X", custX);
        orderX.addProductWithQuantity(productA, 2);
        orderX.addProductWithQuantity(productB, 1);
        System.out.println(orderX);
        System.out.println();

        // Customer X attempts payment using Credit Card
        System.out.println("-- Customer X pays via Credit Card --");
        PaymentMethod creditCard = new CreditCardPayment();
        orderX.processPayment(creditCard);
        System.out.println();

        // Customer Y creates empty order
        System.out.println("-- Customer Y creates empty order --");
        Order orderY = new Order("ORD-Y", custY);
        System.out.println(orderY);
        System.out.println("-- Customer Y attempts payment --");
        PaymentMethod paypal = new PayPalPayment(true);
        orderY.processPayment(paypal);
        System.out.println();

        // Customer Z creates order with Product C (qty 1) and pays via PayPal (fails)
        System.out.println("-- Customer Z creates order with Product C --");
        Order orderZ = new Order("ORD-Z", custZ);
        orderZ.addProductWithQuantity(productC, 1);
        System.out.println(orderZ);
        System.out.println("-- Customer Z pays via PayPal (will fail) --");
        PaymentMethod paypalFail = new PayPalPayment(false);
        orderZ.processPayment(paypalFail);

        System.out.println("\n=== Demo Complete ===");
    }
}
