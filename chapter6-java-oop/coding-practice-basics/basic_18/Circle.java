package basic_18;

public class Circle extends Shape {
    double radius = 2;

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}