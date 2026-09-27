package Week8.Assignment.HostelLaundry;

/**
 * Abstract base class for wash types.
 * Each type owns its own duration and charge.
 */
public abstract class WashType {
    private final String typeName;
    public WashType(String typeName) { this.typeName = typeName; }
    public abstract int getDurationMinutes();
    public abstract double getCharge();
    public String getTypeName() { return typeName; }
    @Override
    public String toString() { return typeName + " (" + getDurationMinutes() + " min, ₹" + String.format("%.2f", getCharge()) + ")"; }
}

/**
 * Quick wash: 30 minutes, ₹20.
 */
class QuickWash extends WashType {
    public QuickWash() { super("Quick"); }
    @Override public int getDurationMinutes() { return 30; }
    @Override public double getCharge() { return 20.0; }
}

/**
 * Normal wash: 45 minutes, ₹30.
 */
class NormalWash extends WashType {
    public NormalWash() { super("Normal"); }
    @Override public int getDurationMinutes() { return 45; }
    @Override public double getCharge() { return 30.0; }
}

/**
 * Heavy wash: 60 minutes, ₹45.
 */
class HeavyWash extends WashType {
    public HeavyWash() { super("Heavy"); }
    @Override public int getDurationMinutes() { return 60; }
    @Override public double getCharge() { return 45.0; }
}
