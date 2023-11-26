package portfolio4;

import java.util.ArrayList;
import java.util.List;

public class Portfolio implements Accountable {
    private ArrayList<Accountable> portfolio = new ArrayList<>();

    public int balance() {
        //                if (each instanceof Account) {
        //                if (each.getClass().equals(Account.class)) {
        /*if (Account.class.isInstance(each)) {
                    return each.balance();
                } else
                    return Portfolio.class.cast(each).balance();*/
        return portfolio.stream()
            .map(Accountable::balance)
                .reduce(0, Integer::sum);
    }

    public Portfolio add(Accountable anAccountable) {
        if (this.contains(anAccountable)) {
            throw new RuntimeException("Account already exists in portfolio");
        }
        portfolio.add(anAccountable);
        return this;
    }

    public String report() {return report( "" );}

    public String report(String prefix) {
        List<String> report = new ArrayList();

        report.add( prefix + "Portfolio:" );
        portfolio.forEach( (accountable) -> {
            report.add( accountable.report( prefix + "\t") );
        });

        return String.join("\n", report);
    }

    public boolean contains(Accountable anAccountable) {
        List reminder = accounts();
        reminder.retainAll(anAccountable.accounts());
        return !reminder.isEmpty();
    }

    public List<Account> accounts() {
        return portfolio.stream().map( (accountable) -> accountable.accounts() )
                .reduce( new ArrayList<>(), (a, b) -> { a.addAll( b ); return a; } );
    }
}