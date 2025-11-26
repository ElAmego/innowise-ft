package by.egoramel.ft.exception;

public class ParserException extends Exception {
    public ParserException() {
        super();
    }
    public ParserException(final String message) {
        super(message);
    }
    public ParserException(final String message, final Throwable throwable) {
        super(message, throwable);
    }
}