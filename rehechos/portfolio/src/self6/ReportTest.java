package self6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReportTest {

  @Test void testReportAfterADeposit() {
    
    assertEquals( "Cuenta:\n" + 
                  "  Deposit: 10\n" + 
                  "Balance: 10",
//                  SummaryTreeReport.report(accountWith10()).report()
                  SummaryTreeReport.report(accountWith10())
                  );
  }
  
  @Test void testReportAfterAWithdraw() {
    Account account = new Account();
    account.deposit( 10 )
           .withdraw( 5 );
    assertEquals( "Cuenta:\n" + 
                  "  Deposit: 10\n" +
                  "  Withdraw: 5\n" + 
                  "Balance: 5",
                  SummaryTreeReport.report(account) );
  }
  
  
  // reportes:
  @Test void testReportPortfolioAfterADeposit() {
    assertEquals( "Portfolio:\n" +  
                  "  Cuenta:\n" +  
                  "    Deposit: 10\n" + 
                  "  Balance: 10\n" + 
                  "Balance: 10", 
                  SummaryTreeReport.report(new Portfolio().addAccount( accountWith10() ))
                  );
  }
 
  @Test void testReportPortfolioComplex() {
    assertEquals( "Portfolio:\n" +  
                  "  Portfolio:\n" +
                  "    Cuenta:\n" + 
                  "      Deposit: 10\n" +  
                  "    Balance: 10\n" +
                  "  Balance: 10\n" + 
                  "  Cuenta:\n" + 
                  "    Deposit: 10\n" + 
                  "  Balance: 10\n" +
                  "  Portfolio:\n" +  
                  "    Cuenta:\n" +  
                  "      Deposit: 10\n" + 
                  "    Balance: 10\n" + 
                  "  Balance: 10\n" + 
                  "Balance: 30", 
                  SummaryTreeReport.report( new Portfolio().addAccount( new Portfolio().addAccount( accountWith10() ) )
                                 .addAccount( accountWith10() )
                                 .addAccount( new Portfolio().addAccount( accountWith10() ) ) ) );
  }
   
  @Test void testReportAfterATransferenceWithdraw() {
    Account anAccount = accountWith10();
    Account anotherAccount = accountWith10();
    
    Transfer.register( 10, anAccount, anotherAccount );
    assertEquals( "Cuenta:\n" + 
                  "  Deposit: 10\n" +
                  "  Débito por transferencia de: 10\n" +
                  "Balance: 0", SummaryTreeReport.report( anAccount ) );
  }

  @Test void testReportAfterATransferenceDeposit() {
    Account anAccount = accountWith10();
    Account anotherAccount = accountWith10();
    
    Transfer.register( 10, anAccount, anotherAccount );
    assertEquals( "Cuenta:\n" + 
                  "  Deposit: 10\n" +
                  "  Depósito por transferencia de: 10\n" +
                  "Balance: 20", SummaryTreeReport.report( anotherAccount ) );
  }
  
  private Account accountWith10() {
    return new Account().deposit( 10 );
  }


  
}
