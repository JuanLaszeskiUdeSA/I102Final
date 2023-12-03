package self5b;

public abstract class TransferTransaction extends Transaction{
    private Transfer transfer;
    public TransferTransaction(Transfer aTransfer) {
        super(aTransfer.value());
        this.transfer = aTransfer;

    }

    public TransferWithdraw origin() {
        return transfer.origin();
    }
    public TransferDeposit destination() {
        return transfer.destination();
    }
}
