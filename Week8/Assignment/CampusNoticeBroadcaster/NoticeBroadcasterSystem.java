package Week8.Assignment.CampusNoticeBroadcaster;

import java.util.Arrays;

/**
 * Demo class for the Campus Notice Broadcaster system.
 */
public class NoticeBroadcasterSystem {
    public static void main(String[] args) {
        System.out.println("=== Campus Notice Broadcaster Demo ===\n");

        NotificationChannel email = new EmailChannel();
        NotificationChannel sms = new SmsChannel();
        NotificationChannel app = new AppChannel();

        NoticeBoard board = new NoticeBoard(Arrays.asList(email, sms, app));

        Student asha = new Student("S1", "Asha", "CSE");
        Student ravi = new Student("S2", "Ravi", "ECE");

        asha.addPreferredChannel(email);
        asha.addPreferredChannel(app);
        ravi.addPreferredChannel(sms);

        board.registerStudent(asha);
        board.registerStudent(ravi);

        // Admin posts "Lab Closed Tomorrow" targeting CSE
        System.out.println("-- Admin posts 'Lab Closed Tomorrow' to CSE --");
        Notice notice1 = new Notice("Lab Closed Tomorrow", Arrays.asList("CSE"));
        board.postNotice(notice1);
        System.out.println();

        // Admin posts "Fee Deadline Extended" targeting CSE, ECE
        System.out.println("-- Admin posts 'Fee Deadline Extended' to CSE, ECE --");
        Notice notice2 = new Notice("Fee Deadline Extended", Arrays.asList("CSE", "ECE"));
        board.postNotice(notice2);
        System.out.println();

        // Admin attempts to post with no target department
        System.out.println("-- Admin attempts to post 'Sports Day' with no target --");
        Notice notice3 = new Notice("Sports Day", Arrays.asList());
        board.postNotice(notice3);

        System.out.println("\n=== Demo Complete ===");
    }
}
