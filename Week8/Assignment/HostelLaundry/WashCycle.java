package Week8.Assignment.HostelLaundry;

/**
 * Tracks a single wash cycle on a machine.
 */
public class WashCycle {
    private final Student student;
    private final WashingMachine machine;
    private final WashType washType;
    private final boolean completed;

    public WashCycle(Student student, WashingMachine machine, WashType washType) {
        this.student = student;
        this.machine = machine;
        this.washType = washType;
        this.completed = false;
    }

    public Student getStudent() { return student; }
    public WashingMachine getMachine() { return machine; }
    public WashType getWashType() { return washType; }
    public boolean isCompleted() { return completed; }

    public void complete() {
        // Internal completion marker
    }

    @Override
    public String toString() {
        return student.getName() + " started " + washType.getTypeName()
                + " wash on " + machine.getMachineId() + ".";
    }
}
