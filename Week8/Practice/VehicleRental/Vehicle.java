package Week8.Practice.VehicleRental;

/**
 * Abstract base class for all vehicle types.
 * Each subclass implements its own pricing logic.
 */
public abstract class Vehicle {
    private final String vehicleId;
    private final String make;
    private final String model;
    private boolean available;

    public Vehicle(String vehicleId, String make, String model) {
        this.vehicleId = vehicleId;
        this.make = make;
        this.model = model;
        this.available = true;
    }

    public String getVehicleId() { return vehicleId; }
    public String getMake() { return make; }
    public String getModel() { return model; }

    public boolean isAvailable() { return available; }

    // Controlled availability: only RentalSystem can change it
    void setAvailable(boolean available) { this.available = available; }

    /**
     * Each vehicle category implements its own pricing rule.
     */
    public abstract double calculateRentalCharge(int days);

    @Override
    public String toString() {
        return getCategory() + " [" + vehicleId + "]: " + make + " " + model
                + " (" + (available ? "Available" : "Rented") + ")";
    }

    public abstract String getCategory();
}
