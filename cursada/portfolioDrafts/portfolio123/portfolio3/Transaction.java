package portfolio3;

public abstract class Transaction {
  private int value;

  public Transaction(int value ) {this.value = value;}

  public int value() {return value;}

  public abstract int valueForBalance();
  public abstract String reportDetail();
}
