package portfolio6a;

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

  @Override
  public String visitOn(SummaryTreeReport report) {
    return report.visitTransferDestination(this);
  }


}
