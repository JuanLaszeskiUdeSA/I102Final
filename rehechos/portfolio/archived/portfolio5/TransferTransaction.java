package self6a;

public class TransferTransaction extends Transaction {
  protected Transfer transfer;
  
  public TransferTransaction( Transfer aTransfer ) {
    super( aTransfer.value() );
    transfer = aTransfer;
  }

  public int valueForBalance() {
    // TODO Auto-generated method stub
    return 0;
  }

  public String reportDetail() {
    // TODO Auto-generated method stub
    return null;
  }

}
