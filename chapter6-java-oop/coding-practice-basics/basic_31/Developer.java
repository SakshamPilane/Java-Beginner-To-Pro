package basic_31;

public class Developer extends Employee {

    public Developer(String name, String id, int age) {
        super(name, id, age);
    }

    @Override
    public void display() {
        System.out.println("---- Developer Details ----");
        super.display();
    }
}
