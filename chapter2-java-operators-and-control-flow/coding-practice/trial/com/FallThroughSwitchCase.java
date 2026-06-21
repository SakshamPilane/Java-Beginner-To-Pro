package trial.com;

import java.util.Scanner;

public class FallThroughSwitchCase {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter your choice: ");
        int choice = input.nextInt();

        switch (choice){
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                System.out.println("Weekday");
                break;
            case 6:
            case 7:
                System.out.println("Weekend");
                break;

            default:
                System.out.println("Wrong Choice Bratha!!!");
                break;
        }

        input.close();

    }
}
