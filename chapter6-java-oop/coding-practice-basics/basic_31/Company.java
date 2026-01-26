package basic_31;

import java.util.Scanner;

public class Company {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Employee e;

        while (true) {
            System.out.println("\n1. Employee");
            System.out.println("2. Manager");
            System.out.println("3. Developer");
            System.out.println("4. Exit");
            System.out.print("Choice: ");
            int choice = input.nextInt();
            input.nextLine(); // FIX

            if (choice == 4) break;

            System.out.print("Enter Name: ");
            String name = input.nextLine();

            System.out.print("Enter ID: ");
            String id = input.nextLine();

            System.out.print("Enter Age: ");
            int age = input.nextInt();

            switch (choice) {
                case 1 -> e = new Employee(name, id, age);
                case 2 -> e = new Manager(name, id, age);
                case 3 -> e = new Developer(name, id, age);
                default -> {
                    System.out.println("Invalid choice");
                    continue;
                }
            }

            e.display(); // polymorphism
        }

        input.close();
    }
}
