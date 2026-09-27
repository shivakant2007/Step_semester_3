package Week8.Assignment.FitZoneMembership;

/**
 * Interface for membership plans.
 * Each plan implements its own fee calculation.
 */
public interface MembershipPlan {
    String getPlanName();
    int getMonths();
    double calculateFee();
}
