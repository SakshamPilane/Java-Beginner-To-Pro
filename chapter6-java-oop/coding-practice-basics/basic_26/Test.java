package basic_26;

public class Test {
    public static void main(String[] args) {

        Library library = new Library();

        library.addBook(new Book("Java", "James Gosling"));
        library.addBook(new Book("Python", "Guido van Rossum"));

        Student s1 = new Student("Saksham");

        s1.borrowBook(library, "Java");
        s1.returnBook(library);
    }
}
