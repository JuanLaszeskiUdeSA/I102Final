package portfolio8f;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BalanceReport extends ReportVisitor {
    private String prefix = "";
    public static String report( Accountable anAccount ) {
        BalanceReport report = new BalanceReport();
        return report.list( anAccount );
    }

    public void visitPortfolio(Portfolio target) {
        if (report.isEmpty()) {
            report.add( "Reporte de balances:" );
        }

        report.add( prefix + "Portfolio " + target.balance() );
        String oldPrefix = prefix;
        prefix = prefix + "  ";
        target.visitAccountsOn( this );
        prefix = oldPrefix;

    }

    public void visitAccount(Account target) {
        report.add( prefix + "Cuenta " + target.balance() );

    }

    public void visitDeposit(Deposit deposit) {

    }

    public void visitWithdraw(Withdraw withdraw) {

    }

    public void visitTransferDestination(TransferDestination transferDestination) {

    }

    public void visitTransferOrigin(TransferOrigin transferOrigin) {

    }
}
