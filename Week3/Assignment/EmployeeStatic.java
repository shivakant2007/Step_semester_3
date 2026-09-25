// EmployeeStatic.java
public class EmployeeStatic {
    String empName;
    double salary;
    static String companyName = "STEP Corp";
    static int employeeCount = 0;

    public EmployeeStatic(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    public static void printCompanyInfo() {
        System.out.println("Company: " + companyName + ", Employees: " + employeeCount);
    }

    public static void main(String[] args) {
        EmployeeStatic e1 = new EmployeeStatic("Alice", 50000);
        EmployeeStatic e2 = new EmployeeStatic("Bob", 60000);
        EmployeeStatic e3 = new EmployeeStatic("Charlie", 70000);
        EmployeeStatic.printCompanyInfo();
    }
}
