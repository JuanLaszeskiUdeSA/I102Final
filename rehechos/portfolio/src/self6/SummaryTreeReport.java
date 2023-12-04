package self6;

import java.util.List;
import java.util.ArrayList;

public class SummaryTreeReport {
    private List<String> report = new ArrayList();
    private String prefix = "";

    public static String report(Accountable accountable) {
        return new SummaryTreeReport().list(accountable);
    }

    public String list(Accountable accountable) {
        accountable.reportOn(this);
        return String.join("\n", report);
    }

    public void reportMeAsAnAccount(Account anAccount) {
        report.add(prefix + anAccount.title());
        anAccount.transactions().forEach((transaction) -> {
            String oldPrefix = prefix;
            prefix = prefix + "  ";
            transaction.reportOn(this);
            prefix = oldPrefix;
        });
        report.add(prefix + anAccount.footer());
    }

    public void reportMeAsAPortfolio(Portfolio aPortfolio) {
        report.add(prefix + aPortfolio.title());

        aPortfolio.accounts.forEach((accountable) -> {
            String oldPrefix = prefix;
            prefix = prefix + "  ";
            accountable.reportOn(this);
            prefix = oldPrefix;
        });

        report.add(prefix + aPortfolio.footer());
    }

    public void reportMeAsADeposit(Deposit aDeposit) {
        report.add(prefix + aDeposit.reportDetail());
    }

    public void reportMeAsAWithdraw(Withdraw aWithdraw) {
        report.add(prefix + aWithdraw.reportDetail());
    }

    public void reportMeAsADestination(TransferDestination aTransferDestination) {
        report.add(prefix + aTransferDestination.reportDetail());
    }

    public void reportMeAsAnOrigin(TransferOrigin aTransferOrigin) {
        report.add(prefix + aTransferOrigin.reportDetail());
    }

}
