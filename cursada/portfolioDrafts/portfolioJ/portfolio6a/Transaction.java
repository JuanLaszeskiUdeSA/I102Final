package portfolio6a;

public abstract class Transaction {
  protected int value;

  public Transaction() {
  }
  public Transaction( int value ) {
    this.value = value;
  }
  
  public abstract int valueForBalance();
  public abstract String reportDetailOn();
  
  public int value() {
    return value;
  }
  
}
