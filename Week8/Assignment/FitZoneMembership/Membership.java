package Week8.Assignment.FitZoneMembership;

/**
 * Tracks a member's membership status and plan.
 */
public class Membership {
    private final MembershipPlan plan;
    private MembershipStatus status;

    public Membership(MembershipPlan plan) {
        this.plan = plan;
        this.status = MembershipStatus.ACTIVE;
    }

    public MembershipPlan getPlan() { return plan; }
    public MembershipStatus getStatus() { return status; }
    public double getFee() { return plan.calculateFee(); }
    public int getMonths() { return plan.getMonths(); }

    /**
     * Freezes the membership. Only allowed when Active.
     */
    public void freeze() {
        if (status == MembershipStatus.EXPIRED) {
            throw new IllegalStateException("Cannot freeze an Expired membership.");
        }
        if (status == MembershipStatus.FROZEN) {
            throw new IllegalStateException("Membership is already Frozen.");
        }
        this.status = MembershipStatus.FROZEN;
    }

    /**
     * Unfreezes the membership. Only allowed when Frozen.
     */
    public void unfreeze() {
        if (status == MembershipStatus.EXPIRED) {
            throw new IllegalStateException("Cannot unfreeze an Expired membership.");
        }
        if (status != MembershipStatus.FROZEN) {
            throw new IllegalStateException("Cannot unfreeze a non-Frozen membership.");
        }
        this.status = MembershipStatus.ACTIVE;
    }

    /**
     * Marks membership as expired.
     */
    public void expire() {
        this.status = MembershipStatus.EXPIRED;
    }

    /**
     * Returns whether check-in is allowed.
     */
    public boolean canCheckIn() {
        return status == MembershipStatus.ACTIVE;
    }
}
