package Week8.Practice.VehicleRental;

import java.util.ArrayList;
import java.util.List;

/**
 * Central system managing vehicle availability and rental workflow.
 * Only this system can change vehicle availability, preventing external
 * code from corrupting state.
 */
public class VehicleRentalSystem {
    private final List<Vehicle> vehicles;
    private final List<Rental> rentals;

    public VehicleRentalSystem() {
        this.vehicles = new ArrayList<>();
        this.rentals = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    /**
     * Attempts to rent a vehicle for a customer for the given number of days.
     * Returns the Rental if successful, null if vehicle is unavailable.
     */
    public Rental rentVehicle(Vehicle vehicle, Customer customer, int days) {
        if (!vehicle.isAvailable()) {
            System.out.println(vehicle.getCategory() + " [" + vehicle.getVehicleId()
                    + "] is currently unavailable.");
            return null;
        }
        vehicle.setAvailable(false);
        Rental rental = new Rental(vehicle, customer, days);
        rentals.add(rental);
        System.out.println(vehicle.getCategory() + " [" + vehicle.getVehicleId()
                + "] rented successfully by " + customer.getName() + ".");
        System.out.println("Rental charge: $" + String.format("%.2f", rental.getTotalCharge()) + ".");
        return rental;
    }

    /**
     * Returns a vehicle, marking it available again and completing the rental.
     */
    public void returnVehicle(Vehicle vehicle) {
        for (Rental rental : rentals) {
            if (rental.getVehicle().getVehicleId().equals(vehicle.getVehicleId())
                    && rental.isActive()) {
                rental.complete();
                vehicle.setAvailable(true);
                System.out.println(vehicle.getCategory() + " [" + vehicle.getVehicleId()
                        + "] returned by " + rental.getCustomer().getName() + ".");
                return;
            }
        }
        System.out.println("No active rental found for " + vehicle.getVehicleId());
    }

    public List<Vehicle> getVehicles() { return vehicles; }
    public List<Rental> getRentals() { return rentals; }

    // ---- Demo ----
    public static void main(String[] args) {
        VehicleRentalSystem system = new VehicleRentalSystem();

        Vehicle sedanA = new Sedan("Sedan-A", "Toyota", "Camry");
        Vehicle suvB = new SUV("SUV-B", "Ford", "Explorer");
        Vehicle truckC = new Truck("Truck-C", "Chevrolet", "Silverado");

        system.addVehicle(sedanA);
        system.addVehicle(suvB);
        system.addVehicle(truckC);

        Customer cust1 = new Customer("C01", "Customer 1");
        Customer cust2 = new Customer("C02", "Customer 2");
        Customer cust3 = new Customer("C03", "Customer 3");

        System.out.println("=== Vehicle Rental System Demo ===\n");

        // Customer 1 rents Sedan A for 3 days
        System.out.println("-- Customer 1 rents Sedan A for 3 days --");
        Rental r1 = system.rentVehicle(sedanA, cust1, 3);
        System.out.println("Sedan A available? " + sedanA.isAvailable() + "\n");

        // Customer 2 attempts to rent Sedan A while Customer 1 still has it
        System.out.println("-- Customer 2 attempts to rent Sedan A for 2 days --");
        system.rentVehicle(sedanA, cust2, 2);
        System.out.println();

        // Customer 1 returns Sedan A
        System.out.println("-- Customer 1 returns Sedan A --");
        system.returnVehicle(sedanA);
        System.out.println("Sedan A available? " + sedanA.isAvailable() + "\n");

        // Customer 3 rents SUV B for 5 days
        System.out.println("-- Customer 3 rents SUV B for 5 days --");
        system.rentVehicle(suvB, cust3, 5);
        System.out.println("SUV B available? " + suvB.isAvailable() + "\n");

        System.out.println("=== Demo Complete ===");
    }
}
