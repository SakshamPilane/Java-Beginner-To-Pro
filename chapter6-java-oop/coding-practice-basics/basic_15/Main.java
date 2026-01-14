package basic_15;

public class Main {
    public static void main(String[] args) {
        MathOps obj = new MathOps();
        int a = obj.multiply(2,3);
        double b = obj.multiply(2,3);
        double c = obj.multiply(2,3,4);

        System.out.println("1st Overloaded Method answer = " + a);
        System.out.println("2nd Overloaded Method answer = " + b);
        System.out.println("3rd Overloaded Method answer = " + c);

        System.out.println("1st Overloaded Method answer = " + obj.multiply(2,3));
        System.out.println("Supposed to call 2nd Overloaded Method but calls 1st overloaded method = " + obj.multiply(2,3));
        System.out.println("3rd Overloaded Method answer = " + obj.multiply(2,3,4));
    }
}