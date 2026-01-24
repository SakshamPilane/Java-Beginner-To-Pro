package basic_30;

public class Student {
    private final int id;
    private final String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student [ID=" + id + ", Name=" + name + "]";
    }
}
