// LibraryMember.java
public class LibraryMember {
    protected String memberId;
    protected int borrowLimit;
    protected int booksBorrowed;
    protected final int memberNumber;
    private static int counter = 0;

    public LibraryMember(String memberId, int borrowLimit) {
        if (memberId == null || memberId.trim().isEmpty() || memberId.trim().length() < 4) {
            throw new IllegalArgumentException("Invalid memberId: " + memberId);
        }
        this.memberId = memberId;
        this.borrowLimit = borrowLimit;
        this.memberNumber = ++counter;
    }

    public void borrowBook() {
        if (booksBorrowed < borrowLimit) booksBorrowed++;
    }

    public void displayInfo() {
        System.out.println("LibraryMember: " + memberId);
    }

    protected void chargeFine(int amount) {
        // base implementation
    }

    public int getBooksBorrowed() { return booksBorrowed; }

    public static int getMembersEnrolled() { return counter; }
}
