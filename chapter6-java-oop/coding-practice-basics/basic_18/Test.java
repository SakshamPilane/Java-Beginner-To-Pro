package basic_18;

public class Test {
    public static void main(String[] args) {
        Shape s;

        s = new Triangle();
        System.out.println("Area of Triangle = " + s.area());

        s = new Rectangle();
        System.out.println("Area of Rectangle = " + s.area());

        s = new Circle();
        System.out.println("Area of Circle = " + s.area());
    }
}