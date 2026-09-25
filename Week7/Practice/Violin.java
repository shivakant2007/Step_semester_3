// Violin.java
public class Violin extends StringInstrument {
    @Override
    public void play() {
        super.play();
        System.out.println("Violin: with a bow drawn across four strings");
    }

    public static void main(String[] args) {
        Violin v = new Violin();
        v.play();
    }
}
