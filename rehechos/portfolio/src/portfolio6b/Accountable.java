package portfolio6b;

import java.util.List;

public abstract class Accountable {

  public abstract int balance();
//  public String report() { return report( "" ); }
//  public abstract String report( String prefix );
  public abstract boolean contains( Accountable anAccountable );
  public abstract List<Account> accounts();
  public abstract String title();
  
  public String footer() {
    return  "Balance: " + balance();
  }
  public abstract void reportOn(SummaryTreeReport summaryTreeReport);
  
}
