// LibraryMemberBean.java
public class LibraryMemberBean {
    private String membershipId;
    private boolean membershipIdSet = false;
    private String securityAnswer;
    private String name;
    private boolean premiumMember;

    public LibraryMemberBean() {}

    public LibraryMemberBean(String name) { this.name = name; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public boolean isPremiumMember() { return premiumMember; }
    public void setPremiumMember(boolean premiumMember) { this.premiumMember = premiumMember; }

    public String getMembershipId() { return membershipId; }
    public void setMembershipId(String membershipId) {
        if (!membershipIdSet) {
            this.membershipId = membershipId;
            membershipIdSet = true;
        }
    }

    public void setSecurityAnswer(String securityAnswer) { this.securityAnswer = securityAnswer; }

    public static void main(String[] args) {
        LibraryMemberBean member = new LibraryMemberBean("Alice");
        member.setMembershipId("M001");
        member.setMembershipId("M002");
        System.out.println("Membership ID: " + member.getMembershipId());
        member.setSecurityAnswer("answer123");
        System.out.println("Premium: " + member.isPremiumMember());
    }
}
