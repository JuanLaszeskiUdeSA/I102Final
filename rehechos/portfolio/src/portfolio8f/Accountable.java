package portfolio8f;

import java.util.List;

public abstract class Accountable {

  public abstract int balance();
  public abstract boolean contains( Accountable anAccountable );
  public abstract List<Account> accounts();
  public abstract void accept( PortfolioVisitor summaryTreeReport );
  
}
