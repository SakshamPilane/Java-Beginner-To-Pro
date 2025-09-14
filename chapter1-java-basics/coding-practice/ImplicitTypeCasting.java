public class ImplicitTypeCasting {
    public static void main(String[] args) {
        // Widening Type Casting (a.k.a Implicit Casting)
        // Smaller type is automatically promoted to a larger type

        byte byteNumber = 10;

        short shortNumber;
        shortNumber = byteNumber; // byte -> short

        int intNumber;
        intNumber = byteNumber;   // byte -> int

        long longNumber;
        longNumber = byteNumber;  // byte -> long

        float floatNumber;
        floatNumber = byteNumber; // byte -> float

        double doubleNumber;
        doubleNumber = byteNumber; // byte -> double

        // Print results
        System.out.print("Byte(" + byteNumber + ") -> ");
        System.out.print("Short(" + shortNumber + ") -> ");
        System.out.print("Integer(" + intNumber + ") -> ");
        System.out.print("Long(" + longNumber + ") -> ");
        System.out.print("Float(" + floatNumber + ") -> ");
        System.out.print("Double(" + doubleNumber + ")\n\n");
    }
}
