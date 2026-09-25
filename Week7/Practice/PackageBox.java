// PackageBox.java
public class PackageBox implements Printable {
    String trackingId;

    public PackageBox(String trackingId) {
        this.trackingId = trackingId;
    }

    public String printLabel() {
        return "Package label: " + trackingId;
    }
}
