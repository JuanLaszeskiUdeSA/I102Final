package portfolio6a;

import java.util.List;

public abstract class Accountable {

  public abstract int balance();
  public abstract boolean contains( Accountable anAccountable );
  public abstract List<Account> accounts();
  public abstract String title();
  public abstract void reportOn(SummaryTreeReport summaryTreeReport);

  public String footer() { return "Balance: " + balance(); }

}
