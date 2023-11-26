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


  public String reportDetailOn() {
    return "Depósito por transferencia de: " + value();
  }



}
