package main;

import exception.AccountNotFoundException;
import exception.InvalidAmountException;
import exception.InsufficientBalanceException;

import model.Account;
import model.Transaction;
import model.User;

import service.AuthenticationService;
import service.BankService;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        AuthenticationService authService =
                new AuthenticationService();

        BankService bankService =
                new BankService();

        User loggedInUser = null;

        while (true) {

            System.out.println("\n===== Banking Management System =====");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");

            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Full Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Email: ");
                    String email = scanner.nextLine();

                    System.out.print("Phone Number: ");
                    String phone = scanner.nextLine();

                    System.out.print("Password: ");
                    String password = scanner.nextLine();

                    authService.registerUser(
                            name,
                            email,
                            phone,
                            password
                    );

                    break;

                case 2:

                    System.out.print("Email: ");
                    email = scanner.nextLine();

                    System.out.print("Password: ");
                    password = scanner.nextLine();

                    loggedInUser =
                            authService.login(
                                    email,
                                    password
                            );

                    if (loggedInUser != null) {

                        userMenu(
                                scanner,
                                loggedInUser,
                                authService,
                                bankService
                        );
                    }

                    break;

                case 3:

                    System.out.println(
                            "Thank you for using the system."
                    );

                    scanner.close();

                    System.exit(0);

                default:

                    System.out.println(
                            "Invalid Choice."
                    );
            }
        }
    }

    private static void userMenu(
            Scanner scanner,
            User user,
            AuthenticationService authService,
            BankService bankService) {

        while (true) {

            System.out.println("\n===== User Menu =====");

            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. Check Balance");
            System.out.println("6. Transaction History");
            System.out.println("7. Change Password");
            System.out.println("8. Logout");

            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            try {

                switch (choice) {

                    case 1:

                        System.out.print(
                                "Account Type (Savings/Current): ");

                        String accountType =
                                scanner.nextLine();

                        System.out.print(
                                "Initial Balance: ");

                        double balance =
                                scanner.nextDouble();

                        scanner.nextLine();

                        Account account =
                                bankService.createAccount(
                                        user,
                                        accountType,
                                        balance
                                );

                        System.out.println(
                                "Account Created Successfully");

                        System.out.println(account);

                        break;

                    case 2:

                        System.out.print(
                                "Account Number: ");

                        long depositAccount =
                                scanner.nextLong();

                        System.out.print(
                                "Amount: ");

                        double depositAmount =
                                scanner.nextDouble();

                        scanner.nextLine();

                        bankService.deposit(
                                depositAccount,
                                depositAmount
                        );

                        System.out.println(
                                "Deposit Successful");

                        break;

                    case 3:

                        System.out.print(
                                "Account Number: ");

                        long withdrawAccount =
                                scanner.nextLong();

                        System.out.print(
                                "Amount: ");

                        double withdrawAmount =
                                scanner.nextDouble();

                        scanner.nextLine();

                        bankService.withdraw(
                                withdrawAccount,
                                withdrawAmount
                        );

                        System.out.println(
                                "Withdrawal Successful");

                        break;

                    case 4:

                        System.out.print(
                                "From Account: ");

                        long fromAccount =
                                scanner.nextLong();

                        System.out.print(
                                "To Account: ");

                        long toAccount =
                                scanner.nextLong();

                        System.out.print(
                                "Amount: ");

                        double transferAmount =
                                scanner.nextDouble();

                        scanner.nextLine();

                        bankService.transfer(
                                fromAccount,
                                toAccount,
                                transferAmount
                        );

                        System.out.println(
                                "Transfer Successful");

                        break;

                    case 5:

                        System.out.print(
                                "Account Number: ");

                        long accountNumber =
                                scanner.nextLong();

                        scanner.nextLine();

                        double currentBalance =
                                bankService.getBalance(
                                        accountNumber
                                );

                        System.out.println(
                                "Current Balance: ₹"
                                        + currentBalance
                        );

                        break;

                    case 6:

                        System.out.print(
                                "Account Number: ");

                        accountNumber =
                                scanner.nextLong();

                        scanner.nextLine();

                        List<Transaction> history =
                                bankService
                                        .getTransactionHistory(
                                                accountNumber
                                        );

                        if (history.isEmpty()) {

                            System.out.println(
                                    "No transactions found."
                            );

                        } else {

                            for (Transaction transaction :
                                    history) {

                                System.out.println(
                                        transaction
                                );
                            }
                        }

                        break;

                    case 7:

                        System.out.print(
                                "New Password: ");

                        String newPassword =
                                scanner.nextLine();

                        authService.changePassword(
                                user,
                                newPassword
                        );

                        break;

                    case 8:

                        return;

                    default:

                        System.out.println(
                                "Invalid Choice");
                }

            } catch (InvalidAmountException |
                     AccountNotFoundException |
                     InsufficientBalanceException e) {

                System.out.println(
                        e.getMessage()
                );

            } catch (Exception e) {

                System.out.println(
                        "Unexpected Error: "
                                + e.getMessage()
                );
            }
        }
    }
}
