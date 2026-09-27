package Week8.Assignment.CampusNoticeBroadcaster;

import java.util.List;
import java.util.ArrayList;

/**
 * Central notice board that depends on NotificationChannel abstraction.
 */
public class NoticeBoard {
    private final List<NotificationChannel> channels;
    private final List<Student> allStudents;

    public NoticeBoard(List<NotificationChannel> channels) {
        this.channels = channels;
        this.allStudents = new ArrayList<>();
    }

    public void registerStudent(Student student) {
        allStudents.add(student);
    }

    /**
     * Posts a notice to all students in target departments through their preferred channels.
     */
    public boolean postNotice(Notice notice) {
        if (!notice.isValid()) {
            System.out.println("Cannot post notice: At least one target department is required.");
            return false;
        }

        System.out.println("Notice '" + notice.getTitle() + "' posted to "
                + notice.getTargetDepartments() + ".");
        System.out.println();

        for (Student student : allStudents) {
            if (notice.getTargetDepartments().contains(student.getDepartment())) {
                for (NotificationChannel channel : student.getPreferredChannels()) {
                    channel.send(student, notice.getTitle());
                }
            }
        }
        return true;
    }
}
