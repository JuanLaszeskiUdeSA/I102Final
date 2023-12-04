package portfolio8f;

public class TotalOfTransferReport extends ReportVisitor{
    private int total = 0;
    public static String report( Accountable anAccount ) {
        TotalOfTransferReport report = new TotalOfTransferReport();
        return report.list( anAccount );
    }

    public void visitPortfolio(Portfolio target) {
    }

    public void visitAccount(Account target) {
        report.add("Neto de Transferencias:");
        target.visitTransactionsOn(this);
        if (total > 0) {
            report.add("Entrada por Transferencias: " + total + "\n");
        } else {
            report.add("Salida por Transferencias: " + (-total) + "\n");
        }
    }

    public void visitDeposit(Deposit deposit) {
    }

    public void visitWithdraw(Withdraw withdraw) {
    }

    public void visitTransferDestination(TransferDestination transferDestination) {
        total += transferDestination.value();
    }

    public void visitTransferOrigin(TransferOrigin transferOrigin) {
        total -= transferOrigin.value();
    }
}
