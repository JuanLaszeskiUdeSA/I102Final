package portfolio6a;

public abstract class Transaction {
  protected int value;

  public Transaction() {
  }
  public Transaction( int value ) {
    this.value = value;
  }
  
  public abstract int valueForBalance();

  public abstract String header();
  
  public int value() {
    return value;
  }
  public void reportOn(SummaryTreeReport report) {
    report.reportAsDetail(this.header(), this.value());
  }
}
