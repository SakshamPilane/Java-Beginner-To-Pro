package advance_22;

public class Student {
    String name;
    int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student(Student otherObj)
    {
        this.name = otherObj.name;
        this.age = otherObj.age;
    }
}
