package by.egoramel.ft.exception;

public class ParserException extends RuntimeException {
    public ParserException(final String message) {
        super(message);
    }
    public ParserException(final Exception exception) {
        super(exception);
    }
}