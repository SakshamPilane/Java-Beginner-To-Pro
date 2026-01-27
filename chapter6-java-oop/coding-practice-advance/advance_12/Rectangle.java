package advance_12;

public class Rectangle extends Shape{

    double length, breadth;

    Rectangle(double length, double breadth)
    {
        this.length = length;
        this.breadth = breadth;
    }

    @Override
    public double area() {
        return (length * breadth);
    }
}
