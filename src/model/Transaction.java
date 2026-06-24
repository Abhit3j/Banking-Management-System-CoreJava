package model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Represents a banking transaction such as Deposit,
 * Withdrawal, or Transfer.
 */
public class Transaction implements Serializable {

    private static final long serialVersionUID = 1L;

    private int transactionId;
    private long accountNumber;
    private String transactionType;
    private double amount;
    private String dateTime;
    private String description;

    /**
     * Parameterized Constructor
     *
     * @param transactionId Unique transaction ID
     * @param accountNumber Account number
     * @param transactionType Deposit / Withdraw / Transfer
     * @param amount Transaction amount
     * @param description Additional details
     */
    public Transaction(int transactionId,
                       long accountNumber,
                       String transactionType,
                       double amount,
                       String description) {

        this.transactionId = transactionId;
        this.accountNumber = accountNumber;
        this.transactionType = transactionType;
        this.amount = amount;
        this.description = description;

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        this.dateTime = LocalDateTime.now().format(formatter);
    }

    // ==========================
    // Getters
    // ==========================

    public int getTransactionId() {
        return transactionId;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public double getAmount() {
        return amount;
    }

    public String getDateTime() {
        return dateTime;
    }

    public String getDescription() {
        return description;
    }

    // Setters

    public void setDescription(String description) {
        this.description = description;
    }

    // Utility Method

    @Override
    public String toString() {

        return "\n-------------------------------------" +
                "\nTransaction ID : " + transactionId +
                "\nAccount Number : " + accountNumber +
                "\nType           : " + transactionType +
                "\nAmount         : ₹" + amount +
                "\nDate & Time    : " + dateTime +
                "\nDescription    : " + description +
                "\n-------------------------------------";
    }

}
