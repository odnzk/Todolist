package exceptions;

public class ConnectingDbException extends Exception {
    public ConnectingDbException(String message) {
        super(message);
    }

    public ConnectingDbException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConnectingDbException() {
    }
}
