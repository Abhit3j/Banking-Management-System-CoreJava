# Banking Management System (Core Java)

## Overview

The Banking Management System is a console-based application developed using Core Java that simulates basic banking operations. The project follows Object-Oriented Programming (OOP) principles and demonstrates concepts such as Collections Framework, Exception Handling, File Handling, Serialization, Validation, and Layered Architecture.

This project was built to strengthen Core Java fundamentals and showcase practical software development skills through a real-world banking application.

---

## Features

### User Management

* User Registration
* User Login Authentication
* Password Change Functionality

### Account Management

* Create Bank Account
* Support for Savings and Current Accounts
* Automatic Account Number Generation

### Banking Operations

* Deposit Money
* Withdraw Money
* Transfer Funds Between Accounts
* Check Account Balance

### Transaction Management

* Transaction History Tracking
* Unique Transaction ID Generation
* Date and Time Recording for Transactions

### Data Persistence

* Save User Data Using Serialization
* Save Account Data Using Serialization
* Save Transaction Data Using Serialization
* Load Existing Data on Application Startup

### Validation and Security

* Email Validation
* Phone Number Validation
* Password Validation
* Amount Validation
* Custom Exception Handling

---

## Technologies Used

* Java
* Object-Oriented Programming (OOP)
* Java Collections Framework
* File Handling
* Serialization
* Exception Handling
* Generics
* Java Time API
* Git
* GitHub

---

## Project Structure

```text
src
│
├── model
│   ├── User.java
│   ├── Account.java
│   └── Transaction.java
│
├── exception
│   ├── InvalidAmountException.java
│   ├── InsufficientBalanceException.java
│   └── AccountNotFoundException.java
│
├── util
│   ├── Messages.java
│   ├── Validator.java
│   ├── IdGenerator.java
│   ├── FileManager.java
│   └── FileConstants.java
│
├── service
│   ├── AuthenticationService.java
│   └── BankService.java
│
└── main
    └── Main.java
```

---

## Core Concepts Demonstrated

### Object-Oriented Programming

* Classes and Objects
* Encapsulation
* Constructors
* Method Overriding
* Abstraction through Layered Design

### Collections Framework

* List
* ArrayList

### Exception Handling

* Try-Catch Blocks
* Custom Exceptions
* Checked Exceptions

### File Handling

* ObjectInputStream
* ObjectOutputStream
* Serialization
* Persistent Data Storage

### Utility Design

* Static Helper Methods
* Validation Utilities
* Centralized Application Messages

---

## Sample Workflow

```text
Register User
      ↓
Login
      ↓
Create Account
      ↓
Deposit Money
      ↓
Withdraw Money
      ↓
Transfer Money
      ↓
Check Balance
      ↓
View Transaction History
```

---

## How to Run

1. Clone the repository

```bash
git clone https://github.com/your-username/Banking-Management-System.git
```

2. Open the project in IntelliJ IDEA, Eclipse, or VS Code.

3. Compile the project.

4. Run:

```text
src/main/Main.java
```

5. Use the console menu to perform banking operations.

---

## Example Menu

```text
===== Banking Management System =====

1. Register
2. Login
3. Exit
```

After Login:

```text
===== User Menu =====

1. Create Account
2. Deposit
3. Withdraw
4. Transfer
5. Check Balance
6. Transaction History
7. Change Password
8. Logout
```

---

## Future Enhancements

* JDBC Integration
* MySQL Database Support
* Spring Boot REST APIs
* Password Encryption
* Admin Dashboard
* Transaction Search and Filtering
* Interest Calculation Module
* Unit Testing with JUnit

---

## Resume Description

Developed a console-based Banking Management System using Core Java following Object-Oriented Programming principles. Implemented user authentication, account management, deposits, withdrawals, fund transfers, balance inquiry, and transaction history. Utilized Java Collections Framework, Serialization, File Handling, Custom Exception Handling, and Layered Architecture to ensure maintainability and persistent data storage.

---

## Author

**Abhitej B**

BCA (Artificial Intelligence) Student

Passionate about Java Development, Data Structures & Algorithms, Backend Development, and Software Engineering.
