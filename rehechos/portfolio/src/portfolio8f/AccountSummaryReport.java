package portfolio8f;

public class AccountSummaryReport extends ReportVisitor{

    public static String report( Accountable anAccount ) {
        AccountSummaryReport report = new AccountSummaryReport();
        return report.list( anAccount );
    }

    public void visitPortfolio(Portfolio target) {}

    public void visitAccount(Account target) {
        report.add("Resumen de Cuenta:");
        target.visitTransactionsOn(this);
        report.add("Balance: " + target.balance());
    }

    public void visitDeposit(Deposit deposit) {
        report.add("Deposito por: " + deposit.value());
    }

    public void visitWithdraw(Withdraw withdraw) {
        report.add("Extracción por: " + withdraw.value());

    }

    public void visitTransferDestination(TransferDestination transferDestination) {
        report.add("Entrada por transferencia de: " + transferDestination.value());
    }

    public void visitTransferOrigin(TransferOrigin transferOrigin) {
        report.add("Salida por transferencia de: " + transferOrigin.value());

    }
}
