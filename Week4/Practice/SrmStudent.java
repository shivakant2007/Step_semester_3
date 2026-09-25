// SrmStudent.java
public class SrmStudent {
    String name;
    static String collegeName;
    static String academicYear;

    static {
        collegeName = "SRM University";
        academicYear = "2024-25";
        System.out.println("College info loaded");
    }

    public SrmStudent(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        String[] names = {"Ravi", "Meera", "Karthik", "Divya", "Anitha"};
        for (String name : names) {
            SrmStudent student = new SrmStudent(name);
            System.out.println("Student record created: " + name);
        }
    }
}
