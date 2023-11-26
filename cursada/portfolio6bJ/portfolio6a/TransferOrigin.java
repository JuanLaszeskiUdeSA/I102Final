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

  public String header() {
    return "Débito por transferencia de: ";
  }


}
