package Week8.Assignment.HostelLaundry;

/**
 * Demo class for the Hostel Laundry Queue system.
 */
public class HostelLaundrySystem {
    public static void main(String[] args) {
        System.out.println("=== Hostel Laundry Queue Demo ===\n");

        WashingMachine m1 = new WashingMachine("M1");
        WashingMachine m2 = new WashingMachine("M2");

        Student asha = new Student("S1", "Asha");
        Student ravi = new Student("S2", "Ravi");
        Student neha = new Student("S3", "Neha");

        WashType quick = new QuickWash();
        WashType normal = new NormalWash();
        WashType heavy = new HeavyWash();

        // Asha starts Quick wash on M1
        System.out.println("-- Asha starts Quick wash on M1 --");
        m1.startWash(quick, asha);
        System.out.println("M1 busy? " + m1.isBusy() + "\n");

        // Ravi attempts Heavy wash on M1
        System.out.println("-- Ravi attempts Heavy wash on M1 --");
        m1.startWash(heavy, ravi);
        System.out.println();

        // Ravi starts Heavy wash on M2
        System.out.println("-- Ravi starts Heavy wash on M2 --");
        m2.startWash(heavy, ravi);
        System.out.println("M2 busy? " + m2.isBusy() + "\n");

        // M1 completes cycle
        System.out.println("-- M1 completes its cycle --");
        m1.completeCycle();
        System.out.println();

        // Neha starts Normal wash on M1
        System.out.println("-- Neha starts Normal wash on M1 --");
        m1.startWash(normal, neha);
        System.out.println("M1 busy? " + m1.isBusy() + "\n");

        System.out.println("=== Demo Complete ===");
    }
}
