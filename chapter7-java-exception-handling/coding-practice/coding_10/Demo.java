package coding_10;

class Demo {

    static void divide(int a, int b) {
        try {
            int result = a / b;
            System.out.println("Result: " + result);
        }
        catch (ArithmeticException e) {
            System.out.println("Caught in divide(): Division by zero");
            throw e;
        }
    }

    public static void main(String[] args) {
        try {
            int a = 10, b = 0;
            divide(a, b);
        }
        catch (ArithmeticException e) {
            System.out.println("Caught again in main()");
        }
    }
}

