public class ProductInventoryCsvParser {
    void parseInventoryRecord(String csvLine) {
        String[] fields = csvLine.split(",");
        if (fields.length != 3) {
            System.out.println("Invalid Record");
        } else {
            System.out.println("Product: " + fields[0] + " | SKU: " + fields[1] + " | Qty: " + fields[2]);
        }
    }

    public static void main(String[] args) {
        ProductInventoryCsvParser parser = new ProductInventoryCsvParser();
        parser.parseInventoryRecord("Widget,SKU123,50");
        parser.parseInventoryRecord("Gadget,SKU456");
    }
}
