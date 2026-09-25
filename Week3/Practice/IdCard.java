// IdCard.java
public class IdCard {
    String name;
    int booksIssued;

    public IdCard(String name, int booksIssued) {
        this.name = name;
        this.booksIssued = booksIssued;
    }

    public static void main(String[] args) {
        IdCard ravi = new IdCard("Ravi", 5);
        IdCard another = ravi;
        another.booksIssued = 10;
        System.out.println("First reference sees: " + ravi.booksIssued);
        System.out.println("same object: " + (another == ravi));

        IdCard separate = new IdCard("Ravi", 5);
        System.out.println("separate == ravi: " + (separate == ravi));
    }
}
