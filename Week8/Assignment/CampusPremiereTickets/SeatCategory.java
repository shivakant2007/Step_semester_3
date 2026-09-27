package Week8.Assignment.CampusPremiereTickets;

/**
 * Abstract base class for seat categories.
 * Each category owns its own price.
 */
public abstract class SeatCategory {
    private final String categoryName;
    public SeatCategory(String categoryName) { this.categoryName = categoryName; }
    public abstract double getPrice();
    public String getCategoryName() { return categoryName; }
    @Override
    public String toString() { return categoryName + " (₹" + String.format("%.2f", getPrice()) + ")"; }
}

/**
 * Regular seat: ₹150.
 */
class RegularSeat extends SeatCategory {
    public RegularSeat() { super("Regular"); }
    @Override public double getPrice() { return 150.0; }
}

/**
 * Premium seat: ₹250.
 */
class PremiumSeat extends SeatCategory {
    public PremiumSeat() { super("Premium"); }
    @Override public double getPrice() { return 250.0; }
}

/**
 * Recliner seat: ₹400.
 */
class ReclinerSeat extends SeatCategory {
    public ReclinerSeat() { super("Recliner"); }
    @Override public double getPrice() { return 400.0; }
}
