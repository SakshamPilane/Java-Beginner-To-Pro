package basic_33;

public class Teacher {

    int teacherId;
    String teacherName;

    public Teacher(int teacherId, String teacherName) {
        this.teacherId = teacherId;
        this.teacherName = teacherName;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Teacher object is garbage collected: " + teacherName);
    }
}