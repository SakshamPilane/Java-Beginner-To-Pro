package coding_18;

import java.util.Scanner;
class DigitsCounter {
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Number to find digit it contains: ");
        int number = input.nextInt(), copyNumber = Math.abs(number), digitCount = 0;
        if (number == 0)
        {
            digitCount = 1;
        }
        else {
            while (copyNumber > 0) {
                copyNumber /= 10;
                digitCount++;
            }
        }
        String digitWord = (digitCount > 1) ? " digits." : " digit.";
        System.out.print(number + " has " + digitCount + digitWord);
        input.close();
    }
}
