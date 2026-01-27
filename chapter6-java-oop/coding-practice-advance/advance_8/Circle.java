package advance_8;

public class Circle extends Shape{

    float radius;

    Circle(float radius)
    {
        this.radius = radius;
    }

    public void area()
    {
        System.out.println("Area of Circle = " + (3.14 * radius * radius));
    }
}
