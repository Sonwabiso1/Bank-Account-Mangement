# Bank Account Management System

## Project Overview
This is a simple console-based Java application simulating a basic **Bank Account Management System**. The application demonstrates essential object-oriented programming (OOP) concepts, including **classes and objects**, **inheritance and polymorphism**, and **exception handling**.

In this system, you can create and manage different types of bank accounts (Savings and Checking), perform basic banking operations (deposit, withdraw, view balance), transfer funds between accounts, and, if logged in as an admin, view and delete accounts.

## Features
- **Create Accounts**: Create new Savings or Checking accounts with unique account numbers.
- **Deposit and Withdraw**: Perform deposit and withdrawal operations on accounts.
- **Display Account Information**: View account balance for any account.
- **Transfer Funds**: Transfer money from one account to another.
- **Admin Actions**:
  - View all accounts with account holder details.
  - Delete specific accounts from the bank.

## Project Structure

- **Bank**: Manages the list of accounts and provides banking operations like deposit, withdraw, display, and transfer.
- **Person**: Represents an individual (account holder) with a name and ID.
- **Admin**: Extends `Person` and allows additional privileges to view and delete accounts.
- **BankAccount (Abstract Class)**: Represents a general bank account with basic operations. Subclasses include:
  - **SavingsAccount**: Inherits from `BankAccount` and represents a savings account.
  - **CheckingAccount**: Inherits from `BankAccount` and represents a checking account.

## Getting Started

### Prerequisites
- **Java Development Kit (JDK)**: Ensure JDK is installed on your system (Java 8 or later).
- **IDE**: Use any Java-compatible IDE like IntelliJ IDEA, Eclipse, or NetBeans.

### How to Run
1. Clone or download this repository.
2. Open the project in your Java IDE.
3. Run the `Bank` class, which contains the `main` method to start the application.
4. You will be prompted with menu options for different operations. Follow the prompts in the console to interact with the system.

### Usage Guide
1. **Run as Admin**:
   - The application starts with an Admin user, allowing access to all menu options (1-8).
2. **Menu Options**:
   - **Add Account**: Enter account holder details, account type (Savings/Checking), and account number to create a new account.
   - **Deposit**: Input account number and deposit amount to add funds.
   - **Withdraw**: Input account number and withdrawal amount to remove funds (with sufficient balance).
   - **Display Account Info**: Enter an account number to see balance details.
   - **Transfer Funds**: Provide source and destination account numbers and the transfer amount.
   - **Display All Accounts** (Admin only): View all accounts with account holders' names and balances.
   - **Delete Account** (Admin only): Enter an account number to delete that account.

## Example Usage
```plaintext
Welcome to Bank Account Management System!

1. Add Account
2. Deposit
3. Withdraw
4. Display Account Info
5. Transfer Funds
6. Display All Accounts
7. Delete Account
8. Exit

Choose an option: 1

Enter name: John Doe
Enter ID: 1234
Enter account type (1 for Savings, 2 for Checking): 1
Enter account number: 1001
Account created successfully!

...

Choose an option: 6

All Bank Accounts:
Account Number: 1001, Account Holder: John Doe, Balance: 0.0
```

## Code Highlights

### Key Classes and Methods
- **Bank**:
  - `transferFunds(int fromAccountNumber, int toAccountNumber, double amount)`: Transfers funds between two accounts.
  - `displayAccountInfo(int accountNumber)`: Displays the balance of a specific account.
- **Admin**:
  - `displayAllAccounts(Bank bank)`: Displays all accounts with details.
  - `deleteAccount(Bank bank, int accountNumber)`: Deletes an account from the bank.

### Exception Handling
The system includes error handling for:
- Invalid account operations (e.g., withdrawing more than the balance).
- Nonexistent accounts.
- Input mismatches (e.g., entering a non-numeric value for numeric fields).

## Requirements Fulfilled
- **Classes and Objects**: Multiple classes represent system entities like `Person`, `BankAccount`, and `Admin`.
- **Inheritance and Polymorphism**: `SavingsAccount` and `CheckingAccount` extend the abstract class `BankAccount`.
- **Exception Handling**: Proper error handling is implemented using try-catch blocks.

## License
This project is for educational purposes only and is distributed under the MIT License. 

---
