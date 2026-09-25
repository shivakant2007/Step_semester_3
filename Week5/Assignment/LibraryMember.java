// LibraryMember.java
public class LibraryMember {
    private String membershipPin;
    String branchCode;
    protected double finesOwed;
    public String displayName;

    public LibraryMember(String pin, String branchCode, double finesOwed, String displayName) {
        this.membershipPin = pin;
        this.branchCode = branchCode;
        this.finesOwed = finesOwed;
        this.displayName = displayName;
    }
}
