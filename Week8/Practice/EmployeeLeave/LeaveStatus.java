package Week8.Practice.EmployeeLeave;

/**
 * Immutable enum representing the lifecycle state of a leave request.
 * Once Approved or Rejected, it cannot revert to Pending.
 */
public enum LeaveStatus {
    PENDING, APPROVED, REJECTED
}
