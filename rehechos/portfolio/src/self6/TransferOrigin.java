package self6;

public class TransferOrigin extends TransferTransaction {

  public TransferOrigin( Transfer transfer ) {
    super( transfer );
  }
  
  public TransferTransaction destination() {
    return transfer.destination();
  }

  public int valueForBalance() {
    return - value();
  }

  public String reportDetail() {
    return "Débito por transferencia de: " + value();
  }

  @Override
  public void reportOn(SummaryTreeReport summaryTreeReport) {
    summaryTreeReport.reportMeAsAnOrigin(this);
  }


}
