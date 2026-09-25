// DeliveryNote.java
public abstract class DeliveryNote {
    public abstract void confirmDelivery();

    public void confirmDelivery(String signature) {
        confirmDelivery();
        System.out.println(", signed by " + signature);
    }
}
