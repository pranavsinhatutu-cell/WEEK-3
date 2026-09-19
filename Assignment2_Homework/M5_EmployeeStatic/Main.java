class Employee {
    String empName;
    double salary;
    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    Employee(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }
}

public class Main {
    public static void main(String[] args) {
        new Employee("Divya", 65000);
        new Employee("Arjun", 0);
        new Employee("Meera", 72000);
        Employee.printCompanyInfo();
    }
}
