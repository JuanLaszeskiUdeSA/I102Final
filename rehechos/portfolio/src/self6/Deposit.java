package self6;

public class Deposit extends Transaction {

  public Deposit( int value ) {
    super( value );
  }

  public int valueForBalance() {
    return value;
  }

  public String reportDetail() {
    return "Deposit: " + value;
  }

  @Override
  public void reportOn(SummaryTreeReport summaryTreeReport) {
    summaryTreeReport.reportMeAsADeposit(this);
  }

}
