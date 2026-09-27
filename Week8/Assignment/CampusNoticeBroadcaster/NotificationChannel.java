package Week8.Assignment.CampusNoticeBroadcaster;

/**
 * Interface for notification channels.
 * Each channel delivers messages in its own way.
 */
public interface NotificationChannel {
    String getChannelName();
    void send(Student student, String noticeTitle);
}
