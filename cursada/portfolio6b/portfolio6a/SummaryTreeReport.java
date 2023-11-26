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

  //VisitOn = reportOn = accept

  public void visitAccount(Account account ) {
    account.reportTransactionsOn( this );
  }

  public void visitPortfolio(Portfolio portfolio ) {
    String oldPrefix = prefix;
    prefix = prefix + "  ";
    portfolio.visitAccountOn( this );
    prefix = oldPrefix;
  }

  public void visitTransaction(Transaction transaction ) {
    report.add( prefix + "  " + transaction.visitOn(this) );
  }

   public String visitDeposit(Deposit deposit ) {
     return "Deposit: " + deposit.value();
   }

   public String visitWithdraw(Withdraw withdraw ) {
        return "Withdraw: " + withdraw.value();
   }

   public String visitTransferDestination(TransferDestination transferDestination ) {
        return "Depósito por transferencia de: " + transferDestination.value();
   }
   public String visitTransferOrigin(TransferOrigin transferOrigin ) {
        return "Débito por transferencia de: " + transferOrigin.value();
   }
}
