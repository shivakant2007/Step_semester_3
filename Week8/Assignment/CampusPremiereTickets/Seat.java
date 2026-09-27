package Week8.Assignment.CampusPremiereTickets;

/**
 * Represents a single seat for a show.
 */
public class Seat {
    private final String seatId;
    private final SeatCategory category;
    private boolean booked;

    public Seat(String seatId, SeatCategory category) {
        this.seatId = seatId;
        this.category = category;
        this.booked = false;
    }

    public String getSeatId() { return seatId; }
    public SeatCategory getCategory() { return category; }
    public double getPrice() { return category.getPrice(); }
    public boolean isBooked() { return booked; }

    void setBooked(boolean booked) { this.booked = booked; }

    @Override
    public String toString() { return category.getCategoryName() + " [" + seatId + "] (" + (booked ? "Booked" : "Available") + ")"; }
}
