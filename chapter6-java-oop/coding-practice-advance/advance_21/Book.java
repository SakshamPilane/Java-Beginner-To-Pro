package advance_21;

public class Book extends Item{
    private final String bookName;
    private final String authorName;

    public Book(String bookName, String authorName) {
        this.bookName = bookName;
        this.authorName = authorName;
    }

    @Override
    public void displayDetails() {
        System.out.println("Book Details");
        System.out.println("Book Name = " + bookName);
        System.out.println("Author Name = " + authorName);
        System.out.println();
    }
}