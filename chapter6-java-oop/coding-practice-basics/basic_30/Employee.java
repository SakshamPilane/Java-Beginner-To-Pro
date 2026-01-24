package basic_30;

public class Employee {
    private final int empId;
    private final String department;

    public Employee(int empId, String department) {
        this.empId = empId;
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee [ID=" + empId + ", Dept=" + department + "]";
    }
}
