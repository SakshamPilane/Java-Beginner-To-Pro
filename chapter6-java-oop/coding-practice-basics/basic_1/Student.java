package basic_1;

public class Student {
    int age = 18;
    String name = "Jay";
    float marks = 98.8f;

    public static void main(String[] args) {
        Student s = new Student();
        System.out.println("Student \"" + s.name + "\" is " + s.age + " years old and has scored " + s.marks + " marks.");
    }
}
