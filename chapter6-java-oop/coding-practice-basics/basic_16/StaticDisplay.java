package basic_16;

public class StaticDisplay {
    static String name = "Saksham";
    static int age = 10;
    public static void display()
    {
        System.out.println("Name = " + name); // Accessing non-static instance variables in not possible in static method
        System.out.println("Age = " + age); // hence instance variable are marked static
    }
}
