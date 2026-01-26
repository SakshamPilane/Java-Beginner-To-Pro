package basic_31;

public class Manager extends Employee {

    public Manager(String name, String id, int age) {
        super(name, id, age);
    }

    @Override
    public void display() {
        System.out.println("---- Manager Details ----");
        super.display();
    }
}
