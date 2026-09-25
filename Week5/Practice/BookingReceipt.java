// BookingReceipt.java
import java.util.Arrays;
public class BookingReceipt {
    private final String bookingId;
    private final int[] seatNumbers;

    public BookingReceipt(String bookingId, int[] seatNumbers) {
        this.bookingId = bookingId;
        this.seatNumbers = Arrays.copyOf(seatNumbers, seatNumbers.length);
    }

    public int[] getSeatNumbers() { return Arrays.copyOf(seatNumbers, seatNumbers.length); }

    public BookingReceipt withUpdatedSeat(int index, int newSeat) {
        int[] newSeats = Arrays.copyOf(seatNumbers, seatNumbers.length);
        newSeats[index] = newSeat;
        return new BookingReceipt(bookingId, newSeats);
    }

    public static void main(String[] args) {
        BookingReceipt br = new BookingReceipt("B001", new int[]{1, 2, 3});
        System.out.println("Seats: " + Arrays.toString(br.getSeatNumbers()));
    }
}

class GroupBookingReceipt extends BookingReceipt {
    public GroupBookingReceipt(String id, int[] seats) { super(id, seats); }
}

class ReceiptSettlement {
    public static void processNightlySettlement(BookingReceipt[] receipts) {
        int processed = 0, nullSkipped = 0, group = 0, individual = 0;
        for (BookingReceipt r : receipts) {
            if (r == null) { nullSkipped++; continue; }
            processed++;
            if (r instanceof GroupBookingReceipt) group++; else individual++;
        }
        System.out.println(processed + " processed | " + nullSkipped + " null skipped | " + group + " group | " + individual + " individual");
    }
}
