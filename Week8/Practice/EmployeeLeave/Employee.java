package Week8.Practice.EmployeeLeave;

/**
 * Base employee type. Different employee types may have different leave policies.
 */
public abstract class Employee {
    private final String employeeId;
    private final String name;

    public Employee(String employeeId, String name) {
        this.employeeId = employeeId;
        this.name = name;
    }

    public String getEmployeeId() { return employeeId; }
    public String getName() { return name; }

    /**
     * Returns the maximum allowed leave days for this employee type.
     */
    public abstract int getMaxLeaveDays();

    /**
     * Returns the reviewer type name for this employee.
     */
    public abstract String getReviewerRole();

    @Override
    public String toString() { return name + " (" + employeeId + ")"; }
}

/**
 * Full-time employees get up to 30 leave days.
 */
class FullTimeEmployee extends Employee {
    public FullTimeEmployee(String employeeId, String name) {
        super(employeeId, name);
    }
    @Override
    public int getMaxLeaveDays() { return 30; }
    @Override
    public String getReviewerRole() { return "Manager"; }
}

/**
 * Part-time employees get up to 15 leave days.
 */
class PartTimeEmployee extends Employee {
    public PartTimeEmployee(String employeeId, String name) {
        super(employeeId, name);
    }
    @Override
    public int getMaxLeaveDays() { return 15; }
    @Override
    public String getReviewerRole() { return "Supervisor"; }
}

/**
 * Contractors get up to 10 leave days.
 */
class Contractor extends Employee {
    public Contractor(String employeeId, String name) {
        super(employeeId, name);
    }
    @Override
    public int getMaxLeaveDays() { return 10; }
    @Override
    public String getReviewerRole() { return "Coordinator"; }
}
