package coding_13;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws CauseException {
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Enter your name: ");
            String name = input.nextLine();

            if (name.isEmpty()) {
                throw new EmptyInputException("Name cannot be empty!");
            }
        }
        catch (EmptyInputException e) {
            throw new CauseException("Failed to read input", e);
        }
    }
}
