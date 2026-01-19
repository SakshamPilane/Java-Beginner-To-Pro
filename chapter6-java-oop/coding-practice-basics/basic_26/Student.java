package basic_26;

import java.util.Scanner;

public class Student {

    private Book borrowedBook;

    public String getLibLoginUserName() {
        return "Student1234";
    }

    public String getLibLoginPwd() {
        return "User1234";
    }

    public void borrowBook(Library library, Scanner input) {
        library.viewBooks();

        System.out.print("Enter book title to borrow: ");
        String title = input.nextLine();

        Book book = library.getBook(title);
        if (book == null) {
            System.out.println("Book not available!");
            return;
        }

        borrowedBook = book;
        library.removeBook(title);
        System.out.println("Book borrowed successfully.");
    }

    public void returnBook(Library library) {
        if (borrowedBook == null) {
            System.out.println("No book to return.");
            return;
        }

        library.addBook(borrowedBook);
        System.out.println("Book returned successfully.");
        borrowedBook = null;
    }
}
