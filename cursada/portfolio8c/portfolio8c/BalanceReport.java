package portfolio8;


public class BalanceReport extends ReportVisitor {
    private String prefix = "";

    public static String report( Accountable anAccount ) {
        BalanceReport report = new BalanceReport();
        return report.list( anAccount );
    }

    public void visitPortfolio( Portfolio target ) {
        report.add( prefix + "Portfolio: " + target.balance());
        String oldPrefix = prefix;
        prefix = prefix + "  ";
        target.visitAccountsOn( this );
        prefix = oldPrefix;
    }

    public void visitAccount( Account target ) {
        report.add( prefix + "Cuenta: " + target.balance());
    }

    @Override
    public void visitDeposit(Deposit deposit) {

    }

    @Override
    public void visitWithdraw(Withdraw withdraw) {

    }

    @Override
    public void visitTransferDestination(TransferDestination transferDestination) {

    }

    @Override
    public void visitTransferOrigin(TransferOrigin transferOrigin) {

    }
}
