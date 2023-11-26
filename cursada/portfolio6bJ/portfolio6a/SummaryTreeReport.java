package portfolio6a;

import java.util.ArrayList;
import java.util.List;

public class SummaryTreeReport {
  private List<String> report = new ArrayList();
  private String prefix = "";
  
  public static String report( Accountable anAccount ) {
    return new SummaryTreeReport().list( anAccount );
  }

  public String list( Accountable anAccount ) {
    report.add( prefix + anAccount.title() );
    anAccount.reportOn( this );
    report.add( prefix + anAccount.footer() );

    return String.join("\n", report);
  }

  public void reportAsAccount( Account account ) {
    String oldPrefix = prefix;
    prefix = prefix + "  ";
    account.reportTransactionsOn( this );
    prefix = oldPrefix;
  }

  public void reportAsPortfolio( Portfolio portfolio ) {
    String oldPrefix = prefix;
    prefix = prefix + "  ";
    /*portfolio.accounts.forEach( (accountable) -> {
      list(  accountable );
    });*/
    portfolio.reportAccountsOn( this);
    prefix = oldPrefix;
  }

  public void reportAsTransaction( Transaction transaction ) {
    /*report.add( prefix + "  " + transaction.reportDetail() );*/
    transaction.reportOn( this );
  }

  public void reportAsDetail(String header, int value) {
    report.add(prefix + header + value);
  }
}
