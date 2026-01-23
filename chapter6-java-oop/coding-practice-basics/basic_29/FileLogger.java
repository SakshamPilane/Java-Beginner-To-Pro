package basic_29;

public class FileLogger implements Logger {
    @Override
    public void log(String message) {
        System.out.println("File Log: " + message);
    }
}
