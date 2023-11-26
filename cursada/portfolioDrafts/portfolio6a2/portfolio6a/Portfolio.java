package portfolio6a;

import java.util.ArrayList;
import java.util.List;

public class Portfolio extends Accountable {
  public List<Accountable> accounts = new ArrayList();

  public int balance() {
    return accounts.stream()
            .map( (transaction) -> transaction.balance() )
            .reduce(0, (a, b) -> a + b);
  }

  public Portfolio addAccount( Accountable anAccount ) {
    if ( contains( anAccount ) ) throw new RuntimeException();

    accounts.add( anAccount );
    return this;
  }

  public boolean contains( Accountable anAccount ) {
    List  reminder = accounts();
    reminder.retainAll( anAccount.accounts() );
    return !reminder.isEmpty();
  }

  public List<Account> accounts() {
    return accounts.stream().map( (accountable) -> accountable.accounts() )
            .reduce( new ArrayList(), (a, b) -> { a.addAll( b ); return a; } );
  }
  public String title() {
    return "Portfolio:";
  }

  public void reportOn( SummaryTreeReport report ) {
    report.reportAsPortfolio( this );

  }

  public void reportAccountsOn(SummaryTreeReport report) {
    accounts().forEach( (account) -> {
      report.list( account );
    });
  }
}
