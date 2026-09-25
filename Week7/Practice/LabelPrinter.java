// LabelPrinter.java
public class LabelPrinter {
    public static void printAll(Printable[] items) {
        for (Printable item : items) {
            System.out.println(item.printLabel());
        }
    }

    public static void main(String[] args) {
        printAll(new Printable[]{new PackageBox("TRK-88"), new Invoice("INV-42")});
    }
}
