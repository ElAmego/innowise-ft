package by.egoramel.ft.exception;

public final class CustomIntArrayException extends Exception {
    public CustomIntArrayException() {
        super();
    }
    public CustomIntArrayException(final String message) {
        super(message);
    }
    public CustomIntArrayException(final String message, final Throwable throwable) {
        super(message, throwable);
    }
    public CustomIntArrayException(final Throwable throwable) {
        super( throwable);
    }
}