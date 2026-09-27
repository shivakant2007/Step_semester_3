package Week8.Assignment.CampusNoticeBroadcaster;

/**
 * App channel delivery.
 */
public class AppChannel implements NotificationChannel {
    @Override
    public String getChannelName() { return "App"; }
    @Override
    public void send(Student student, String noticeTitle) {
        System.out.println("[App → " + student.getName() + "] " + noticeTitle);
    }
}
