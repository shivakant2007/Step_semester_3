package Week8.Practice.HotelBooking;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Central hotel booking system managing rooms, availability, and reservations.
 */
public class HotelBookingSystem {
    private final List<Room> rooms;
    private final List<Reservation> reservations;

    public HotelBookingSystem() {
        this.rooms = new ArrayList<>();
        this.reservations = new ArrayList<>();
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    /**
     * Checks if a room is available for the given period.
     */
    public boolean checkAvailability(Room room, LocalDate startDate, LocalDate endDate) {
        boolean available = room.isAvailableForPeriod(startDate, endDate);
        System.out.println(room.getCategory() + " [" + room.getRoomId()
                + "] " + (available ? "is available" : "is not available")
                + " from " + startDate + " to " + endDate + ".");
        return available;
    }

    /**
     * Creates a reservation if the room is available for the given period.
     */
    public Reservation createReservation(Room room, Customer customer, LocalDate startDate, LocalDate endDate) {
        if (!room.isAvailableForPeriod(startDate, endDate)) {
            System.out.println("Room " + room.getRoomId() + " is not available from "
                    + startDate + " to " + endDate + ".");
            return null;
        }
        room.setAvailable(false);
        Reservation reservation = new Reservation(room, customer, startDate, endDate);
        room.addReservation(reservation);
        reservations.add(reservation);
        System.out.println("Reservation confirmed for " + customer.getName() + ", "
                + room.getCategory() + " [" + room.getRoomId() + "] (" + startDate + "-" + endDate + ")");
        System.out.println("Price: $" + String.format("%.2f", reservation.getTotalPrice()) + ".");
        return reservation;
    }

    /**
     * Cancels a reservation if within the cancellation deadline.
     */
    public void cancelReservation(Reservation reservation) {
        if (reservation.cancel()) {
            System.out.println("Reservation for " + reservation.getCustomer().getName()
                    + " cancelled successfully.");
        } else {
            System.out.println("Cancellation failed.");
        }
    }

    // ---- Demo ----
    public static void main(String[] args) {
        HotelBookingSystem system = new HotelBookingSystem();

        Room std101 = new StandardRoom("101");
        Room del201 = new DeluxeRoom("201");

        system.addRoom(std101);
        system.addRoom(del201);

        Customer custA = new Customer("CA", "Customer A");
        Customer custB = new Customer("CB", "Customer B");
        Customer custC = new Customer("CC", "Customer C");

        System.out.println("=== Hotel Booking System Demo ===\n");

        LocalDate nov1 = LocalDate.of(2026, 11, 1);
        LocalDate nov5 = LocalDate.of(2026, 11, 5);
        LocalDate nov3 = LocalDate.of(2026, 11, 3);
        LocalDate nov7 = LocalDate.of(2026, 11, 7);
        LocalDate feb10 = LocalDate.of(2026, 2, 10);
        LocalDate feb12 = LocalDate.of(2026, 2, 12);

        // Customer A checks availability
        System.out.println("-- Customer A checks availability --");
        system.checkAvailability(std101, nov1, nov5);
        System.out.println();

        // Customer A reserves Standard Room 101 from Nov 1 to Nov 5
        System.out.println("-- Customer A reserves Standard Room 101 (Nov 1-5) --");
        Reservation resA = system.createReservation(std101, custA, nov1, nov5);
        System.out.println();

        // Customer B attempts to reserve Standard Room 101 from Nov 3 to Nov 7
        System.out.println("-- Customer B attempts to reserve Standard Room 101 (Nov 3-7) --");
        system.checkAvailability(std101, nov3, nov7);
        system.createReservation(std101, custB, nov3, nov7);
        System.out.println();

        // Customer A cancels before deadline
        System.out.println("-- Customer A cancels reservation --");
        system.cancelReservation(resA);
        System.out.println();

        // Customer C reserves Deluxe Room 201 from Feb 10 to Feb 12
        System.out.println("-- Customer C reserves Deluxe Room 201 (Feb 10-12) --");
        system.createReservation(del201, custC, feb10, feb12);

        System.out.println("\n=== Demo Complete ===");
    }
}
