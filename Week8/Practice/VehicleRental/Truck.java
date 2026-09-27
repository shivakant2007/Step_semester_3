package Week8.Practice.VehicleRental;

/**
 * Truck vehicles: base rate of $120/day.
 */
public class Truck extends Vehicle {
    private static final double DAILY_RATE = 120.0;

    public Truck(String vehicleId, String make, String model) {
        super(vehicleId, make, model);
    }

    @Override
    public double calculateRentalCharge(int days) {
        return DAILY_RATE * days;
    }

    @Override
    public String getCategory() { return "Truck"; }
}
