package Week8.Practice.HotelBooking;

/**
 * Standard room: $100/day base rate.
 */
public class StandardRoom extends Room {
    private static final double DAILY_RATE = 100.0;

    public StandardRoom(String roomId) {
        super(roomId, "Standard");
    }

    @Override
    public double calculatePrice(int days) {
        return DAILY_RATE * days;
    }
}
