// MembershipAudit.java
import java.util.ArrayList;
public class MembershipAudit {
    public static String getRenewalCode(int num) {
        String digits = String.format("%02d", num % 100);
        char letter = (char)('A' + num % 26);
        return "R" + digits + letter;
    }

    public static void processNightlyAudit(LibraryMember[] members) {
        int processed = 0, nullSkipped = 0, faculty = 0, regular = 0;
        for (LibraryMember m : members) {
            if (m == null) { nullSkipped++; continue; }
            processed++;
            if (m instanceof FacultyMember) faculty++; else regular++;
        }
        System.out.println(processed + " processed | " + nullSkipped + " null skipped | " + faculty + " faculty | " + regular + " regular");
    }

    public static void main(String[] args) {
        System.out.println("Renewal code: " + getRenewalCode(12));
    }
}
