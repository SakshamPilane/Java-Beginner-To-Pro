package basic_30;

public class Test {
    public static void main(String[] args) {

        Student s = new Student(1, "Saksham");
        Product p = new Product("Laptop", 65000);
        Employee e = new Employee(101, "IT");

        System.out.println(s);
        System.out.println(p);
        System.out.println(e);
    }
}
