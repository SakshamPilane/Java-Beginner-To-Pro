package basic_27;

public class Test {
    public static void main(String[] args) {

        // Method display(String, int) overloaded by display(String, double)
        Parent p = new Parent();
        p.display("Maya", 33.3);
        System.out.println();

        // Runtime polymorphism + method overriding
        p = new Child();
        p.display("Nayan", 12); // display(String, int)
        p.display("Rita", 13.3); // display(String, double)
    }
}
