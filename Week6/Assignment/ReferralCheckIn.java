// ReferralCheckIn.java
import java.util.ArrayList;
public class ReferralCheckIn {
    public static boolean isValidReferralCode(String code) {
        if (code == null || code.length() < 4) return false;
        if (code.charAt(0) != 'G') return false;
        if (!Character.isDigit(code.charAt(1)) || !Character.isDigit(code.charAt(2))) return false;
        if (!Character.isUpperCase(code.charAt(3))) return false;
        return true;
    }

    public static void processWeeklyCheckIn(GymMember[] members) {
        int processed = 0, nullSkipped = 0, group = 0, individual = 0;
        for (GymMember m : members) {
            if (m == null) { nullSkipped++; continue; }
            processed++;
            if (m instanceof GroupClassMember) group++; else individual++;
        }
        System.out.println(processed + " processed | " + nullSkipped + " null skipped | " + group + " group | " + individual + " individual");
    }

    public static void main(String[] args) {
        System.out.println("Valid G45B: " + isValidReferralCode("G45B"));
    }
}
