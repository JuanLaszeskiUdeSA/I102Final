package self5;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Account implements Accountable {
    private List<Transaction> transactions = new ArrayList();

    public Account deposit(int anAmount) {
        transactions.add(new Deposit(anAmount));
        return this;
    }

    public Account withdraw(int anAmount) {
        if (balance() - anAmount < 0) {
            throw new RuntimeException("not enough money in the account");
        }

        transactions.add(new Withdraw(anAmount));
        return this;
    }

    public int balance() {
        return transactions.stream()
                .map(Transaction::valueForBalance)
                .reduce(0, Integer::sum);
    }


    public List<Accountable> accounts() {
        return List.of(this);
    }


    public String report() {
       return report("");
    }


    public String report(String prefix) {
        List<String> reports = new ArrayList<>();
        reports.add(prefix + header());
        reports.addAll(transactions.stream()
                .map(transaction -> "  " + prefix + transaction.reportDetail())
                .collect(Collectors.toList()));
        return String.join("\n", reports) + "\n" + prefix + "Balance: " + balance();
    }

    public String header() {
        return "Cuenta:";
    }
}
