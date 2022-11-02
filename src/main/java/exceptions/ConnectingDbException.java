package exceptions;

public class ConnectingDbException extends Exception {
    public ConnectingDbException(String message) {
        super(message);
    }
}
