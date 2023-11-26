package portfolio6;

import java.util.ArrayList;
import java.util.List;

public class SummaryTreeReport {
    private List<String> report = new ArrayList();
    private Accountable accountable;
    private String prefix = "";
    public SummaryTreeReport(Accountable anAccountable) {
        this.accountable = anAccountable;
        if (anAccountable instanceof Account) {

            ((Account) anAccountable).transactions().forEach( (transaction) -> {
                report.add( prefix + "  " + transaction.reportDetail() );
            });
        }
        else if (anAccountable instanceof Portfolio) {
            ((Portfolio) anAccountable).getAccounts().forEach( (accountable) -> {
                report.add( accountable.report( prefix + "  ") );
            });
        }
    }

    public String report() {
        return report( "" );
    }

    /*public String report( String prefix ) {
        report.add( prefix + accountable.title() );
        *//*if (accountable instanceof Account) {

            ((Account) accountable).transactions().forEach( (transaction) -> {
                report.add( prefix + "  " + transaction.reportDetail() );
            });
        }
        else if (accountable instanceof Portfolio) {
            ((Portfolio) accountable).getAccounts().forEach( (accountable) -> {
                report.add( new SummaryTreeReport(accountable).report( prefix + "  ") );
            });
        }*//*
        accountable.accountsToReport().forEach( (accountable) -> {
            report.add( new SummaryTreeReport(accountable).report( prefix + "  ") );
        });
        return String.join("\n", report) + "\n" + prefix + accountable.endTitle();
    }*/
}
