package basic_26;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {

        Library library = new Library();
        Student student = new Student();
        Scanner input = new Scanner(System.in);

        System.out.print("Enter username: ");
        String username = input.nextLine();

        System.out.print("Enter password: ");
        String password = input.nextLine();

        // LIBRARY LOGIN
        if (username.equals(library.getLibLoginUserName())
                && password.equals(library.getLibLoginPwd())) {

            boolean flag = true;
            while (flag) {
                System.out.println("\n1. Add Book");
                System.out.println("2. Remove Book");
                System.out.println("3. Search Book");
                System.out.println("4. View Books");
                System.out.println("5. Exit");
                System.out.print("Choice: ");

                int choice = input.nextInt();
                input.nextLine();

                switch (choice) {
                    case 1:
                        Book b = new Book();
                        System.out.print("Enter title: ");
                        b.setTitle(input.nextLine());
                        System.out.print("Enter author: ");
                        b.setAuthor(input.nextLine());
                        library.addBook(b);
                        break;

                    case 2:
                        System.out.print("Enter title to remove: ");
                        System.out.println(
                                library.removeBook(input.nextLine())
                                        ? "Book removed."
                                        : "Book not found.");
                        break;

                    case 3:
                        System.out.print("Enter title to search: ");
                        System.out.println(
                                library.searchBook(input.nextLine()) != -1
                                        ? "Book found."
                                        : "Book not found.");
                        break;

                    case 4:
                        library.viewBooks();
                        break;

                    case 5:
                        flag = false;
                        break;
                }
            }
        }

        // STUDENT LOGIN
        else if (username.equals(student.getLibLoginUserName())
                && password.equals(student.getLibLoginPwd())) {

            boolean flag = true;
            while (flag) {
                System.out.println("\n1. Borrow Book");
                System.out.println("2. Return Book");
                System.out.println("3. Exit");
                System.out.print("Choice: ");

                int choice = input.nextInt();
                input.nextLine();

                switch (choice) {
                    case 1:
                        student.borrowBook(library, input);
                        break;

                    case 2:
                        student.returnBook(library);
                        break;

                    case 3:
                        flag = false;
                        break;
                }
            }
        }

        input.close();
    }
}
