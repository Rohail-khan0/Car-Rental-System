import java.util.ArrayList;

//EMPLOYEE
abstract class Employee {
    private final String name;
    private final int id;

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public abstract double calculateSalary();

    @Override
    public String toString() {

        return "Employee[name=" + name + ", id=" + id + ", salary=" + calculateSalary() + "]";
    }
}

//FULL-TIME EMPLOYEE
class FullTimeEmployee extends Employee {
    public double monthlysalary;

    public FullTimeEmployee(String name, int id, double monthlysalary) {
        super(name, id);
        this.monthlysalary = monthlysalary;
    }

    @Override
    public double calculateSalary() {
        return monthlysalary;
    }
}

//PART-TIME EMPLOYEE
class PartTimeEmployee extends Employee {
    private final int workingHours;
    private final double rateHours;

    public PartTimeEmployee(String name, int id, int workingHours, double rateHours) {
        super(name, id);
        this.workingHours = workingHours;
        this.rateHours = rateHours;
    }

    @Override
    public double calculateSalary() {
        return workingHours * rateHours;
    }
}

//PAYROLL SYSTEM
class PayrollSystem {
    private final ArrayList<Employee> employeelist;

    public PayrollSystem() {
        employeelist = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employeelist.add(employee);
    }

    public void removeEmployee(int id) {
        Employee employeeToRemove = null;
        for (Employee employee : employeelist) {
            if (employee.getId() == id) {
                employeeToRemove = employee;
                break;
            }
        }
        if (employeeToRemove != null) {
            employeelist.remove(employeeToRemove);
        }

    }

    public void displayEmployees() {
        for (Employee employee : employeelist) {
            System.out.println(employee);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        PayrollSystem payrollSystem = new PayrollSystem();
        FullTimeEmployee emp1 = new FullTimeEmployee("Rohail", 1501, 70000);
        FullTimeEmployee emp2 = new FullTimeEmployee("Ali", 1502, 50000);
        PartTimeEmployee emp3 = new PartTimeEmployee("Hamza", 1503, 40, 600);
        PartTimeEmployee emp4 = new PartTimeEmployee("Umar", 1504, 40, 500);
        payrollSystem.addEmployee(emp1);
        payrollSystem.addEmployee(emp2);
        payrollSystem.addEmployee(emp3);
        payrollSystem.addEmployee(emp4);

        System.out.println("Initail Employee Details:");
        payrollSystem.displayEmployees();
        System.out.println();
        System.out.println("AFTER REMOVING EMPLOYEE");
        payrollSystem.removeEmployee(1502);
        System.out.println("Remaining Employee Details:");
        payrollSystem.displayEmployees();

    }
}