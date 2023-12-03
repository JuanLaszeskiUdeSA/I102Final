package self5b;

public class TransferWithdraw extends TransferTransaction{
    public TransferWithdraw(Transfer transfer) {
        super(transfer);
    }

    @Override
    public int valueForBalance() {
        return -value;
    }

    @Override
    public String reportDetail() {
        return "Débito por transferencia de: " + value;
    }
}
