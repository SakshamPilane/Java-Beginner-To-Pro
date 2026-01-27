package advance_12;

public class Main {
    public static void main(String[] args) {
        Shape s;

        s = new Circle(2);
        System.out.println("Area of Circle = " + s.area());

        s = new Triangle(4, 3);
        System.out.println("Area of Triangle = " + s.area());

        s = new Rectangle(2,3);
        System.out.println("Area of Rectangle = " + s.area());
    }
}
