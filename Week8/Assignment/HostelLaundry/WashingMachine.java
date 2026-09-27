package Week8.Assignment.HostelLaundry;

/**
 * A washing machine that controls its own busy/free state.
 * External code cannot arbitrarily modify the status.
 */
public class WashingMachine {
    private final String machineId;
    private boolean busy;
    private WashCycle currentCycle;

    public WashingMachine(String machineId) {
        this.machineId = machineId;
        this.busy = false;
        this.currentCycle = null;
    }

    public String getMachineId() { return machineId; }

    /**
     * Only set by the system internally.
     */
    void setBusy(boolean busy) { this.busy = busy; }

    public boolean isBusy() { return busy; }

    public WashCycle getCurrentCycle() { return currentCycle; }

    /**
     * Starts a wash cycle if the machine is free.
     */
    public boolean startWash(WashType washType, Student student) {
        if (busy) {
            System.out.println("Machine " + machineId + " is currently busy.");
            return false;
        }
        this.busy = true;
        this.currentCycle = new WashCycle(student, this, washType);
        System.out.println(washType.getTypeName() + " wash started on " + machineId
                + " for " + student.getName() + " (" + washType.getDurationMinutes() + " min).");
        System.out.println("Charge: ₹" + String.format("%.2f", washType.getCharge()) + ".");
        return true;
    }

    /**
     * Completes the current wash cycle and makes the machine free.
     */
    public void completeCycle() {
        if (currentCycle != null) {
            currentCycle.complete();
            System.out.println(machineId + " cycle completed.");
        }
        this.busy = false;
        this.currentCycle = null;
        System.out.println(machineId + " is now free.");
    }
}
