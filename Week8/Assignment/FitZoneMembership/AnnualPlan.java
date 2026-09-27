package Week8.Assignment.FitZoneMembership;

/**
 * Annual plan: 12 months, 25% discount.
 */
public class AnnualPlan implements MembershipPlan {
    @Override
    public String getPlanName() { return "Annual"; }
    @Override
    public int getMonths() { return 12; }
    @Override
    public double calculateFee() { return 1000.0 * 12 * 0.75; }
}
