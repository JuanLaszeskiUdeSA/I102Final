package self1;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private List<Integer> transactions;

    public Account() {
        transactions = new ArrayList<>();
    }

    public Account deposit(int amount) {
        transactions.add(amount);
        return this;
    }

    public Account withdraw(int amount) {
        if (balance() < amount) {
            throw new RuntimeException("Not enough money");
        }
        transactions.add(-amount);
        return this;
    }

    public String report() {
        List<String> report = new ArrayList<>();
        transactions.stream().forEach(transaction -> {
            if (transaction > 0) {
                report.add("Deposit: " + transaction);
            } else {
                report.add("Withdraw: " + -transaction);
            }
        });

        return String.join("\n", report) + "\nBalance: " + balance();
    }

    public int balance() {
        return transactions.stream().reduce(0, Integer::sum);
    }
}
