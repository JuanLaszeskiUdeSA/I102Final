package self6a;

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
    Account account = new Account();
    account.deposit( 10 )
           .withdraw( 5 );
    assertEquals( 5, account.balance() );
  }

  @Test void testWithdrawFailsIfNoResidue() {
    Account account = new Account();
    assertThrows( RuntimeException.class, () -> account.withdraw( 5 ) );
    assertEquals( 0, account.balance() );
  }
  

  @Test void testReportAfterADeposit() {
    assertEquals( "Cuenta:\n" + 
                  "  Deposit: 10\n" +
                  "Balance: 10",
                  new Account().deposit( 10 ).report() );
  }
  
  @Test void testReportAfterAWithdraw() {
    Account account = new Account();
    account.deposit( 10 )
           .withdraw( 5 );
    assertEquals( "Cuenta:\n" + 
                  "  Deposit: 10\n" +
                  "  Withdraw: 5\n" +
                  "Balance: 5", account.report() );
  }
  
  // Portfolios
  @Test void testBalanceOnNewPortfolio() {
    assertEquals( 0, new Portfolio().balance() );
  }

  @Test void testBalanceAfterAddingAnAccount() {
    Portfolio p = new Portfolio();
    p.addAccount( accountWith10() );
    
    assertEquals( 10, p.balance() );
  }

  @Test void testPortfolioFailsAfterAddingAnAccountTwice() {
    Portfolio p = new Portfolio();
    Account anAccount = accountWith10();
    p.addAccount( anAccount);
    
    assertThrows( RuntimeException.class, () -> p.addAccount( anAccount ) );

    assertEquals( 10, p.balance() );
  }


  @Test void testPortfolioAfterAddingAPortfolio() {
    Portfolio a = new Portfolio();
    Portfolio b = new Portfolio();
    a.addAccount( b );
    
    assertEquals( 0, a.balance() );
  }

  @Test void testPortfolioBalanceAddsWell() {
    Portfolio p = new Portfolio();
    p.addAccount( accountWith10() );
    p.addAccount( new Portfolio().addAccount( accountWith10() ) );

    assertEquals( 20, p.balance() );
  }

  // cuentas sin repetir
  @Test void testPortfolioFailsAfterAddingAnAccountTwiceIndirectlyAlone() {
    Account anAccount = accountWith10();
    Portfolio a = new Portfolio().addAccount( anAccount );
    Portfolio b = new Portfolio().addAccount( a );
    
    assertThrows( RuntimeException.class, () -> b.addAccount( anAccount ) );

    assertEquals( 10, a.balance() );
  }

  @Test void testPortfolioFailsAfterAddingAnAccountTwiceIndirectlyInPortfolio() {
    Account anAccount = accountWith10();
    Portfolio a = new Portfolio().addAccount( anAccount );
    Portfolio b = new Portfolio().addAccount( anAccount );
    
    assertThrows( RuntimeException.class, () -> b.addAccount( a ) );

    assertEquals( 10, a.balance() );
  }

  @Test void testPortfolioFailsAfterAddingAnAccountTwiceIndirectlyInOtherBranch() {
    Account anAccount = accountWith10();
    Portfolio a = new Portfolio().addAccount( anAccount );
    Portfolio b = new Portfolio().addAccount( anAccount );
    
    assertThrows( RuntimeException.class, () -> new Portfolio().addAccount( a ).addAccount( b ) );

    assertEquals( 10, a.balance() );
  }
  
  // reportes:
  @Test void testReportPortfolioAfterADeposit() {
    assertEquals( "Portfolio:\n" +  
                  "  Cuenta:\n" +  
                  "    Deposit: 10\n" + 
                  "  Balance: 10", new Portfolio().addAccount( accountWith10() ).report() );
  }
 
  @Test void testReportPortfolioComplex() {
    assertEquals( "Portfolio:\n" +  
                  "  Portfolio:\n" +  
                  "    Cuenta:\n" +  
                  "      Deposit: 10\n" + 
                  "    Balance: 10\n" +
                  "  Cuenta:\n" + 
                  "    Deposit: 10\n" + 
                  "  Balance: 10\n" +
                  "  Portfolio:\n" +  
                  "    Cuenta:\n" +  
                  "      Deposit: 10\n" + 
                  "    Balance: 10", 
                  new Portfolio().addAccount( new Portfolio().addAccount( accountWith10() ) )
                                 .addAccount( accountWith10() )
                                 .addAccount( new Portfolio().addAccount( accountWith10() ) ).report() );
  }
   
 
  private Account accountWith10() {
    return new Account().deposit( 10 );
  }


  
}
