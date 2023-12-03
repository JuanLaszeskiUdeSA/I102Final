package portfolio5;

public class TransferDeposit extends TransferTransaction {

  public TransferDeposit( Transfer aTransfer ) {
    super( aTransfer );
  }

  public TransferWithdraw origin() {
    return transfer.origin();
  }


  public int valueForBalance() {
    // TODO Auto-generated method stub
    return transfer.value();
  }
}
