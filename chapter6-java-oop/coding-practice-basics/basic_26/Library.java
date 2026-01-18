package basic_26;

public class Library {

    private final Book[] books = new Book[10];
    private int count = 0;

    public void addBook(Book book) {
        books[count++] = book;
        System.out.println("Book added: " + book.getTitle());
    }

    public Book searchBook(String title) {
        for (int i = 0; i < count; i++) {
            if (books[i].getTitle().equalsIgnoreCase(title)) {
                return books[i];
            }
        }
        return null;
    }

    public void removeBook(String title) {
        for (int i = 0; i < count; i++) {
            if (books[i].getTitle().equalsIgnoreCase(title)) {
                books[i] = books[count - 1];
                books[count - 1] = null;
                count--;
                System.out.println("Book removed: " + title);
                return;
            }
        }
        System.out.println("Book not found");
    }
}
