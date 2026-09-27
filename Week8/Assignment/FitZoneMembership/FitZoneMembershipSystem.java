package Week8.Assignment.FitZoneMembership;

/**
 * Demo class for the FitZone Membership Desk system.
 */
public class FitZoneMembershipSystem {
    public static void main(String[] args) {
        System.out.println("=== FitZone Membership Desk Demo ===\n");

        MembershipPlan quarterly = new QuarterlyPlan();
        MembershipPlan monthly = new MonthlyPlan();

        // Asha buys Quarterly membership
        System.out.println("-- Asha buys Quarterly membership --");
        Membership ashasMem = new Membership(quarterly);
        Member asha = new Member("M1", "Asha");
        asha.setMembership(ashasMem);
        System.out.println("Quarterly membership created for Asha.");
        System.out.println("Fee: ₹" + String.format("%.2f", ashasMem.getFee()) + ".00");
        System.out.println("Status: " + ashasMem.getStatus() + "\n");

        // Ravi buys Monthly membership
        System.out.println("-- Ravi buys Monthly membership --");
        Membership ravisMem = new Membership(monthly);
        Member ravi = new Member("M2", "Ravi");
        ravi.setMembership(ravisMem);
        System.out.println("Monthly membership created for Ravi.");
        System.out.println("Fee: ₹" + String.format("%.2f", ravisMem.getFee()) + ".00");
        System.out.println("Status: " + ravisMem.getStatus() + "\n");

        // Asha checks in
        System.out.println("-- Asha checks in --");
        System.out.println("Asha checked in " + (asha.checkIn() ? "successfully" : "failed") + ".\n");

        // Asha freezes her membership
        System.out.println("-- Asha freezes her membership --");
        ashasMem.freeze();
        System.out.println("Asha's membership frozen. Status: " + ashasMem.getStatus() + "\n");

        // Asha attempts to check in
        System.out.println("-- Asha attempts to check in --");
        System.out.println("Check-in denied: Asha's membership is " + ashasMem.getStatus() + ".\n");

        // Ravi's membership expires
        System.out.println("-- Ravi's membership expires --");
        ravisMem.expire();
        System.out.println("Ravi's membership expired. Status: " + ravisMem.getStatus() + "\n");

        // Ravi attempts to freeze
        System.out.println("-- Ravi attempts to freeze his membership --");
        try {
            ravisMem.freeze();
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\n=== Demo Complete ===");
    }
}
