package util;

import java.util.regex.Pattern;

/**
 * Utility class for validating user input.
 * This class cannot be instantiated.
 */
public final class Validator {

    /**
     * Private constructor prevents object creation.
     */
    private Validator() {
    }

    /**
     * Validates an email address.
     *
     * @param email Email to validate
     * @return true if valid
     */
    public static boolean isValidEmail(String email) {

        if (email == null || email.trim().isEmpty()) {
            return false;
        }

        String emailRegex =
                "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

        return Pattern.matches(emailRegex, email);
    }

    /**
     * Validates a phone number.
     * Must contain exactly 10 digits.
     *
     * @param phone Phone number
     * @return true if valid
     */
    public static boolean isValidPhoneNumber(String phone) {

        if (phone == null) {
            return false;
        }

        return phone.matches("\\d{10}");
    }

    /**
     * Validates password strength.
     * Minimum length: 8 characters.
     *
     * @param password Password to validate
     * @return true if valid
     */
    public static boolean isValidPassword(String password) {

        if (password == null) {
            return false;
        }

        return password.length() >= 8;
    }

    /**
     * Validates transaction amount.
     *
     * @param amount Amount entered by user
     * @return true if amount is valid
     */
    public static boolean isValidAmount(double amount) {
        return amount > 0;
    }

    /**
     * Validates account type.
     * Supported:
     * Savings
     * Current
     *
     * @param accountType Account type
     * @return true if valid
     */
    public static boolean isValidAccountType(String accountType) {

        if (accountType == null) {
            return false;
        }

        return accountType.equalsIgnoreCase("Savings")
                || accountType.equalsIgnoreCase("Current");
    }

}
