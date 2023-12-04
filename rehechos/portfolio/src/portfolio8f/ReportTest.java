package portfolio8f;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class ReportTest {

  @Test void testReportAfterADeposit() {
    assertEquals( "Cuenta:\n" + 
                  "  Deposit: 10", SummaryTreeReport.report( accountWith10() ) );
  }
  
  @Test void testReportAfterAWithdraw() {
    Account account = new Account();
    account.deposit( 10 )
           .withdraw( 5 );
    assertEquals( "Cuenta:\n" + 
                  "  Deposit: 10\n" +
                  "  Withdraw: 5", SummaryTreeReport.report( account ) );
  }  
  
  // reportes:
  @Test void testReportPortfolioAfterADeposit() {
    assertEquals( "Portfolio:\n" +  
                  "  Cuenta:\n" +  
                  "    Deposit: 10", SummaryTreeReport.report( new Portfolio().addAccount( accountWith10() ) ) );
  }
 
  @Test void testReportPortfolioComplex() {
    assertEquals( "Portfolio:\n" +  
                  "  Portfolio:\n" +  
                  "    Cuenta:\n" +  
                  "      Deposit: 10\n" +
                  "  Cuenta:\n" + 
                  "    Deposit: 10\n" +
                  "  Portfolio:\n" +  
                  "    Cuenta:\n" +  
                  "      Deposit: 10", 
                  SummaryTreeReport.report( 
                      new Portfolio().addAccount( new Portfolio().addAccount( accountWith10() ) )
                                     .addAccount( accountWith10() )
                                     .addAccount( new Portfolio().addAccount( accountWith10() ) ) ) );
  }
 
  @Test void testReportAfterATransferenceWithdraw() {
    Account anAccount = accountWith10();
    Account anotherAccount = accountWith10();
    
    transferRegister( 10, anAccount, anotherAccount );
    assertEquals( "Cuenta:\n" + 
                  "  Deposit: 10\n" +
                  "  Débito por transferencia de: 10", SummaryTreeReport.report( anAccount ) );
  }

  @Test void testReportAfterATransferenceDeposit() {
    Account anAccount = accountWith10();
    Account anotherAccount = accountWith10();
    
    transferRegister( 10, anAccount, anotherAccount );
    assertEquals( "Cuenta:\n" + 
                  "  Deposit: 10\n" +
                  "  Depósito por transferencia de: 10", SummaryTreeReport.report( anotherAccount ) );
  }

  @Test void testAccountSummaryReport() {
    Account anAccount = accountWith10();
    Account anotherAccount = accountWith10();
    transferRegister( 10, anAccount, anotherAccount );
    anAccount.deposit( 10 );

    transferRegister( 10, anotherAccount, anAccount );
    assertEquals( "Resumen de Cuenta:\n"+
                  "Deposito por: 10\n"+
                  "Salida por transferencia de: 10\n"+
                  "Deposito por: 10\n"+
                  "Entrada por transferencia de: 10\n"+
                  "Balance: 20"
              , AccountSummaryReport.report( anAccount ) );
  }

  @Test void testTotalOfTransferReport() {
    Account anAccount = accountWith10();
    Account anotherAccount = accountWith10();
    transferRegister( 10, anAccount, anotherAccount );
    anAccount.deposit( 10 );

    assertEquals( "Neto de Transferencias:\n"+
                  "Salida por Transferencias: 10\n"
              , TotalOfTransferReport.report( anAccount ));
  }

  @Test void testBalanceReport() {
    Portfolio bigPortfolio = new Portfolio();
    Portfolio mediumPortfolio = new Portfolio();
    Portfolio smallPortfolio = new Portfolio();
    Account anotherAccount = accountWith10().withdraw(5);
    Account anotherAccount2 = accountWith10().deposit(5);
    smallPortfolio.addAccount(anotherAccount);
    mediumPortfolio.addAccount(accountWith10());
    bigPortfolio.addAccount(smallPortfolio).addAccount(anotherAccount2).addAccount(mediumPortfolio);

    assertEquals("Reporte de balances:\n" +
                "Portfolio 30\n" +
                "  Portfolio 5\n" +
                "    Cuenta 5\n" +
                "  Cuenta 15\n" +
                "  Portfolio 10\n" +
                "    Cuenta 10"

            , BalanceReport.report( bigPortfolio ));
  }
  
  private Transfer transferRegister( int anAmmount, Account originAccount, Account destinationAccount ) {
    return Transfer.register( anAmmount, originAccount, destinationAccount );
  }

  private Account accountWith10() {
    return new Account().deposit( 10 );
  }
  
}
