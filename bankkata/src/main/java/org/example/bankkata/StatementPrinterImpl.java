package org.example.bankkata;

import java.util.Collections;
import java.util.List;

public class StatementPrinterImpl implements StatementPrinter{
    @Override
    public void print(List<Transaction> transactions) {
        System.out.println("Date       | Amount  | Balance");
        //pour afficher les transactions les plus récente en premier
        Collections.reverse(transactions);
        for ( Transaction transaction : transactions){
            System.out.println(transaction);
        }
        //revenir à l'ordre initial
        Collections.reverse(transactions);
    }
}
