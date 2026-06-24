package model;

import java.io.Serial;
import java.io.Serializable;

/**
 * Represents a bank account in the Banking Management System.
 * Each account belongs to a registered user.
 */
public class Account implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private long accountNumber;
    private int userId;
    private String accountType;
    private double balance;
    public Account() {
    }

    /**
     * Parameterized Constructor
     *
     * @param accountNumber Unique account number
     * @param userId Owner's user ID
     * @param accountType Savings / Current
     * @param balance Initial balance
     */
    public Account(long accountNumber, int userId,
                   String accountType, double balance) {

        this.accountNumber = accountNumber;
        this.userId = userId;
        this.accountType = accountType;
        this.balance = balance;
    }

    // ==========================
    // Getters and Setters
    // ==========================

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public double getBalance() {
        return balance;
    }

    /**
     * Used only when loading data from file.
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    // ==========================
    // Banking Operations
    // ==========================

    /**
     * Deposits money into the account.
     *
     * @param amount Amount to deposit
     * @return true if successful
     */
    public boolean deposit(double amount) {

        if (amount <= 0) {
            return false;
        }

        balance += amount;
        return true;
    }

    /**
     * Withdraws money from the account.
     *
     * @param amount Amount to withdraw
     * @return true if successful
     */
    public boolean withdraw(double amount) {

        if (amount <= 0) {
            return false;
        }

        if (amount > balance) {
            return false;
        }
        balance -= amount;
        return true;
    }

    /**
     * Checks whether enough balance is available.
     *
     * @param amount Amount to verify
     * @return true if sufficient balance exists
     */
    public boolean hasSufficientBalance(double amount) {
        return balance >= amount;
    }

    // Utility Methods

    @Override
    public String toString() {

        return "Account{" +
                "accountNumber=" + accountNumber +
                ", userId=" + userId +
                ", accountType='" + accountType + '\'' +
                ", balance=" + balance +
                '}';
    }

}
