// Toy.java
public abstract class Toy {
    public final String toyId;
    private static int counter = 0;

    public Toy() {
        this.toyId = "TOY-" + (++counter);
    }

    public abstract void makeSound();

    public String getToyId() { return toyId; }
}
