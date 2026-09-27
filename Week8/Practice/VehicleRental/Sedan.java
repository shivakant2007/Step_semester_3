package Week8.Practice.VehicleRental;

/**
 * Sedan vehicles: base rate of $50/day.
 */
public class Sedan extends Vehicle {
    private static final double DAILY_RATE = 50.0;

    public Sedan(String vehicleId, String make, String model) {
        super(vehicleId, make, model);
    }

    @Override
    public double calculateRentalCharge(int days) {
        return DAILY_RATE * days;
    }

    @Override
    public String getCategory() { return "Sedan"; }
}
