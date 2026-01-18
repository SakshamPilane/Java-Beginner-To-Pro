package basic_26;

public class Student {

    private final String name;
    private Book borrowedBook;

    public Student(String name) {
        this.name = name;
    }

    public void borrowBook(Library library, String title) {
        Book book = library.searchBook(title);
        if (book != null) {
            borrowedBook = book;
            library.removeBook(title);
            System.out.println(name + " borrowed " + title);
        } else {
            System.out.println("Book not available");
        }
    }

    public void returnBook(Library library) {
        if (borrowedBook != null) {
            library.addBook(borrowedBook);
            System.out.println(name + " returned " + borrowedBook.getTitle());
            borrowedBook = null;
        } else {
            System.out.println("No book to return");
        }
    }
}
