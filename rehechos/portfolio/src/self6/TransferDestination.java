package self6;

public class TransferDestination  extends TransferTransaction{

  public TransferDestination( Transfer transfer ) {
    super( transfer );
  }
  
  public TransferOrigin origin() {
    return transfer.origin();
  }

  public int valueForBalance() {
    return value();
  }

  public String reportDetail() {
    return "Depósito por transferencia de: " + value();
  }

  @Override
  public void reportOn(SummaryTreeReport summaryTreeReport) {
    summaryTreeReport.reportMeAsADestination(this);
  }

}
