package Week8.Practice.EmployeeLeave;

import java.time.LocalDate;

/**
 * Demo class for the Employee Leave Request Workflow.
 */
public class EmployeeLeaveSystem {
    public static void main(String[] args) {
        LeavePolicy policy = new LeavePolicy();

        FullTimeEmployee john = new FullTimeEmployee("FT01", "John");
        PartTimeEmployee jane = new PartTimeEmployee("PT01", "Jane");

        System.out.println("=== Employee Leave Request Workflow Demo ===\n");

        // John submits leave request for 5 days (Jan 1-5)
        System.out.println("-- FullTimeEmployee John submits leave for Jan 1-5 --");
        LeaveRequest johnRequest = policy.submitLeave(john,
                LocalDate.of(2025, 1, 1), LocalDate.of(2025, 1, 5));
        System.out.println();

        // Manager Alice reviews and approves John's request
        System.out.println("-- Manager Alice approves John's request --");
        policy.reviewAndApprove(johnRequest);
        System.out.println();

        // John attempts to change approved request back to Pending
        System.out.println("-- John attempts to revert approved request to Pending --");
        try {
            johnRequest.revertToPending();
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println();

        // Jane submits leave request for 2 days (Feb 10-11)
        System.out.println("-- PartTimeEmployee Jane submits leave for Feb 10-11 --");
        LeaveRequest janeRequest = policy.submitLeave(jane,
                LocalDate.of(2025, 2, 10), LocalDate.of(2025, 2, 11));
        System.out.println();

        // Manager Bob reviews and rejects Jane's request
        System.out.println("-- Manager Bob rejects Jane's request --");
        policy.reviewAndReject(janeRequest);
        System.out.println();

        // Try to revert Jane's rejected request
        System.out.println("-- Jane attempts to revert rejected request --");
        try {
            janeRequest.revertToPending();
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\n=== Demo Complete ===");
    }
}
