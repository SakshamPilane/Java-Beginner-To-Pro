package basic_9;

public class Book {
    String bookName, author;
    public Book(String a, String b)
    {
        bookName = a;
        author = b;
    }
    public void display()
    {
        System.out.println("Book Details...");
        System.out.println("Book Name = " + bookName);
        System.out.println("Author Name = " + author);
    }

    public static void main(String[] args) {
        Book obj = new Book("A Tale of Two Cities", "Charles Dickens");
        obj.display();
    }
}
