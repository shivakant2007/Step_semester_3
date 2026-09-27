package Week8.Practice.HotelBooking;

import java.time.LocalDate;

/**
 * Tracks a single room reservation.
 */
public class Reservation {
    private final Room room;
    private final Customer customer;
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final double totalPrice;
    private final int durationDays;
    private boolean active;
    private final LocalDate cancellationDeadline;

    public Reservation(Room room, Customer customer, LocalDate startDate, LocalDate endDate) {
        this.room = room;
        this.customer = customer;
        this.startDate = startDate;
        this.endDate = endDate;
        this.durationDays = (int) java.time.temporal.ChronoUnit.DAYS.between(startDate, endDate);
        this.totalPrice = room.calculatePrice(durationDays);
        this.active = true;
        // Cancellation deadline: 2 days before check-in
        this.cancellationDeadline = startDate;
    }

    public Room getRoom() { return room; }
    public Customer getCustomer() { return customer; }
    public LocalDate getStartDate() { return startDate; }
    public LocalDate getEndDate() { return endDate; }
    public double getTotalPrice() { return totalPrice; }
    public boolean isActive() { return active; }
    public LocalDate getCancellationDeadline() { return cancellationDeadline; }

    /**
     * Cancels the reservation if before the deadline. Returns true if cancelled.
     */
    public boolean cancel() {
        if (!active) return false;
        if (LocalDate.now().isAfter(cancellationDeadline)) {
            System.out.println("Cannot cancel: past cancellation deadline (" + cancellationDeadline + ")");
            return false;
        }
        this.active = false;
        room.setAvailable(true);
        return true;
    }

    @Override
    public String toString() {
        return customer.getName() + " reserved " + room.getCategory() + " ["
                + room.getRoomId() + "] from " + startDate + " to " + endDate
                + ". Price: $" + String.format("%.2f", totalPrice)
                + ". Status: " + (active ? "Active" : "Cancelled");
    }
}
