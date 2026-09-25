// LoanReceipt.java
import java.util.Arrays;
public class LoanReceipt {
    private final String bookingId;
    private final int[] bookIds;

    public LoanReceipt(String bookingId, int[] bookIds) {
        this.bookingId = bookingId;
        this.bookIds = Arrays.copyOf(bookIds, bookIds.length);
    }

    public int[] getBookIds() { return Arrays.copyOf(bookIds, bookIds.length); }

    public LoanReceipt withCorrectedBookId(int index, int newId) {
        int[] newIds = Arrays.copyOf(bookIds, bookIds.length);
        newIds[index] = newId;
        return new LoanReceipt(bookingId, newIds);
    }
}

class ReferenceOnlyLoanReceipt extends LoanReceipt {
    public ReferenceOnlyLoanReceipt(String id, int[] books) { super(id, books); }
}

class CirculationLedger {
    static { System.out.println("Ledger initialized"); }

    public static void processNightlyCirculation(LoanReceipt[] receipts) {
        int processed = 0, nullSkipped = 0, refOnly = 0, regular = 0;
        for (LoanReceipt r : receipts) {
            if (r == null) { nullSkipped++; continue; }
            processed++;
            if (r instanceof ReferenceOnlyLoanReceipt) refOnly++; else regular++;
        }
        System.out.println(processed + " processed | " + nullSkipped + " null skipped | " + refOnly + " reference-only | " + regular + " regular");
    }

    public static void main(String[] args) {
        LoanReceipt[] receipts = new LoanReceipt[4];
        receipts[0] = new LoanReceipt("L001", new int[]{1, 2});
        receipts[1] = null;
        receipts[2] = new ReferenceOnlyLoanReceipt("L002", new int[]{3});
        receipts[3] = new LoanReceipt("L003", new int[]{4, 5, 6});
        processNightlyCirculation(receipts);
    }
}
