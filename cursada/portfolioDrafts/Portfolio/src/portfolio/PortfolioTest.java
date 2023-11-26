package portfolio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class PortfolioTest {


    @Test void testBalanceOnNewAccount() {assertEquals(0, new Account().balance());}

    @Test void testBalanceAfterDeposit() {
        assertEquals(10, accountWith10().balance());
    }

    @Test void testBalanceAfterDepositAndThenWithdraw() {
        assertEquals(5, accountWith10().withdraw(5).balance());
    }

    @Test void testCannotWithdrawMoreThanBalance() {
        assertThrows(RuntimeException.class, () -> new Account().withdraw(1));
    }

    @Test void testCannotWithdrawMoreThanBalanceAfterDeposit() {
        assertThrows(RuntimeException.class, () -> accountWith10().withdraw(11));
    }

    @Test void testReportAfterADeposit() {
        assertEquals( "Cuenta:\n" +
                "\tDeposit: 10", accountWith10().report() );
    }

    @Test void testReportAfterAWithdraw() {
        Account account = new Account();
        account.deposit( 10 )
                .withdraw( 5 );
        assertEquals( "Cuenta:\n" +
                "\tDeposit: 10\n" +
                "\tWithdraw: 5", account.report() );
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
                "\tCuenta:\n" +
                "\t\tDeposit: 10", new Portfolio().addAccount( accountWith10() ).report() );
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
                new Portfolio().addAccount( new Portfolio().addAccount( accountWith10() ) )
                        .addAccount( accountWith10() )
                        .addAccount( new Portfolio().addAccount( accountWith10() ) ).report() );
    }

    //Tranferencias entre cuentas
    @Test void testCeroTransferThrowsError() {
        assertThrows( RuntimeException.class, () -> Transfer.debitTransfer( accountWith10(), accountWith10(), 0 ) );
    }

    @Test void testNegativeTransferThrowsError(){
        assertThrows( RuntimeException.class, () -> Transfer.debitTransfer(accountWith10(), accountWith10(), -1 ) );
    }

    @Test void testTransferBetweenTwoAccountWith10() {
        Account account1 = new Account().deposit( 10 );
        Account account2 = new Account().deposit( 10 );

        Transfer.debitTransfer(account1, account2, 5);

        assertEquals( 5, account1.balance() );
        assertEquals( 15, account2.balance() );
    }
    private Account accountWith10() {
        return new Account().deposit( 10 );
    }

}