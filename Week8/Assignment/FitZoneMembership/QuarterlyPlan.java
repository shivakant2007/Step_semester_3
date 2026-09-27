package Week8.Assignment.FitZoneMembership;

/**
 * Quarterly plan: 3 months, 10% discount.
 */
public class QuarterlyPlan implements MembershipPlan {
    @Override
    public String getPlanName() { return "Quarterly"; }
    @Override
    public int getMonths() { return 3; }
    @Override
    public double calculateFee() { return 1000.0 * 3 * 0.90; }
}
