package basic_31;

public class Employee {
    String name;
    String id;
    int age;

    public Employee(String name, String id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    public void display() {
        System.out.println("Name : " + name);
        System.out.println("ID   : " + id);
        System.out.println("Age  : " + age);
    }
}
