package basic_14;

public class Point {
    String name;
    int age;
    public Point(String name, int age)
    {
        System.out.println("Local Variable \"name\" = " + name);
        System.out.println("Global Variable \"name\" = " + this.name);
        this.name = name;
        System.out.println("New Global Variable \"name\" = " + this.name);

        System.out.println("Local Variable \"age\" = " + age);
        System.out.println("Global Variable \"age\" = " + this.age);
        this.age = age;
        System.out.println("New Global Variable \"age\" = " + this.age);
    }

    public static void main(String[] args) {
        Point obj = new Point("Saksham", 99);
    }
}
