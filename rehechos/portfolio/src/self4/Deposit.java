package self4;

public class Deposit extends Transaction{
    public Deposit(int value) {
        super(value);
    }

    @Override
    public int valueForBalance() {
        return value();
    }

    @Override
    public String reportDetail() {
        return "Deposit: " + value();
    }
}
