package portfolio6a;

public abstract class Transaction {
  protected int value;

  public Transaction() {
  }
  public Transaction( int value ) {
    this.value = value;
  }
  
  public abstract int valueForBalance();
  
  public int value() {
    return value;
  }

    public abstract String visitOn(SummaryTreeReport report);
}
