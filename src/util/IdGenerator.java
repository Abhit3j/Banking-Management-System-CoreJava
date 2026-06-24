package util;

/**
 * Generates unique IDs for users,
 * accounts, and transactions.
 */
public final class IdGenerator {

    private static int userIdCounter = 1;

    private static long accountNumberCounter = 100001;

    private static int transactionIdCounter = 1001;

    /**
     * Private constructor prevents object creation.
     */
    private IdGenerator() {
    }

    /**
     * Generates the next user ID.
     *
     * @return unique user ID
     */
    public static int generateUserId() {
        return userIdCounter++;
    }

    /**
     * Generates the next account number.
     *
     * @return unique account number
     */
    public static long generateAccountNumber() {
        return accountNumberCounter++;
    }

    /**
     * Generates the next transaction ID.
     *
     * @return unique transaction ID
     */
    public static int generateTransactionId() {
        return transactionIdCounter++;
    }
}
