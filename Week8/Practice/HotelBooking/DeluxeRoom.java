package Week8.Practice.HotelBooking;

/**
 * Deluxe room: $200/day base rate.
 */
public class DeluxeRoom extends Room {
    private static final double DAILY_RATE = 200.0;

    public DeluxeRoom(String roomId) {
        super(roomId, "Deluxe");
    }

    @Override
    public double calculatePrice(int days) {
        return DAILY_RATE * days;
    }
}
