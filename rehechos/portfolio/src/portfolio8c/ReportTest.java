package portfolio8c;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class ReportTest {

  @Test void testReportAfterADeposit() {
    assertEquals( "Cuenta:\n" + 
                  "  Deposit: 10", AccountSummary.report( accountWith10() ) );
  }
  
  @Test void testReportAfterAWithdraw() {
    Account account = new Account();
    account.deposit( 10 )
           .withdraw( 5 );
    assertEquals( "Cuenta:\n" + 
                  "  Deposit: 10\n" +
                  "  Withdraw: 5", AccountSummary.report( account ) );
  }  
  
  // reportes:
  @Test void testReportPortfolioAfterADeposit() {
    assertEquals( "Portfolio:\n" +  
                  "  Cuenta:\n" +  
                  "    Deposit: 10", AccountSummary.report( new Portfolio().addAccount( accountWith10() ) ) );
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
                  AccountSummary.report(
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
                  "  Débito por transferencia de: 10", AccountSummary.report( anAccount ) );
  }

  @Test void testReportAfterATransferenceDeposit() {
    Account anAccount = accountWith10();
    Account anotherAccount = accountWith10();
    
    transferRegister( 10, anAccount, anotherAccount );
    assertEquals( "Cuenta:\n" + 
                  "  Deposit: 10\n" +
                  "  Depósito por transferencia de: 10", AccountSummary.report( anotherAccount ) );
  }


  //Balance report
  @Test void testBalanceReportAfterADeposit() {
    assertEquals( "Portfolio 10\n" +
            "  Cuenta: 10", BalanceReport.report(new Portfolio().addAccount(accountWith10())));
  }

  /*
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

  private Transfer transferRegister( int anAmmount, Account originAccount, Account destinationAccount ) {
    return Transfer.register( anAmmount, originAccount, destinationAccount );
  }

  private Account accountWith10() {
    return new Account().deposit( 10 );
  }*/

  @Test void testComplexBalanceReport(){
    assertEquals("Portfolio: 30\n" +
            "  Portfolio: 5\n" +
            "    Cuenta: 5\n" +
            "  Cuenta: 15\n" +
            "  Portfolio: 10\n" +
            "    Cuenta: 10",
            BalanceReport.report(
                    new Portfolio().addAccount(new Portfolio().addAccount(new Account().deposit(5)))
                            .addAccount(new Account().deposit(15))
                            .addAccount(new Portfolio().addAccount(new Account().deposit(10)))));
  }

  //Report Summary

  @Test void testAccountSummaryReportAfterADeposit() {
    assertEquals( "Resumen de Cuenta:\n" +
                  "Depósito por 10.\n" +
                  "Balance = 10", AccountSummary.report( accountWith10() ) );
  }


  /*
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

  private Transfer transferRegister( int anAmmount, Account originAccount, Account destinationAccount ) {
    return Transfer.register( anAmmount, originAccount, destinationAccount );
  }*/
  /*@Test
    public void testComplexAccountSummaryReport(){
    Account complexAccount = new Account().deposit(100).withdraw(50);
    Transaction
    assertEquals("Resumen de Cuenta:\n" +
            "Depósito por 100.\n" +
            "Extracción por 50\n." +
            "Salida por transferencia de 20.\n" +
            "Entrada por transferencia de 30.\n" +
            "Balance = 60", AccountSummary.report(



  }*/

  //Neto report
  @Test void testNetoReportAfterADeposit() {
    assertEquals( "Neto de Transferencias:\n" +
            "Salida por transferencias: 0.\n" +
            "Ingreso por transferencias: 0.\n" +
            "Neto de transferencias: 0.", NetoReport.report( accountWith10() ) );
  }

  /*
  @Test void testReportAfterAWithdraw() {
    Account account = new Account();
    account.deposit( 10 )
            .withdraw( 5 );
    assertEquals( "Cuenta:\n" +
            "  Deposit: 10\n" +
            "  Withdraw: 5", AccountSummary.report( account ) );
  }

  // reportes:
  @Test void testReportPortfolioAfterADeposit() {
    assertEquals( "Portfolio:\n" +
            "  Cuenta:\n" +
            "    Deposit: 10", AccountSummary.report( new Portfolio().addAccount( accountWith10() ) ) );
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
            AccountSummary.report(
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
            "  Débito por transferencia de: 10", AccountSummary.report( anAccount ) );
  }

  @Test void testReportAfterATransferenceDeposit() {
    Account anAccount = accountWith10();
    Account anotherAccount = accountWith10();

    transferRegister( 10, anAccount, anotherAccount );
    assertEquals( "Cuenta:\n" +
            "  Deposit: 10\n" +
            "  Depósito por transferencia de: 10", AccountSummary.report( anotherAccount ) );
  }*/

  private Account accountWith10() {
    return new Account().deposit( 10 );
  }

  private Transfer transferRegister( int anAmmount, Account originAccount, Account destinationAccount ) {
    return Transfer.register( anAmmount, originAccount, destinationAccount );
  }
}
