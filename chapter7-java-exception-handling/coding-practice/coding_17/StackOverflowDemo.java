package coding_17;

public class StackOverflowDemo {

    static void recursiveCall() {
        recursiveCall();  // no base condition
    }

    public static void main(String[] args) {
        try {
            recursiveCall();
        }
        catch (StackOverflowError e) {
            System.out.println("StackOverflowError caught!");
        }
    }
}