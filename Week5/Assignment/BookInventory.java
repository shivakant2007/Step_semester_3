// BookInventory.java
public class BookInventory {
    private int copiesTotal;
    private int copiesAvailable;

    public BookInventory(int copiesTotal) {
        if (copiesTotal <= 0) throw new IllegalArgumentException("Must be positive");
        this.copiesTotal = copiesTotal;
        this.copiesAvailable = copiesTotal;
    }

    public boolean checkOut() {
        if (copiesAvailable > 0) { copiesAvailable--; return true; }
        return false;
    }

    public boolean checkIn() {
        if (copiesAvailable < copiesTotal) { copiesAvailable++; return true; }
        return false;
    }

    public int getCopiesAvailable() { return copiesAvailable; }

    public static void main(String[] args) {
        BookInventory inv = new BookInventory(10);
        inv.checkOut();
        System.out.println("Available: " + inv.getCopiesAvailable());
    }
}
