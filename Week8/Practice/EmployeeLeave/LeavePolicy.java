package Week8.Practice.EmployeeLeave;

import java.time.LocalDate;

/**
 * Core leave-processing workflow. Handles submitting, reviewing, approving,
 * and rejecting leave requests. Adding a new employee type does NOT require
 * modifying this class.
 */
public class LeavePolicy {
    /**
     * Submits a new leave request for the given employee.
     */
    public LeaveRequest submitLeave(Employee employee, LocalDate startDate, LocalDate endDate) {
        LeaveRequest request = new LeaveRequest(employee, startDate, endDate);
        System.out.println("Leave request submitted for " + employee.getName()
                + " (" + startDate + " to " + endDate + ").");
        System.out.println("Status: " + request.getStatus());
        return request;
    }

    /**
     * Reviews and approves a pending request.
     */
    public void reviewAndApprove(LeaveRequest request) {
        if (request.getStatus() != LeaveStatus.PENDING) {
            System.out.println("Cannot approve: request is already " + request.getStatus());
            return;
        }
        request.approve();
        System.out.println("Request approved for " + request.getEmployee().getName() + ".");
        System.out.println("Status: " + request.getStatus());
    }

    /**
     * Reviews and rejects a pending request.
     */
    public void reviewAndReject(LeaveRequest request) {
        if (request.getStatus() != LeaveStatus.PENDING) {
            System.out.println("Cannot reject: request is already " + request.getStatus());
            return;
        }
        request.reject();
        System.out.println("Request rejected for " + request.getEmployee().getName() + ".");
        System.out.println("Status: " + request.getStatus());
    }
}
