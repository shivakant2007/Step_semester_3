// DuplicateSeatChecker.java
public class DuplicateSeatChecker {

    void checkDuplicateSeats(int[] seatNumbers) {
        boolean found = false;
        for (int i = 0; i < seatNumbers.length; i++) {
            for (int j = i + 1; j < seatNumbers.length; j++) {
                if (seatNumbers[i] == seatNumbers[j]) {
                    boolean alreadyPrinted = false;
                    for (int k = 0; k < i; k++) {
                        if (seatNumbers[k] == seatNumbers[i]) {
                            alreadyPrinted = true;
                            break;
                        }
                    }
                    if (!alreadyPrinted) {
                        System.out.println("Duplicate Seat Found: " + seatNumbers[i]);
                        found = true;
                    }
                }
            }
        }
        if (!found) {
            System.out.println("No Duplicate Seats Found");
        }
    }

    public static void main(String[] args) {
        DuplicateSeatChecker checker = new DuplicateSeatChecker();

        System.out.println("Test 1: {101, 102, 103, 101, 104, 102}");
        checker.checkDuplicateSeats(new int[]{101, 102, 103, 101, 104, 102});

        System.out.println();
        System.out.println("Test 2: {101, 102, 103}");
        checker.checkDuplicateSeats(new int[]{101, 102, 103});
    }
}
