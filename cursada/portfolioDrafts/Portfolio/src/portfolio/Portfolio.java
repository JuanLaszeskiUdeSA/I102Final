package portfolio;

import java.util.ArrayList;
import java.util.List;

public class Portfolio extends Accountable {
    private List<Accountable> accountableList;

    public Portfolio() {
        accountableList = new ArrayList<>();
    }

    public int balance() {
        return accountableList.stream().map(Accountable::valueForBalance).reduce(0, Integer::sum);
    }

    public int valueForBalance() {
        return accounts().stream().map(Account::valueForBalance).reduce(0, Integer::sum);
    }

    public String report() {
        return report("");
    }

    public String report(String prefix) {
        List<String> report = new ArrayList<>();
        report.add(prefix + "Portfolio:");
        accountableList.forEach((accountable) -> {
            report.add(accountable.report(prefix + "\t"));
        });
        return String.join("\n", report);
    }

    public boolean contains(Accountable anAccountable) {
        List  reminder = accounts();
        reminder.retainAll( anAccountable.accounts() );
        return !reminder.isEmpty();
    }

    public List<Account> accounts() {
        return accountableList.stream().map(Accountable::accounts)
                            .reduce( new ArrayList<>(), (acc, accountable) -> { acc.addAll( accountable );
                            return acc; } );
    }

    public Portfolio addAccount(Accountable anAccountable) {
        if (contains(anAccountable)) {
            throw new RuntimeException();
        }
        accountableList.add(anAccountable);
        return this;
    }
}
