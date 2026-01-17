package basic_24;

public class Circle extends Shape{
    double radius = 2;

    public void area()
    {
        System.out.println("Area = " + (radius * radius * 3.14));
    }
}
