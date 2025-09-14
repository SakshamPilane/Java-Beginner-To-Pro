public class KeyWordsDemo {
    // class variable (shared across all objects of this class)
    private static final String className = "Saksham";

    public static void main(String[] args) {
        // final variable → cannot be changed after initialization
        final String constantName = "OM";

        // constantName = "New Name"; // ERROR: cannot assign a value to final variable

        // Printing values
        System.out.println("Class Variable: " + className);
        System.out.println("Final Variable: " + constantName);
    }
}