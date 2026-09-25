// EnrollmentValidator.java
import java.util.ArrayList;
public class EnrollmentValidator {
    public static void enrollBatch(String[] memberIds, int borrowLimit) {
        int enrolled = 0, rejected = 0;
        ArrayList<LibraryMember> members = new ArrayList<>();
        for (String id : memberIds) {
            try {
                members.add(new LibraryMember(id, borrowLimit));
                enrolled++;
            } catch (IllegalArgumentException e) {
                rejected++;
            }
        }
        System.out.println("Enrolled: " + enrolled + " | Rejected: " + rejected);
    }

    public static void main(String[] args) {
        String[] ids = {"S001", "S002", "S003", "AB", "  "};
        enrollBatch(ids, 5);
    }
}
