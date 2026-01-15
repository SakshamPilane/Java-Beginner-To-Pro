package basic_18;

public class Triangle extends Shape {
    double base = 3;
    double height = 4;

    @Override
    public double area() {
        return (base * height) / 2;
    }
}