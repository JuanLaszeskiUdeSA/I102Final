package portfolio4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class PortfolioTest {

  @Test void testBalanceOnNewAccount() {
    assertEquals( 0, new Account().balance() );
  }

  @Test void testBalanceAfterADeposit() {
    assertEquals( 10, new Account().deposit( 10 ).balance() );
  }
  
  @Test void testBalanceAfterAWithdraw() {
    Account account = new Account().deposit( 10 ).withdraw( 5 );
    assertEquals( 5, account.balance() );
  }

  @Test void testWithdrawFailsIfNoResidue() {
    Account account = new Account();
    assertThrows( RuntimeException.class, () -> account.withdraw( 5 ) );
    assertEquals( 0, account.balance() );
  }
  

  @Test void testReportAfterADeposit() {
    assertEquals( "Cuenta:" + "\n\tDeposit: 10",
                  new Account().deposit( 10 ).report() );
  }
  
  @Test void testReportAfterAWithdraw() {
    Account account = new Account();
    account.deposit( 10 )
           .withdraw( 5 );
    assertEquals( "Cuenta:" + "\n\tDeposit: 10" +
                  "\n\tWithdraw: 5"
                  , account.report() );
  }

  //Portfolio
  @Test void testBalanceOnNewPortfolio() {
    assertEquals( 0, new Portfolio().balance() );
  }

  @Test void testBalanceAfterAddingAnAccount() {
    Portfolio portfolio = new Portfolio().add( new Account().deposit( 10 ) );
    assertEquals( 10, portfolio.balance() );
  }

  @Test void testBalanceAfterAddingAnAccountTwice() {
    Portfolio portfolio = new Portfolio();
    Account account = accountWith10();
    portfolio.add( account );
    assertThrows(Exception.class, () -> portfolio.add( account ) );
  }

  @Test void testBalanceAfterAddingAPortfolio() {
    Portfolio portfolio = new Portfolio().add( new Account().deposit( 10 ) );
    Portfolio otherPortfolio = new Portfolio();
    portfolio.add( otherPortfolio );
    assertEquals( 10, portfolio.balance() );
  }

  @Test void testPortfolioBalanceAddsWell() {
    Portfolio portfolio = new Portfolio().add( new Account().deposit( 10 ) );
    Portfolio otherPortfolio = new Portfolio().add( new Account().deposit( 20 ) );
    portfolio.add( otherPortfolio );
    assertEquals( 30, portfolio.balance() );
  }

  //Igualdad de cuentas
  @Test void testPortfolioFailsAfterAddingAnAccountTwiceIndirectlyAlone() {
    Account anAccount = accountWith10();
    Portfolio a = new Portfolio().add( anAccount );
    Portfolio b = new Portfolio().add( anAccount );

    assertThrows( RuntimeException.class, () -> b.add( a ) );

    assertEquals( 10, a.balance() );
  }

  @Test void testPortfolioFailsAfterAddingAnAccountTwiceIndirectlyInPortfolio() {
    Account anAccount = accountWith10();
    Portfolio a = new Portfolio().add( anAccount );
    Portfolio b = new Portfolio().add( anAccount );

    assertThrows( RuntimeException.class, () -> b.add( a ) );

    assertEquals( 10, a.balance() );
  }

  @Test void testPortfolioFailsAfterAddingAnAccountTwiceIndirectlyInOtherBranch() {
    Account anAccount = accountWith10();
    Portfolio a = new Portfolio().add( anAccount );
    Portfolio b = new Portfolio().add( anAccount );

    assertThrows( RuntimeException.class, () -> new Portfolio().add( a ).add( b ) );

    assertEquals( 10, a.balance() );
  }

  //Reportes:

  @Test void testReportPortfolioAfterADeposit() {
    assertEquals( "Portfolio:\n" +
            "\tCuenta:\n" +
            "\t\tDeposit: 10", new Portfolio().add( new Account().deposit(10) ).report() );
  }
  @Test void testReportPortfolioComplex() {
    assertEquals( "Portfolio:\n" +
                    "\tPortfolio:\n" +
                    "\t\tCuenta:\n" +
                    "\t\t\tDeposit: 10\n" +
                    "\tCuenta:\n" +
                    "\t\tDeposit: 10\n" +
                    "\tPortfolio:\n" +
                    "\t\tCuenta:\n" +
                    "\t\t\tDeposit: 10",
            new Portfolio().add( new Portfolio().add( accountWith10() ) )
                    .add( accountWith10() )
                    .add( new Portfolio().add( accountWith10() ) ).report() );
  }

  private Account accountWith10() {
    Account anAccount = new Account().deposit( 10);
    return anAccount;
  }
}