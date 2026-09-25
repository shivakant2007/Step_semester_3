// EliteMember.java
public class EliteMember extends PremiumMember {
    public EliteMember(String memberId, int monthlyFee, String trainerName) {
        super(memberId, monthlyFee, trainerName);
    }

    @Override
    public void displayInfo() {
        System.out.println("Elite Member: " + memberId);
    }
}
