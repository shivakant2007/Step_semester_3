package Week8.Assignment.CampusNoticeBroadcaster;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a college student belonging to a department
 * with preferred notification channels.
 */
public class Student {
    private final String studentId;
    private final String name;
    private final String department;
    private final List<NotificationChannel> preferredChannels;

    public Student(String studentId, String name, String department) {
        this.studentId = studentId;
        this.name = name;
        this.department = department;
        this.preferredChannels = new ArrayList<>();
    }

    public String getStudentId() { return studentId; }
    public String getName() { return name; }
    public String getDepartment() { return department; }

    public void addPreferredChannel(NotificationChannel channel) {
        preferredChannels.add(channel);
    }

    public List<NotificationChannel> getPreferredChannels() { return preferredChannels; }

    /**
     * Receives a notice through a channel.
     */
    public void receive(NotificationChannel channel, String noticeTitle) {
        channel.send(this, noticeTitle);
    }

    @Override
    public String toString() { return name + " (" + studentId + ", Dept: " + department + ")"; }
}
