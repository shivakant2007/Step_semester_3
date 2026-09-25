// Invoice.java
public class Invoice implements Printable {
    String invoiceId;

    public Invoice(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String printLabel() {
        return "Invoice label: " + invoiceId;
    }
}
