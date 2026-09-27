package Week8.Practice.HotelBooking;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstract base class for all room types.
 * Each subclass implements its own pricing rule.
 */
public abstract class Room {
    private final String roomId;
    private final String category;
    private boolean available;
    private final List<Reservation> reservations;

    public Room(String roomId, String category) {
        this.roomId = roomId;
        this.category = category;
        this.available = true;
        this.reservations = new ArrayList<>();
    }

    public String getRoomId() { return roomId; }
    public String getCategory() { return category; }

    public boolean isAvailable() { return available; }

    /**
     * Only the reservation system can modify availability.
     */
    void setAvailable(boolean available) { this.available = available; }

    public List<Reservation> getReservations() { return reservations; }

    /**
     * Checks if this room is available for the given date range,
     * considering existing active reservations.
     */
    public boolean isAvailableForPeriod(java.time.LocalDate startDate, java.time.LocalDate endDate) {
        for (Reservation r : reservations) {
            if (r.isActive() && !isOverlapFree(startDate, endDate, r)) {
                return false;
            }
        }
        return true;
    }

    private boolean isOverlapFree(java.time.LocalDate start, java.time.LocalDate end, Reservation r) {
        return end.isBefore(r.getStartDate()) || start.isAfter(r.getEndDate());
    }

    /**
     * Calculates the total price for the given duration.
     */
    public abstract double calculatePrice(int days);

    /**
     * Adds an active reservation to this room's history.
     */
    void addReservation(Reservation reservation) {
        reservations.add(reservation);
    }

    @Override
    public String toString() {
        return category + " [" + roomId + "] (" + (available ? "Available" : "Occupied") + ")";
    }
}
