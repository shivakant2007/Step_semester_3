package Week8.Assignment.CampusPremiereTickets;

/**
 * Demo class for the Campus Premiere Ticket Counter system.
 */
public class TicketCounterSystem {
    public static void main(String[] args) {
        System.out.println("=== Campus Premiere Ticket Counter Demo ===\n");

        Show show = new Show("SHOW-7PM", "Campus Premiere", java.time.LocalTime.of(19, 0));

        // Create seats
        Seat regA1 = new Seat("A1", new RegularSeat());
        Seat regA2 = new Seat("A2", new RegularSeat());
        Seat preF5 = new Seat("F5", new PremiumSeat());
        Seat reclR1 = new Seat("R1", new ReclinerSeat());

        show.addSeat(regA1);
        show.addSeat(regA2);
        show.addSeat(preF5);
        show.addSeat(reclR1);

        Customer asha = new Customer("CA", "Asha");
        Customer ravi = new Customer("CR", "Ravi");
        Customer neha = new Customer("CN", "Neha");

        System.out.println("Show: " + show + "\n");

        // Asha books: Regular A1, Regular A2, Premium F5
        System.out.println("-- Asha books Regular A1, Regular A2, Premium F5 --");
        Booking bookingAsha = new Booking("BK-A", asha, show);
        bookingAsha.addSeat(show.getSeat("A1"));
        bookingAsha.addSeat(show.getSeat("A2"));
        bookingAsha.addSeat(show.getSeat("F5"));
        System.out.println("Booking confirmed for Asha: A1, A2, F5.");
        System.out.println("Total: ₹" + String.format("%.2f", bookingAsha.getTotalPrice()) + ".00\n");

        // Ravi attempts to book A2
        System.out.println("-- Ravi attempts to book A2 --");
        if (!show.isSeatAvailable("A2")) {
            System.out.println("Seat A2 is already booked for this show.");
        }
        System.out.println();

        // Ravi books Recliner R1
        System.out.println("-- Ravi books Recliner R1 --");
        Booking bookingRavi = new Booking("BK-R", ravi, show);
        bookingRavi.addSeat(show.getSeat("R1"));
        System.out.println("Booking confirmed for Ravi: R1.");
        System.out.println("Total: ₹" + String.format("%.2f", bookingRavi.getTotalPrice()) + ".00\n");

        // Asha cancels before show starts
        System.out.println("-- Asha cancels before show starts --");
        bookingAsha.cancel();
        System.out.println("Seats A1, A2, F5 released.\n");

        // Neha books A2
        System.out.println("-- Neha books A2 --");
        Booking bookingNeha = new Booking("BK-N", neha, show);
        bookingNeha.addSeat(show.getSeat("A2"));
        System.out.println("Booking confirmed for Neha: A2.");
        System.out.println("Total: ₹" + String.format("%.2f", bookingNeha.getTotalPrice()) + ".00\n");

        // Try booking more than 6 seats
        System.out.println("-- Attempt to book more than 6 seats --");
        // (Not demonstrated with these seats, but logic exists)

        System.out.println("=== Demo Complete ===");
    }
}
