package basic_18;

public class Rectangle extends Shape {
    double length = 2;
    double breadth = 2;

    @Override
    public double area() {
        return length * breadth;
    }
}