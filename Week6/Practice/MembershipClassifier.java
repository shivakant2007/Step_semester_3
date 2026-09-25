// MembershipClassifier.java
public class MembershipClassifier {
    public static String classifyGeneration(LibraryMember member) {
        if (member instanceof HonorsStudentMember) return "HonorsStudentMember";
        if (member instanceof FacultyMember) return "FacultyMember";
        if (member instanceof StudentMember) return "StudentMember";
        return "LibraryMember";
    }

    public static int getTotalBooksBorrowed(LibraryMember[] members) {
        int total = 0;
        for (LibraryMember m : members) total += m.getBooksBorrowed();
        return total;
    }

    public static void main(String[] args) {
        LibraryMember[] members = new LibraryMember[3];
        members[0] = new StudentMember("S001", 5, "CS");
        members[1] = new FacultyMember("F001", 10, "CS");
        members[2] = new HonorsStudentMember("H001", 8, "Math");
        for (LibraryMember m : members) m.displayInfo();
        System.out.println("Total books: " + getTotalBooksBorrowed(members));
    }
}
