package portfolio6a;

import java.util.ArrayList;
import java.util.List;

public class SummaryTreeReport {
  private List<String> report = new ArrayList();
  private String prefix = "";
  
  public SummaryTreeReport( Accountable anAccount ) {
  
//    report.add( prefix + anAccount.title() );
    
    if ( anAccount.getClass().equals( Account.class ) ) {
      report.add( prefix + anAccount.title() );
      ((Account)anAccount).transactions().forEach( (transaction) -> {
        report.add( prefix + "  " + transaction.reportDetail() );
      });
      report.add( prefix + "Balance: " + anAccount.balance() );
    } else {

      report.add( prefix + "Portfolio:" );
      ((Portfolio)anAccount).accounts.forEach( (accountable) -> {
          report.add( accountable.report( prefix + "  ") );
      });

      report.add( prefix + "Balance: " + anAccount.balance() );
    }

  }
 
  public String report() {
    return String.join("\n", report);
  }
  
}
