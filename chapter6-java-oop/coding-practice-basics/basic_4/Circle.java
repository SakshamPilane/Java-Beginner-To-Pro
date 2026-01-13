package basic_4;

public class Circle {
    float radius;
    float pi = 3.14f;

    public float area()
    {
        return pi * radius * radius;
    }

    public float circumference()
    {
        return 2 * pi * radius;
    }

    public static void main(String[] args) {
        Circle c = new Circle();
        c.radius = 2.5f;
        System.out.println("Area of Circle with Radius " + c.radius + " is " + c.area());
        System.out.println("Circumference of Circle with Radius " + c.radius + " is " + c.circumference());
    }
}
