package Week8.Practice.VehicleRental;

/**
 * SUV vehicles: base rate of $80/day.
 */
public class SUV extends Vehicle {
    private static final double DAILY_RATE = 80.0;

    public SUV(String vehicleId, String make, String model) {
        super(vehicleId, make, model);
    }

    @Override
    public double calculateRentalCharge(int days) {
        return DAILY_RATE * days;
    }

    @Override
    public String getCategory() { return "SUV"; }
}
