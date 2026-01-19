package basic_26;

public class Library {

    private final Book[] books = new Book[10];
    private int count = 0;

    public String getLibLoginUserName() {
        return "Library1234";
    }

    public String getLibLoginPwd() {
        return "Library1234";
    }

    public void addBook(Book book) {
        if (count >= books.length) {
            System.out.println("Library is full!");
            return;
        }
        books[count++] = book;
        System.out.println("Book added successfully: " +
                book.getTitle() + " by " + book.getAuthor());
    }

    public int searchBook(String title) {
        for (int i = 0; i < count; i++) {
            if (books[i].getTitle().equalsIgnoreCase(title)) {
                return i;
            }
        }
        return -1;
    }

    public Book getBook(String title) {
        int pos = searchBook(title);
        if (pos == -1) return null;
        return books[pos];
    }

    public boolean removeBook(String title) {
        int pos = searchBook(title);
        if (pos == -1) return false;

        for (int i = pos; i < count - 1; i++) {
            books[i] = books[i + 1];
        }
        books[count - 1] = null;
        count--;
        return true;
    }

    public void viewBooks() {
        if (count == 0) {
            System.out.println("No books available.");
            return;
        }
        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + ". " +
                    books[i].getTitle() + " - " + books[i].getAuthor());
        }
    }
}