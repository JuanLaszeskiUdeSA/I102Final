package portfolio8c;


public class AccountSummary extends ReportVisitor {
    private String prefix = "";

    public void title(){report.add("Resumen de Cuenta: ");}

    public static String report( Accountable anAccount ) {
        AccountSummary report = new AccountSummary();
        return report.list( anAccount );
    }

    public void visitPortfolio( Portfolio target ) {
        String oldPrefix = prefix;
        prefix = prefix + "  ";
        target.visitAccountsOn( this );
        prefix = oldPrefix;
    }

    public void visitAccount( Account target ) {
        target.visitTransactionsOn( this );
        report.add( prefix + "Balance = " + target.balance());
    }

    public void visitDeposit( Deposit deposit ) {
        report.add("Depósito por " + deposit.value() + ".");
    }

    public void visitWithdraw( Withdraw withdraw ) {
        report.add("Extracción por " + withdraw.value() + "." );
    }

    public void visitTransferDestination( TransferDestination transferDestination ) {
        report.add("Depósito por transferencia de: " + transferDestination.value()+ "." );
    }
    public void visitTransferOrigin( TransferOrigin transferOrigin ) {
        report.add("Débito por transferencia de: " + transferOrigin.value()+ "." );
    }

}

