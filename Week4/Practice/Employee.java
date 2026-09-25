// Employee.java
public class Employee {
    String empId;
    String empName;
    double salary;

    public Employee(String empId, String empName, double salary) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
    }

    public void raiseSalary(double salary) {
        this.salary += salary;
    }

    public static void applyBonus(Employee[] emps, double bonus) {
        for (Employee emp : emps) {
            emp.raiseSalary(bonus);
        }
    }

    public static void main(String[] args) {
        Employee[] emps = new Employee[4];
        emps[0] = new Employee("E-101", "Alice", 40000);
        emps[1] = new Employee("E-102", "Bob", 55000);
        emps[2] = new Employee("E-103", "Charlie", 62000);
        emps[3] = new Employee("E-104", "Divya", 48000);
        applyBonus(emps, 5000);
        for (Employee emp : emps) {
            System.out.println(emp.empId + " | Final Salary: Rs " + emp.salary);
        }
    }
}
