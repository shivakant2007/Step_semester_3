// GymSignup.java
import java.util.ArrayList;
public class GymSignup {
    public static void signUpBatch(String[] memberIds, int monthlyFee) {
        int signedUp = 0, rejected = 0;
        for (String id : memberIds) {
            try {
                new GymMember(id, monthlyFee);
                signedUp++;
            } catch (IllegalArgumentException e) {
                rejected++;
            }
        }
        System.out.println("Signed Up: " + signedUp + " | Rejected: " + rejected);
    }

    public static void main(String[] args) {
        String[] ids = {"G001", "G002", "G003", "AB", "  "};
        signUpBatch(ids, 500);
    }
}
