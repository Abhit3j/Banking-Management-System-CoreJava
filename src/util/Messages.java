package util;

/**
 * Contains all application messages used throughout
 * the Banking Management System.
 *
 * This class cannot be instantiated.
 */
public final class Messages {

    /**
     * Private constructor prevents object creation.
     */
    private Messages() {
    }

    // Registration Messages

    public static final String REGISTRATION_SUCCESS =
            "User registered successfully.";

    public static final String USER_ALREADY_EXISTS =
            "A user with this email already exists.";

    // Login Messages

    public static final String LOGIN_SUCCESS =
            "Login successful.";

    public static final String LOGIN_FAILED =
            "Invalid email or password.";

    public static final String PASSWORD_CHANGED =
            "Password changed successfully.";

    // Account Messages

    public static final String ACCOUNT_CREATED =
            "Bank account created successfully.";

    public static final String ACCOUNT_NOT_FOUND =
            "Account not found.";

    // Transaction Messages

    public static final String MONEY_DEPOSITED =
            "Money deposited successfully.";

    public static final String MONEY_WITHDRAWN =
            "Money withdrawn successfully.";

    public static final String MONEY_TRANSFERRED =
            "Money transferred successfully.";

    // Validation Messages

    public static final String INVALID_AMOUNT =
            "Amount must be greater than zero.";

    public static final String INVALID_EMAIL =
            "Invalid email address.";

    public static final String INVALID_PHONE =
            "Phone number must contain exactly 10 digits.";

    public static final String INVALID_PASSWORD =
            "Password must contain at least 8 characters.";

    // Balance Messages

    public static final String INSUFFICIENT_BALANCE =
            "Insufficient balance.";

    // General Messages

    public static final String DATA_SAVED =
            "Data saved successfully.";

    public static final String DATA_LOADED =
            "Data loaded successfully.";

    public static final String FILE_ERROR =
            "Unable to access data file.";

    public static final String INVALID_CHOICE =
            "Invalid menu choice.";

}
