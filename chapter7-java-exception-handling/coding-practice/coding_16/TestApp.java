package coding_16;

public class TestApp {
    public static void main(String[] args) {

        try {
            throw new ValidationException("Age must be >= 18");
        }
        catch (AppException e) {
            System.out.println("Handled AppException Hierarchy;: " + e.getMessage());
        }
    }
}