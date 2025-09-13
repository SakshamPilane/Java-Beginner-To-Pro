public class DataTypes {
    public static void main(String[] args)
    {
        byte largerByte = 127;
        byte smallerByte = -128;
        // or
        // byte LargerByteCopy = Byte.MAX_VALUE;
        // byte smallerByteCopy = Byte.MIN_VALUE;

        short largerShort = 32767;
        short smallerShort = -32768;
        // or
        // short largerShortCopy = Short.MAX_VALUE;
        // short smallerShortCopy = Short.MIN_VALUE;

        int largerInt = 2147483647;
        int smallerInt = -2147483648;
        // or
        // int largerIntCopy = Integer.MAX_VALUE;
        // int shorterIntCopy = Integer.MIN_VALUE;

        long largerLong = 9223372000000000000L;
        long smallerLong = -9223372000000000000L;
        // or
        // long largerLongCopy = Long.MAX_VALUE;
        // long shorterLongCopy = Long.MIN_VALUE;

        float floatNumber = 1.1F;
        // or
        float floatNumberLarger = Float.MAX_VALUE;
        float floatNumberSmaller = -Float.MIN_VALUE;

        double doubleNumber = 1.11111;
        // or
        double doubleNumberLarger = Double.MAX_VALUE;
        double doubleNumberSmaller = -Double.MIN_VALUE;

        char character = 'A';

        boolean trueBit = true;
        boolean falseBit = false;

        System.out.println("Byte Range: " + smallerByte + " to " + largerByte);
        System.out.println("Short Range: " + smallerShort + " to " + largerShort);
        System.out.println("Integer Range: " + smallerInt + " to " + largerInt);
        System.out.println("Long Range: " + smallerLong + " to " + largerLong);
        System.out.println("Float Example: " + floatNumber + " | Range: " + floatNumberSmaller + " to " + floatNumberLarger);
        System.out.println("Double Example: " + doubleNumber + " | Range: " + doubleNumberSmaller + " to " + doubleNumberLarger);
        System.out.println("Char Example: " + character);
        System.out.println("Boolean Examples: " + trueBit + ", " + falseBit);
    }
}
