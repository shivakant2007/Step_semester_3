package Week8.Practice.VehicleRental;

import java.time.LocalDate;

/**
 * Tracks a single rental transaction.
 */
public class Rental {
    private final Vehicle vehicle;
    private final Customer customer;
    private final int durationDays;
    private final double totalCharge;
    private final LocalDate startDate;
    private final LocalDate endDate;
    private boolean active;

    public Rental(Vehicle vehicle, Customer customer, int durationDays) {
        this.vehicle = vehicle;
        this.customer = customer;
        this.durationDays = durationDays;
        this.totalCharge = vehicle.calculateRentalCharge(durationDays);
        this.startDate = LocalDate.now();
        this.endDate = startDate.plusDays(durationDays);
        this.active = true;
    }

    public Vehicle getVehicle() { return vehicle; }
    public Customer getCustomer() { return customer; }
    public int getDurationDays() { return durationDays; }
    public double getTotalCharge() { return totalCharge; }
    public LocalDate getStartDate() { return startDate; }
    public LocalDate getEndDate() { return endDate; }
    public boolean isActive() { return active; }

    void complete() { this.active = false; }

    @Override
    public String toString() {
        return customer.getName() + " rented " + vehicle.getCategory()
                + " [" + vehicle.getVehicleId() + "] for " + durationDays + " day(s). "
                + "Charge: $" + String.format("%.2f", totalCharge)
                + ". Status: " + (active ? "Active" : "Completed");
    }
}
