package Week8.Assignment.CampusPremiereTickets;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Manages seat availability for a movie show.
 */
public class Show {
    private final String showId;
    private final String movieName;
    private final LocalTime startTime;
    private final List<Seat> seats;

    public Show(String showId, String movieName, LocalTime startTime) {
        this.showId = showId;
        this.movieName = movieName;
        this.startTime = startTime;
        this.seats = new ArrayList<>();
    }

    public void addSeat(Seat seat) {
        seats.add(seat);
    }

    public List<Seat> getSeats() { return seats; }
    public String getShowId() { return showId; }
    public String getMovieName() { return movieName; }
    public LocalTime getStartTime() { return startTime; }

    /**
     * Checks if a seat is available for booking.
     */
    public boolean isSeatAvailable(String seatId) {
        for (Seat s : seats) {
            if (s.getSeatId().equals(seatId)) {
                return !s.isBooked();
            }
        }
        return false;
    }

    /**
     * Finds a seat by ID.
     */
    public Seat getSeat(String seatId) {
        for (Seat s : seats) {
            if (s.getSeatId().equals(seatId)) return s;
        }
        return null;
    }

    /**
     * Books a seat if available.
     */
    public boolean bookSeat(String seatId) {
        Seat seat = getSeat(seatId);
        if (seat == null || seat.isBooked()) return false;
        seat.setBooked(true);
        return true;
    }

    /**
     * Releases a seat (on cancellation).
     */
    public void releaseSeat(String seatId) {
        Seat seat = getSeat(seatId);
        if (seat != null) seat.setBooked(false);
    }

    @Override
    public String toString() { return movieName + " @ " + startTime + " [" + showId + "]"; }
}
