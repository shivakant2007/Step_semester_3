package Week8.Practice.HotelBooking;

/**
 * Suite room: $350/day base rate.
 */
public class SuiteRoom extends Room {
    private static final double DAILY_RATE = 350.0;

    public SuiteRoom(String roomId) {
        super(roomId, "Suite");
    }

    @Override
    public double calculatePrice(int days) {
        return DAILY_RATE * days;
    }
}
