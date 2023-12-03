package self6a;

import java.util.List;
import java.util.ArrayList;

public class SummaryTreeReport {
    private List<String> report = new ArrayList();
    private String prefix = "";

    public SummaryTreeReport(Accountable accountable) {

        if (accountable.getClass().equals(Account.class)) {
            report.add(prefix + accountable.title());
            ((Account)accountable).transactions().forEach((transaction) -> {
                report.add(prefix + "  " + transaction.reportDetail());
            });
            report.add(prefix + "Balance: " + accountable.balance());
        } else {
            report.add(prefix + "Portfolio:");
            (accountable).accounts().forEach((accountable1) -> {
                report.add(accountable1.report(prefix + "  "));
            });
            report.add(prefix + "Balance: " + accountable.balance());
        }

    }

    public String report() {
        return String.join("\n", report);
    }
}
