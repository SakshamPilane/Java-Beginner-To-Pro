package coding_13;

public class CauseException extends Exception {
    public CauseException(String message, Throwable cause) {
        super(message,cause);
    }
}
