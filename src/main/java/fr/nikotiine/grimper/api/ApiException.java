package fr.nikotiine.grimper.api;

public class ApiException extends Exception{
    public ApiException() {
        super();
    }

    public ApiException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
