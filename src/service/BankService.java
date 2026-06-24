package service;

import exception.AccountNotFoundException;
import exception.InvalidAmountException;
import exception.InsufficientBalanceException;

import model.Account;
import model.Transaction;
import model.User;

import util.FileConstants;
import util.FileManager;
import util.IdGenerator;
import util.Messages;
import util.Validator;

import java.util.ArrayList;
import java.util.List;

public class BankService {

    private List<Account> accounts;
    private List<Transaction> transactions;

    public BankService() {

        accounts = FileManager.loadData(
                FileConstants.ACCOUNTS_FILE);

        transactions = FileManager.loadData(
                FileConstants.TRANSACTIONS_FILE);

        if (accounts == null) {
            accounts = new ArrayList<>();
        }

        if (transactions == null) {
            transactions = new ArrayList<>();
        }
    }

    /**
     * Create bank account for a user
     */
    public Account createAccount(User user,
                                 String accountType,
                                 double initialBalance)
            throws InvalidAmountException {

        if (!Validator.isValidAccountType(accountType)) {
            throw new IllegalArgumentException(
                    "Account type must be Savings or Current");
        }

        if (!Validator.isValidAmount(initialBalance)) {
            throw new InvalidAmountException(
                    Messages.INVALID_AMOUNT);
        }

        Account account = new Account(
                IdGenerator.generateAccountNumber(),
                user.getUserId(),
                accountType,
                initialBalance
        );

        accounts.add(account);

        FileManager.saveData(
                FileConstants.ACCOUNTS_FILE,
                accounts
        );

        return account;
    }

    /**
     * Deposit money
     */
    public void deposit(long accountNumber,
                        double amount)
            throws AccountNotFoundException,
            InvalidAmountException {

        if (!Validator.isValidAmount(amount)) {
            throw new InvalidAmountException(
                    Messages.INVALID_AMOUNT);
        }

        Account account = findAccount(accountNumber);

        account.deposit(amount);

        Transaction transaction =
                new Transaction(
                        IdGenerator.generateTransactionId(),
                        accountNumber,
                        "Deposit",
                        amount,
                        "Cash Deposit"
                );

        transactions.add(transaction);

        saveAll();
    }

    /**
     * Withdraw money
     */
    public void withdraw(long accountNumber,
                         double amount)
            throws AccountNotFoundException,
            InvalidAmountException,
            InsufficientBalanceException {

        if (!Validator.isValidAmount(amount)) {
            throw new InvalidAmountException(
                    Messages.INVALID_AMOUNT);
        }

        Account account = findAccount(accountNumber);

        if (!account.hasSufficientBalance(amount)) {
            throw new InsufficientBalanceException(
                    Messages.INSUFFICIENT_BALANCE);
        }

        account.withdraw(amount);

        Transaction transaction =
                new Transaction(
                        IdGenerator.generateTransactionId(),
                        accountNumber,
                        "Withdraw",
                        amount,
                        "Cash Withdrawal"
                );

        transactions.add(transaction);

        saveAll();
    }

    /**
     * Transfer money
     */
    public void transfer(long fromAccount,
                         long toAccount,
                         double amount)
            throws AccountNotFoundException,
            InvalidAmountException,
            InsufficientBalanceException {

        if (!Validator.isValidAmount(amount)) {
            throw new InvalidAmountException(
                    Messages.INVALID_AMOUNT);
        }

        Account sender =
                findAccount(fromAccount);

        Account receiver =
                findAccount(toAccount);

        if (!sender.hasSufficientBalance(amount)) {
            throw new InsufficientBalanceException(
                    Messages.INSUFFICIENT_BALANCE);
        }

        sender.withdraw(amount);
        receiver.deposit(amount);

        Transaction transaction =
                new Transaction(
                        IdGenerator.generateTransactionId(),
                        fromAccount,
                        "Transfer",
                        amount,
                        "Transfer to Account "
                                + toAccount
                );

        transactions.add(transaction);

        saveAll();
    }

    /**
     * Get balance
     */
    public double getBalance(long accountNumber)
            throws AccountNotFoundException {

        Account account =
                findAccount(accountNumber);

        return account.getBalance();
    }

    /**
     * Transaction history
     */
    public List<Transaction> getTransactionHistory(
            long accountNumber) {

        List<Transaction> history =
                new ArrayList<>();

        for (Transaction transaction :
                transactions) {

            if (transaction.getAccountNumber()
                    == accountNumber) {

                history.add(transaction);
            }
        }

        return history;
    }

    /**
     * Find account by account number
     */
    private Account findAccount(
            long accountNumber)
            throws AccountNotFoundException {

        for (Account account : accounts) {

            if (account.getAccountNumber()
                    == accountNumber) {

                return account;
            }
        }

        throw new AccountNotFoundException(
                Messages.ACCOUNT_NOT_FOUND);
    }

    /**
     * Save all data
     */
    private void saveAll() {

        FileManager.saveData(
                FileConstants.ACCOUNTS_FILE,
                accounts);

        FileManager.saveData(
                FileConstants.TRANSACTIONS_FILE,
                transactions);
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}
