package basic_3;

public class Rectangle {
    float length, width;

    public float area()
    {
        return length * width;
    }

    public static void main(String[] args) {
        Rectangle r = new Rectangle();
        r.length = 20.5f;
        r.width = 1.5f;
        System.out.println("Area of Rectangle with Length " + r.length + " and Width " + r.width + " is " + r.area());
    }
}
