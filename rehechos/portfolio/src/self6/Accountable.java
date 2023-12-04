package self6;

import java.util.List;

public abstract class Accountable {

  public abstract int balance();
  public abstract boolean contains( Accountable anAccountable );
  public abstract List<Account> accounts();

  public abstract String title();
  public String footer() {
    return "Balance: " + balance();
  }

  public abstract void reportOn(SummaryTreeReport summaryTreeReport);
}
