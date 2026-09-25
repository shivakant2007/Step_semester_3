// GroupClassMember.java
public class GroupClassMember extends GymMember {
    public GroupClassMember(String memberId, int monthlyFee) {
        super(memberId, monthlyFee);
    }

    @Override
    public void displayInfo() {
        System.out.println("Group Class Member: " + memberId);
    }
}
