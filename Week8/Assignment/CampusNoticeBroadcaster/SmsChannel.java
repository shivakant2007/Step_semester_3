package Week8.Assignment.CampusNoticeBroadcaster;

/**
 * SMS channel delivery.
 */
public class SmsChannel implements NotificationChannel {
    @Override
    public String getChannelName() { return "SMS"; }
    @Override
    public void send(Student student, String noticeTitle) {
        System.out.println("[SMS → " + student.getName() + "] " + noticeTitle);
    }
}
