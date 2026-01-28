package advance_22;

public class Test {
    public static void main(String[] args) {
        Student s1 = new Student("Saksham", 10);
        Student s2 = new Student(s1);

        System.out.println(s1.name + " and " + s1.age);
        System.out.println(s2.name + " and " + s2.age);
    }
}
