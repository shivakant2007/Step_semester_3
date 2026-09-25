// AttendanceAnnouncer.java
public class AttendanceAnnouncer {
    public static String batchPrint(GymMember[] members) {
        StringBuilder sb = new StringBuilder();
        for (GymMember m : members) {
            if (m instanceof PremiumMember) {
                PremiumMember pm = (PremiumMember) m;
                sb.append("Premium: ").append(pm.getTrainerName()).append("\n");
            } else {
                m.displayInfo();
            }
        }
        return sb.toString();
    }
}
