package exception;

/**
 * Custom exception thrown when an account
 * does not have enough balance to complete
 * a withdrawal or transfer.
 */
public class InsufficientBalanceException extends Exception {

    /**
     * Creates a new InsufficientBalanceException
     * with the specified error message.
     *
     * @param message Exception message
     */
    public InsufficientBalanceException(String message) {
        super(message);
    }
}
