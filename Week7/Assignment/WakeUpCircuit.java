// WakeUpCircuit.java
public class WakeUpCircuit {
    public static void ringAll(Ringable[] devices) {
        for (Ringable d : devices) System.out.println(d.ring());
    }

    public static void main(String[] args) {
        ringAll(new Ringable[]{new AlarmClock(), new Doorbell()});
    }
}
