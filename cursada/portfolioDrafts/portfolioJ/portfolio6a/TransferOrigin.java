package portfolio6a;

import java.util.List;

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


  public String reportDetailOn() {
    return "Débito por transferencia de: " + value();
  }

}
