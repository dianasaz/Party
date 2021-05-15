package by.iba.party.exception;

public class NoEntityException extends Exception{
    public NoEntityException(String message) {
        super(message);
    }

    public NoEntityException(String message, Throwable cause) {
        super(message, cause);
    }
}
