package Week8.Assignment.FitZoneMembership;

/**
 * Represents a gym member.
 */
public class Member {
    private final String memberId;
    private final String name;
    private Membership membership;

    public Member(String memberId, String name) {
        this.memberId = memberId;
        this.name = name;
    }

    public String getMemberId() { return memberId; }
    public String getName() { return name; }
    public Membership getMembership() { return membership; }

    void setMembership(Membership membership) { this.membership = membership; }

    public boolean checkIn() {
        return membership != null && membership.canCheckIn();
    }

    @Override
    public String toString() { return name + " (" + memberId + ")"; }
}
