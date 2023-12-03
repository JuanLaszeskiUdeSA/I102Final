package self5b;

public class TransferDeposit extends TransferTransaction{
    public TransferDeposit(Transfer transfer) {
        super(transfer);
    }

    @Override
    public int valueForBalance() {
        return value;
    }

    @Override
    public String reportDetail() {
        return "Depósito por transferencia de: " + value;
    }
}
