package org.example.bankkata;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.datatable.DataTable;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankAccountSteps {

    private Account account;
    private StatementPrinter mockPrinter;

    public BankAccountSteps() {
        mockPrinter = new StatementPrinterImpl();
        this.account = new Account(mockPrinter);
    }

    @Given("a client makes a deposit of {int} on {int}-{int}-{int}")
    public void a_client_makes_a_deposit_of_on(Integer amount, Integer day, Integer month, Integer year) {
        LocalDate date = LocalDate.of(year, month, day);
        account.deposit(amount);
    }

    @Given("a deposit of {int} on {int}-{int}-{int}")
    public void a_deposit_of_on(Integer amount, Integer day, Integer month, Integer year) {
        LocalDate date = LocalDate.of(year, month, day);
        account.deposit(amount);
    }

    @Given("a client withdraws {int} on {int}-{int}-{int}")
    public void a_withdrawal_of_on(Integer amount, Integer day, Integer month, Integer year) {
        LocalDate date = LocalDate.of(year, month, day);
        account.withdraw(amount);
    }

    @When("they print their bank statement")
    public void they_print_their_bank_statement() {
        account.printStatement();
    }

    @Then("they would see:")
    public void they_would_see(DataTable dataTable) {
        List<List<String>> rows = dataTable.asLists(String.class);
        List<Transaction> transactions = account.getTransactions();

        Collections.reverse(transactions);
        assertEquals(rows.size() - 1, transactions.size(), "Mismatch in number of transactions");

        for (int i = 1; i < rows.size(); i++) {
            String expectedDate = rows.get(i).get(0).trim();
            int expectedAmount = Integer.parseInt(rows.get(i).get(1).trim());
            int expectedBalance = Integer.parseInt(rows.get(i).get(2).trim());

            Transaction actualTransaction = transactions.get(i - 1);

            assertEquals(LocalDate.parse(expectedDate, java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy")), actualTransaction.getDate(), "Mismatched date");
            assertEquals(expectedAmount, actualTransaction.getAmount(), "Mismatched amount");
            assertEquals(expectedBalance, actualTransaction.getBalance(), "Mismatched balance");


        }
    }


}
