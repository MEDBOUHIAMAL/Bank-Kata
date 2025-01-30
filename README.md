#  Bank Kata (Technical Test for Skypay)

This project is my solution for the Bank Kata technical test as part of my application for the **QA and Test Automation Engineer position at Skypay**.
The goal was to implement a simple bank account system while applying **Mockist principles** and **acceptance testing with Cucumber**.

---

## Objectives and Constraints

This implementation adheres to the following requirements:

### 🔹 Implement a class Account that conforms to the given interface
### 🔹 Use Mockist approach to drive the architecture and validate interactions with dependencies.
### 🔹 Simulate bank statement printing via a mocked StatementPrinter class.
### 🔹 Write JUnit and Cucumber tests to validate functionality and ensure non-regression.



---


## Technologies Used

- **Java 17**
- **Maven for dependency management**
- **JUnit 5 for unit testing**
- **Mockito for mocking dependencies**
- **Cucumber for BDD-style acceptance testing**
- **IntelliJ IDEA for development and test execution**

---

## 📂 Project Structure

```plaintext
src/main/java/org/example/bankkata/
-- Account.java             # Implements AccountService
-- AccountService.java      # Provided interface
-- Transaction.java         # Represents a transaction
-- StatementPrinter.java    # Interface for statement printing
-- StatementPrinterImpl.java # Implements statement printing logic
```
```plaintext
src/test/java/org/example/bankkata/
-- AccountTest.java         # Unit tests using Mockito
--BankAccountSteps.java    # Step definitions for Cucumber tests
-- RunCucumberTest.java     # Runs acceptance tests

```
```plaintext
src/test/resources/features/
--bank_kata.feature          # define Cucumber scenarios using Gherkin syntax ,  test case requirements




```

---

## Running the Tests


### Run Unit Tests

```bash
mvn test
```
### Run Acceptance Tests with Cucumber

```bash
mvn verify
```

---

## Example Tests

### JUnit Test - Using Mockist Approach

```plaintext
@Test
void when_Call_Printer_With_Correct_Transaction_test_should_success() {
    account.deposit(1000);
    account.deposit(2000);
    account.withdraw(500);
    account.printStatement();

    verify(mockPrinter).print(List.of(
        new Transaction(LocalDate.now(), 1000, 1000),
        new Transaction(LocalDate.now(), 2000, 3000),
        new Transaction(LocalDate.now(), -500, 2500)
    ));
}

```
👉 This follows Mockist approach since it verifies interactions rather than state.

### Cucumber Scenario

```plaintext

Scenario: Client deposits and withdraws money
  Given a client makes a deposit of 1000 on 10-01-2012
  And a deposit of 2000 on 13-01-2012
  And a client withdraws 500 on 14-01-2012
  When they print their bank statement
  Then they would see:
    | Date       | Amount | Balance |
    | 14/01/2012 | -500   | 2500    |
    | 13/01/2012 | 2000   | 3000    |
    | 10/01/2012 | 1000   | 1000    |
```










