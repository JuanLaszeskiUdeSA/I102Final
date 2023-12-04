package portfolio8;


public class NetoReport extends ReportVisitor {
    private String prefix = "";
    private int ingresos = 0;
    private int egresos = 0;

    public void title(){report.add("Neto de Transferencias:");}

    public void footer(){
        report.add("Salida por transferencias: " + egresos + ".");
        report.add("Ingreso por transferencias: " + ingresos + ".");
        report.add("Neto de transferencias: " + (ingresos - egresos) + ".");
    }
    public static String report( Accountable anAccount ) {
        NetoReport report = new NetoReport();
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
    }

    public void visitDeposit( Deposit deposit ) {

    }

    public void visitWithdraw( Withdraw withdraw ) {

    }

    public void visitTransferDestination( TransferDestination transferDestination ) {
        ingresos = ingresos + transferDestination.value();
    }
    public void visitTransferOrigin( TransferOrigin transferOrigin ) {
        egresos = egresos + transferOrigin.value();
    }

}

