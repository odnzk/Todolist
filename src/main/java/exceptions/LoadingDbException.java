package exceptions;

public class LoadingDbException extends Exception {
    public LoadingDbException(String message) {
        super(message);
    }

    public LoadingDbException(String message, Throwable cause) {
        super(message, cause);
    }

    public LoadingDbException() {
    }
}
