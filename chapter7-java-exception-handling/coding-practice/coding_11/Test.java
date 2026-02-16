package coding_11;

class Test {
    public static double divide(double a, double b) throws ArithmeticException
    {
        if (b == 0)
        {
            throw new ArithmeticException("Division By Zero is Invalid!");
        }
        return a/b; // JVM throws ArithmeticException automatically even if throws statement is not written!
    }

    public static void main(String[] args) {
        double a = 10, b = 0;
        try {
            double result = divide(a,b);
            System.out.println(a + " / " + b + " = " + result);
        }
        catch (ArithmeticException e)
        {
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println("Program Ends!");
        }
    }
}
