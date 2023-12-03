package self6a;

public class TransferWithdraw extends TransferTransaction {

  public TransferWithdraw( Transfer aTransfer ) {
    super( aTransfer );
  }

  public TransferDeposit destination() {
    return transfer.destination();
  }

  public int valueForBalance() {
    // TODO Auto-generated method stub
    return transfer.value() * -1;
  }
}
