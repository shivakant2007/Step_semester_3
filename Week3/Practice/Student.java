// Student.java
public class Student {
    String name;
    int attendance;
    static String collegeName = "STEP College";
    static int studentCount = 0;

    public Student(String name, int attendance) {
        this.name = name;
        this.attendance = attendance;
        studentCount++;
    }

    public static void printCollegeInfo() {
        System.out.println("College: " + collegeName + ", Total Students: " + studentCount);
    }

    public static void main(String[] args) {
        Student s1 = new Student("Alice", 95);
        Student s2 = new Student("Bob", 88);
        Student.printCollegeInfo();
    }
}
