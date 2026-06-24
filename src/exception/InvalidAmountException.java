package exception;

/**
 * Custom exception thrown when an invalid amount
 * is entered for a banking transaction.
 */
public class InvalidAmountException extends Exception {

    /**
     * Constructor
     *
     * @param message Exception message
     */
    public InvalidAmountException(String message) {
        super(message);
    }
}
