package basic_29;

public class Test {
    public static void main(String[] args) {

        Logger logger;

        logger = new ConsoleLogger();
        logger.log("User logged in");

        logger = new FileLogger();
        logger.log("User logged in");
    }
}
