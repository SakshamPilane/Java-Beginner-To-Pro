package basic_33;

public class Main {

    public static void main(String[] args) {

        Teacher t1 = new Teacher(1, "Mr. Sharma");
        Student s1 = new Student(101, "Rahul");

        // Remove references
        t1 = null;
        s1 = null;

        // Request garbage collection
        System.gc();

        System.out.println("End of main method");
    }
}