// WeeklyReport.java
import java.util.ArrayList;
public class WeeklyReport {
    public static String batchPrint(LibraryMember[] members) {
        StringBuilder sb = new StringBuilder();
        for (LibraryMember m : members) {
            if (m instanceof StudentMember) {
                StudentMember sm = (StudentMember) m;
                sb.append("Student: ").append(sm.getCourse()).append("\n");
            } else {
                m.displayInfo();
            }
        }
        return sb.toString();
    }
}
