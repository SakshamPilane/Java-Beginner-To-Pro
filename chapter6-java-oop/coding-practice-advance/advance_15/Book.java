package advance_15;

public class Book implements Printable {

    String bookName;
    String authorName;

    Book(String bookName, String authorName) {
        this.bookName = bookName;
        this.authorName = authorName;
    }

    @Override
    public void printDetails() {
        System.out.println("Book Name = " + bookName);
        System.out.println("Author Name = " + authorName);
    }
}
