public class CsvStudentRecordParser {

    void parseStudentRecord(String csvLine) {
        String[] fields = csvLine.split(",");
        if (fields.length != 3) {
            System.out.println("Invalid Record");
            return;
        }
        String name = fields[0].trim();
        String rollNumber = fields[1].trim();
        String department = fields[2].trim();
        System.out.println("Name: " + name + " | Roll No: " + rollNumber + " | Dept: " + department);
    }

    public static void main(String[] args) {
        CsvStudentRecordParser parser = new CsvStudentRecordParser();

        System.out.println("Test 1: Valid record");
        parser.parseStudentRecord("Alice,12345,Computer Science");

        System.out.println("\nTest 2: Valid record with spaces");
        parser.parseStudentRecord("Bob , 67890 , Electronics");

        System.out.println("\nTest 3: Invalid record (only 2 fields)");
        parser.parseStudentRecord("Charlie,54321");

        System.out.println("\nTest 4: Invalid record (4 fields)");
        parser.parseStudentRecord("Dave,111,Physics,Extra");
    }
}
