// ToyCar.java
public class ToyCar extends Toy {
    @Override
    public void makeSound() {
        System.out.println(toyId + ": Vroom vroom!");
    }

    public static void main(String[] args) {
        ToyCar car = new ToyCar();
        car.makeSound();
    }
}
