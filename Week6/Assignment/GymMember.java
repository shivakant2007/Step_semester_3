// GymMember.java
public class GymMember {
    protected String memberId;
    protected int monthlyFee;
    protected int sessionsAttended;
    protected final int membershipNumber;
    private static int counter = 0;

    public GymMember(String memberId, int monthlyFee) {
        if (memberId == null || memberId.trim().isEmpty() || memberId.trim().length() < 4) {
            throw new IllegalArgumentException("Invalid memberId: " + memberId);
        }
        this.memberId = memberId;
        this.monthlyFee = monthlyFee;
        this.membershipNumber = ++counter;
    }

    public void attendSession() { sessionsAttended++; }
    public int getSessionsAttended() { return sessionsAttended; }

    public void displayInfo() {
        System.out.println("GymMember: " + memberId);
    }

    public static int getMembersEnrolled() { return counter; }
}
