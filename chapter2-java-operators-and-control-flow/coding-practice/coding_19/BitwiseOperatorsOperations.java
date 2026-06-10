package coding_19;
import java.util.Scanner;
public class BitwiseOperatorsOperations {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number1 = sc.nextInt();
        System.out.print("Enter another number: ");
        int number2 = sc.nextInt();
        String bitwiseNumber1 = String.format("%32s", Integer.toBinaryString(number1)).replace(" ", "0");
        String bitwiseNumber2 = String.format("%32s", Integer.toBinaryString(number2)).replace(" ", "0");

        // Bitwise AND => if both 1 then 1 else 0
        // example => 4 (00000000000000000000000000000100) | 5 (00000000000000000000000000000101) => 4 (00000000000000000000000000000100)
        String bitwiseAND = String.format("%32s", Integer.toBinaryString(number1 & number2)).replace(" ", "0");
        System.out.println("Bitwise AND: " + bitwiseNumber1 + " & " + bitwiseNumber2 + " = " + bitwiseAND + " that is => " + (number1 & number2));

        // Bitwise OR => if both 0 then 0 else 1
        // example => 4 (00000000000000000000000000000100) | 5 (00000000000000000000000000000101) => 5 (00000000000000000000000000000101)
        String bitwiseOR = String.format("%32s", Integer.toBinaryString(number1 | number2)).replace(" ", "0");
        System.out.println("Bitwise OR: " + bitwiseNumber1 + " | " + bitwiseNumber2 + " = " + bitwiseOR + " that is => " + (number1 | number2));

        // Bitwise XOR => if both same then 0 else 1
        // example => 4 (00000000000000000000000000000100) ^ 5 (00000000000000000000000000000101) => 1 (00000000000000000000000000000001)
        String bitwiseXOR = String.format("%32s", Integer.toBinaryString(number1 ^ number2)).replace(" ", "0");
        System.out.println("Bitwise XOR: " + bitwiseNumber1 + " ^ " + bitwiseNumber2 + " = " + bitwiseXOR + " that is => " + (number1 ^ number2));

        // Bitwise NOT => if 1 then 0 if 0 then 1
        // example => ~4 => 00000000000000000000000000000100 => 11111111111111111111111111111011 next (00000000000000000000000000000100(4) + 1 => 5) to get value and just add negative sign as left most bit is 1 => -5
        // similarly => ~5 => 00000000000000000000000000000101 => 11111111111111111111111111111010 next (00000000000000000000000000000101(5) + 1 => 6) to get value and just add negative sign as left most bit is 1 => -6
        // answer => -5 + -6 = -11
        String bitwiseNOT = String.format("%32s", Integer.toBinaryString(~number1 + ~number2)).replace(" ", "0");
        System.out.println("Bitwise NOT / Compliment: ~" + bitwiseNumber1 + " + ~" + bitwiseNumber2 + " = " + bitwiseNOT + " that is => " + (~number1 + ~number2));

        // Left Shift => moves bits of that number to left by certain digits and fills shifted spaces by 0
        // example => 4 => (00000000000000000000000000000100 << 5) => 000000000000000000000000100_____ => 00000000000000000000000010000000 => 128
        String leftShiftNumber1ByNumber2 = String.format("%32s", Integer.toBinaryString(number1 << number2)).replace(" ", "0");
        System.out.println("Left shift " + bitwiseNumber1 + " << " + number2 + " = " + leftShiftNumber1ByNumber2 + " that is => " + (number1 << number2));

        // Right Shift => moves bits of that number to right by certain digits and fills shifted spaces by MSB that is sign
        // example => 4 => (00000000000000000000000000000100 >> 5) => _____000000000000000000000000000 => 00000000000000000000000000000000 => 0 (Since MSB = 0 then adds 0 to left)
        // example => -4 => (11111111111111111111111111111100 >> 5) => _____111111111111111111111111111 => 11111111111111111111111111111111 => -1 (Since MSB = 1 then adds 1 to left)
        String rightShiftNumber1ByNumber2 = String.format("%32s", Integer.toBinaryString(number1 >> number2)).replace(" ", "0");
        System.out.println("Right shift " + bitwiseNumber1 + " >> " + number2 + " = " + rightShiftNumber1ByNumber2 + " that is => " + (number1 >> number2));

        // Right Unsigned Shift => moves bits of that number to right by certain digits and fills shifted spaces by 0
        // example => 4 => (00000000000000000000000000000100 >> 5) => _____000000000000000000000000000 => 00000000000000000000000000000000 => 0
        // example => -4 => (11111111111111111111111111111100 >> 5) => _____111111111111111111111111111 => 00000111111111111111111111111111 => 134217727
        String unsignedRightShiftNumber1ByNumber2 = String.format("%32s", Integer.toBinaryString(number1 >>> number2)).replace(" ", "0");
        System.out.println("Unsigned Right shift " + bitwiseNumber1 + " >>> " + number2 + " = " + unsignedRightShiftNumber1ByNumber2 + " that is => " + (number1 >>> number2));

        sc.close();
    }

}