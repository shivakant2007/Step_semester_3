package Week8.Assignment.CampusPremiereTickets;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Tracks a booking for one or more seats at a show.
 */
public class Booking {
    private final String bookingId;
    private final Customer customer;
    private final Show show;
    private final List<Seat> seats;
    private double totalPrice;
    private final LocalDateTime bookingTime;
    private boolean active;

    public Booking(String bookingId, Customer customer, Show show) {
        this.bookingId = bookingId;
        this.customer = customer;
        this.show = show;
        this.seats = new ArrayList<>();
        this.totalPrice = 0.0;
        this.bookingTime = LocalDateTime.of(2025, 1, 1, 10, 0);
        this.active = true;
    }

    /**
     * Adds a seat to the booking. Returns true if successful.
     */
    public boolean addSeat(Seat seat) {
        if (!active) return false;
        if (seat.isBooked()) return false;
        seats.add(seat);
        seat.setBooked(true);
        totalPrice += seat.getPrice();
        return true;
    }

    public String getBookingId() { return bookingId; }
    public Customer getCustomer() { return customer; }
    public Show getShow() { return show; }
    public List<Seat> getSeats() { return seats; }
    public double getTotalPrice() { return totalPrice; }
    public boolean isActive() { return active; }

    /**
     * Cancels the booking if before show start time.
     */
    public boolean cancel() {
        if (!active) return false;
        if (bookingTime.isAfter(show.getStartTime().atDate(java.time.LocalDate.of(2025, 1, 1)))) {
            System.out.println("Cannot cancel: show has already started.");
            return false;
        }
        this.active = false;
        for (Seat s : seats) {
            show.releaseSeat(s.getSeatId());
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Booking[").append(bookingId).append("] for ").append(customer.getName())
          .append(" at ").append(show.getMovieName()).append(" - Seats: [");
        for (int i = 0; i < seats.size(); i++) {
            if (i > 0) sb.append(", ");
            sb.append(seats.get(i).getSeatId());
        }
        sb.append("]. Total: ₹").append(String.format("%.2f", totalPrice));
        sb.append(". Status: ").append(active ? "Active" : "Cancelled");
        return sb.toString();
    }
}
