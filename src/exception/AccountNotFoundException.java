package exception;

/**
 * Custom exception thrown when the specified
 * bank account cannot be found.
 */
public class AccountNotFoundException extends Exception {

    /**
     * Creates a new AccountNotFoundException
     * with the specified error message.
     *
     * @param message Exception message
     */
    public AccountNotFoundException(String message) {
        super(message);
    }
}
