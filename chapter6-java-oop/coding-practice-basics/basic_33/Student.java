package basic_33;

public class Student extends Teacher {

    public Student(int teacherId, String teacherName) {
        super(teacherId, teacherName);
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Student object is garbage collected: " + teacherName);
    }
}