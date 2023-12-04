package portfolio8c;

public abstract class TransferTransaction extends Transaction {
  protected Transfer transfer;

  public TransferTransaction( Transfer transfer ) {
    this.transfer = transfer;
  }

  public int value() {
    return transfer.value();
  }

}
