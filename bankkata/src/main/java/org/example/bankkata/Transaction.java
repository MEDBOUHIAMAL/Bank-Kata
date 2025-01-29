package org.example.bankkata;

import java.time.LocalDate;
import java.util.Objects;

public class Transaction {
    private LocalDate date;
    private int amount;
    private int balance;

    public Transaction(LocalDate date, int amount, int balance) {
        this.date = date;
        this.amount = amount;
        this.balance = balance;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getAmount() {
        return amount;
    }

    public int getBalance() {
        return balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return amount == that.amount &&
                balance == that.balance &&
                Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, amount, balance);
    }

    @Override
    public String toString() {
        return date + " | " + (amount >= 0 ? " " : "") + amount + "    | " + balance;
    }
}
