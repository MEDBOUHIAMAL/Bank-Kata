package org.example.bankkata;

import java.util.List;

public interface StatementPrinter {
    void print(List<Transaction> transactions);
}
