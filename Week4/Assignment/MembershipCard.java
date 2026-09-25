// MembershipCard.java
public class MembershipCard {
    String studentName;
    static String libraryName;
    static String validUntil;

    static {
        libraryName = "SRM Central Library";
        validUntil = "May 2027";
        System.out.println("Library info loaded");
    }

    public MembershipCard(String studentName) {
        this.studentName = studentName;
    }

    public static void main(String[] args) {
        String[] names = {"Ravi", "Meera", "Karthik", "Divya", "Anitha"};
        for (String name : names) {
            MembershipCard card = new MembershipCard(name);
            System.out.println("Membership card issued: " + name);
        }
    }
}
