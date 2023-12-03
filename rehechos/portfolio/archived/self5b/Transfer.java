package self5b;

public class Transfer {
    private int value;
    private TransferWithdraw origin;
    private TransferDeposit destination;



    public Transfer(int value) {
        if (value <= 0) {
            throw new IllegalArgumentException("Value must be positive");
        }
        this.value = value;
        this.origin = new TransferWithdraw(this);
        this.destination = new TransferDeposit(this);

    }

    public static Transfer register(int anAmmount, Account originAccount, Account destinationAccount) {
        Transfer transfer = new Transfer(anAmmount);
        originAccount.register(transfer.origin());
        destinationAccount.register(transfer.destination());
        return transfer;
    }

    public int value() {
        return value;
    }

    public TransferWithdraw origin() {
        return origin;
    }
    public TransferDeposit destination() {
        return destination;
    }
}
