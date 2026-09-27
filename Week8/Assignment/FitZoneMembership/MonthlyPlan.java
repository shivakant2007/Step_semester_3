package Week8.Assignment.FitZoneMembership;

/**
 * Monthly plan: 1 month, full price ₹1,000.
 */
public class MonthlyPlan implements MembershipPlan {
    @Override
    public String getPlanName() { return "Monthly"; }
    @Override
    public int getMonths() { return 1; }
    @Override
    public double calculateFee() { return 1000.0; }
}
