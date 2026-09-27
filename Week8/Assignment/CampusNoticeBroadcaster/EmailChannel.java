package Week8.Assignment.CampusNoticeBroadcaster;

/**
 * Email channel delivery.
 */
public class EmailChannel implements NotificationChannel {
    @Override
    public String getChannelName() { return "Email"; }
    @Override
    public void send(Student student, String noticeTitle) {
        System.out.println("[Email → " + student.getName() + "] " + noticeTitle);
    }
}
