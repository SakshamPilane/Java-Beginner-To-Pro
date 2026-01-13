package basic_5;

public class Employee {
    int id, salary;
    String name;

    public void displayEmpInfo()
    {
        System.out.println("Employee ID = " + id);
        System.out.println("Employee Name = " + name);
        System.out.println("Employee Salary = " + salary);
    }

    public static void main(String[] args) {
        Employee e = new Employee();
        e.id = 1;
        e.name = "Newton";
        e.salary = 100000;
        e.displayEmpInfo();
    }
}
