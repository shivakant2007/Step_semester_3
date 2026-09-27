package Week8.Practice.EmployeeLeave;

import java.time.LocalDate;

/**
 * Represents a leave request. Status transitions are strictly controlled:
 * PENDING -> APPROVED or PENDING -> REJECTED.
 * Once APPROVED or REJECTED, the request cannot revert to PENDING.
 */
public class LeaveRequest {
    private final Employee employee;
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final int requestedDays;
    private LeaveStatus status;

    public LeaveRequest(Employee employee, LocalDate startDate, LocalDate endDate) {
        this.employee = employee;
        this.startDate = startDate;
        this.endDate = endDate;
        this.requestedDays = (int) java.time.temporal.ChronoUnit.DAYS.between(startDate, endDate);
        this.status = LeaveStatus.PENDING;
    }

    public Employee getEmployee() { return employee; }
    public LocalDate getStartDate() { return startDate; }
    public LocalDate getEndDate() { return endDate; }
    public int getRequestedDays() { return requestedDays; }

    /**
     * Package-private state transition. Only the leave system can change status.
     */
    void approve() {
        if (status != LeaveStatus.PENDING) {
            throw new IllegalStateException(
                    "Cannot approve a request that is already " + status);
        }
        this.status = LeaveStatus.APPROVED;
    }

    /**
     * Package-private state transition. Only the leave system can change status.
     */
    void reject() {
        if (status != LeaveStatus.PENDING) {
            throw new IllegalStateException(
                    "Cannot reject a request that is already " + status);
        }
        this.status = LeaveStatus.REJECTED;
    }

    /**
     * External code cannot revert status. This method throws an exception.
     */
    public void revertToPending() {
        if (status == LeaveStatus.APPROVED || status == LeaveStatus.REJECTED) {
            throw new IllegalStateException(
                    "Cannot change leave request status from " + status + " back to Pending.");
        }
    }

    public LeaveStatus getStatus() { return status; }

    @Override
    public String toString() {
        return employee.getName() + "'s leave (" + startDate + " to " + endDate
                + "): " + requestedDays + " days. Status: " + status;
    }
}
