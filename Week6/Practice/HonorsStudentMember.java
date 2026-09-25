// HonorsStudentMember.java
public class HonorsStudentMember extends StudentMember {
    public HonorsStudentMember(String memberId, int borrowLimit, String course) {
        super(memberId, borrowLimit, course);
    }

    @Override
    public void displayInfo() {
        System.out.println("Honors Student: " + memberId + " course: " + getCourse());
    }
}
