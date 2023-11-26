package portfolio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Account extends Accountable {
    private List<Transaction> transactions = new ArrayList<>();

    public int balance() {
        return transactions.stream().mapToInt(Transaction::valueForBalance).sum();
    }

    public Account deposit(int amount) {
        transactions.add(new Deposit(amount));
        return this;
    }

    public Account credit(int amount) {
        transactions.add(new Credit(amount));
        return this;
    }

    public Account withdraw(int amount) {
        if (balance() < amount) {
            throw new RuntimeException("Insufficient funds");
        }
        transactions.add(new Withdraw(amount));
        return this;
    }

    public Account debit(int amount) {
        transactions.add(new Debit(amount));
        return this;
    }

    public int valueForBalance() {
        return balance();
    }

    public String report() {
        return report("");
    }

    public String report(String prefix) {
        List<String> report = new ArrayList<>();
        report.add(prefix + "Cuenta:");
        transactions.forEach((transaction) -> {
            report.add(prefix + "\t" + transaction.report());
        });
        return String.join("\n", report);
    }

    public boolean contains(Accountable accountable) {
        return equals(accountable);
    }

    public List<Account> accounts() {
        return new ArrayList<>(List.of(this));
    }

}