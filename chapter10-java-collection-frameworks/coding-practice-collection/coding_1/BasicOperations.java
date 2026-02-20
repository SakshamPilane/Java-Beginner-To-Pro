package coding_1;

import java.util.*;

public class BasicOperations {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        int element, index;

        try(Scanner input = new Scanner(System.in))
        {
            while (true)
            {
                System.out.println("*************************");
                System.out.println("1. Add Element.");
                System.out.println("2. Remove Element.");
                System.out.println("3. Get Element.");
                System.out.println("4. Get Size of ArrayList.");
                System.out.println("5. Exit.");
                System.out.println("*************************");
                System.out.print("Enter your choice: ");
                int choice = input.nextInt();
                switch (choice)
                {
                    case 1:
                        System.out.print("Enter Element to add: ");
                        element = input.nextInt();
                        list.add(element);
                        break;

                    case 2:
                        System.out.println("ArrayList = " + list);
                        System.out.print("Enter Element to remove: ");
                        element = input.nextInt();
                        if (list.contains(element)) {
                            list.remove(Integer.valueOf(element));
                        }
                        else {
                            System.out.println("Element Not Found! Cannot Remove");
                        }
                        break;

                    case 3:
                        System.out.print("Enter index to get element: ");
                        index = input.nextInt();
                        System.out.println("Element Found on Index " + index + " = " + list.get(index));
                        break;

                    case 4:
                        System.out.println("Size of ArrayList = " + list.size());
                        break;

                    case 5:
                        input.close();
                        return;

                    default:
                        System.out.println("Invalid Input!");
                        break;
                }
            }
        }
        catch (InputMismatchException e)
        {
            System.out.println("Wrong Input! Closing Menu!");
        }
    }
}
