package advance_21;

public class Test {
    public static void main(String[] args) {
        Item itemObj;

        System.out.println("Book Class");
        itemObj = new Book("Let us C", "Yashwant Kanetkar");
        itemObj.displayDetails();

        System.out.println("Magazine Class");
        itemObj = new Magazine("India Today", "Vidya Vilas Purie");
        itemObj.displayDetails();

        System.out.println("DVD Class");
        itemObj = new DVD("Finding Nemo", "Blue-Ray");
        itemObj.displayDetails();
    }
}
