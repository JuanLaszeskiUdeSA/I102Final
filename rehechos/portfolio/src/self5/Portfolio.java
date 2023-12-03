package self5;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Portfolio implements Accountable {
    private List<Accountable> accounts;

    public Portfolio() {this.accounts = new ArrayList<>();}

    public Portfolio addAccount(Accountable account) {
        if (contains(account)) {
            throw new RuntimeException("account already in the portfolio");
        }
        accounts.add(account);
        return this;
    }

    public boolean contains(Accountable account) {
        List<Accountable> retainer = accounts();
        retainer.retainAll(account.accounts());
        return !retainer.isEmpty();
    }

    public int balance() {
        return accounts.stream()
                .map(Accountable::balance)
                .reduce(0, Integer::sum);
    }


    public List<Accountable> accounts() {
        return accounts.stream()
                .flatMap(account -> account.accounts().stream()).collect(Collectors.toList());
    }


    public String report() {
        return report("");
    }

    @Override
    public String report(String prefix) {
        return prefix + header() + "\n" +
                accounts.stream()
                        .map(account -> account.report(prefix + "  "))
                        .collect(Collectors.joining("\n"));

    }

    @Override
    public String header() {
        return "Portfolio:";
    }
}
