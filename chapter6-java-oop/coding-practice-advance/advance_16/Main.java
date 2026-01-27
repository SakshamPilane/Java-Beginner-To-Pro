package advance_16;

public class Main {
    public static void main(String[] args) {
        Walkable walkObj;
        Runnable runObj;

        walkObj = new Human();
        runObj = new Human();

        walkObj.walk();
        runObj.run();
    }
}
