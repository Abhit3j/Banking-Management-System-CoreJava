package model;

import java.io.Serial;
import java.io.Serializable;

/**
 * Represents a registered user of the Banking Management System.
 * Implements Serializable so user data can be saved to a file.
 */
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private int userId;
    private String fullName;
    private String email;
    private String phoneNumber;
    private String password;

    /**
     * Parameterized Constructor
     */
    public User(int userId, String fullName, String email,
                String phoneNumber, String password) {

        this.userId = userId;
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    /**
     * Default Constructor
     */
    public User() {
    }
    // Getters and Setters
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    /**
     * Updates user password.
     */
    public void setPassword(String password) {
        this.password = password;
    }
    // Utility Methods
    @Override
    public String toString() {

        return "User{" +
                "userId=" + userId +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
    /**
     * Used during login.
     */
    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }
}
