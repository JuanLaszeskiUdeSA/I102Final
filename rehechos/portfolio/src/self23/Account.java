package self23;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private List<Transaction> transactions;

    public Account() {
        transactions = new ArrayList<>();
    }

    public Account deposit(int amount) {
        transactions.add(Transaction.deposit(amount));
        return this;
    }

    public Account withdraw(int amount) {
        if (balance() < amount) {
            throw new RuntimeException("Not enough money");
        }
        transactions.add(Transaction.withdraw(amount));
        return this;
    }

    public String report() {
        List<String> report = new ArrayList<>();
        transactions.forEach(transaction -> report.add(transaction.report()));

        return String.join("\n", report) + "\nBalance: " + balance();
    }

    public int balance() {
        return transactions.stream().mapToInt(Transaction::value).sum();
    }
}
