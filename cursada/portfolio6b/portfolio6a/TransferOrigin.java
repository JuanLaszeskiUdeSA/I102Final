package portfolio6a;

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

    @Override
    public String visitOn(SummaryTreeReport report) {
        return report.visitTransferOrigin(this);
    }

}
