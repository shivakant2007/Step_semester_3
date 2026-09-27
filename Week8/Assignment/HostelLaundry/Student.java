package Week8.Assignment.HostelLaundry;

/**
 * Represents a student using the hostel laundry system.
 */
public class Student {
    private final String studentId;
    private final String name;

    public Student(String studentId, String name) {
        this.studentId = studentId;
        this.name = name;
    }

    public String getStudentId() { return studentId; }
    public String getName() { return name; }

    @Override
    public String toString() { return name + " (" + studentId + ")"; }
}
