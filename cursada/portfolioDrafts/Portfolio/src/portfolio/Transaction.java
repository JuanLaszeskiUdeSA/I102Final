package portfolio;

public abstract class Transaction {
    private int value;

    public Transaction(int value) {this.value = value;}

    public int value() {return value;}

    public abstract int valueForBalance();
    public abstract String report();
}