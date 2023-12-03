package self4;

public class Withdraw extends Transaction{

    public Withdraw(int value) {
        super(value);
    }

    @Override
    public int valueForBalance() {
        return value() * -1;
    }

    @Override
    public String reportDetail() {
        return "Withdraw: " + value();
    }
}
