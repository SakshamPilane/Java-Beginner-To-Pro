public class ExplicitTypeCasting {
    public static void main(String[] args)
    {
        // Narrowing Type Casting (a.k.a Explicit Type Casting)
        // Larger Type is Explicitly narrowed down to a smaller type

        double doubleNumber = 12345.6789;

        float floatNumber;
        floatNumber = (float) doubleNumber;

        long longNumber;
        longNumber = (long) doubleNumber;

        int intNumber;
        intNumber = (int) doubleNumber;

        short shortNumber;
        shortNumber = (short) doubleNumber;

        byte byteNumber;
        byteNumber = (byte) doubleNumber;

        // Print results
        System.out.print("Byte(" + byteNumber + ") ");
        System.out.print("<- Short(" + shortNumber + ") ");
        System.out.print("<- Integer(" + intNumber + ") ");
        System.out.print("<- Long(" + longNumber + ") ");
        System.out.print("<- Float(" + floatNumber + ") ");
        System.out.print("<- Double(" + doubleNumber + ")\n\n");
    }
}
