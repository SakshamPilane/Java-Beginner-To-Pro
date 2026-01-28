package advance_21;

public class Magazine extends Item{

    private final String magName;
    private final String magAuthor;

    public Magazine(String magName, String magAuthor) {
        this.magName = magName;
        this.magAuthor = magAuthor;
    }

    @Override
    public void displayDetails() {
        System.out.println("Magazine Details");
        System.out.println("Magazine Name = " + magName);
        System.out.println("Author Name = " + magAuthor);
        System.out.println();
    }
}
