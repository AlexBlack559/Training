package pro.alexblack.commandapp.exceptions;

public class NoSuchDirectoryException extends Exception {

    NoSuchDirectoryException() { super(); }
    public NoSuchDirectoryException(String message) {
        super(message);
    }
}
