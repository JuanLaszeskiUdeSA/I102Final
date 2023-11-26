package portfolio6a;

public class Deposit extends Transaction {

  public Deposit( int value ) {
    super( value );
  }

  public int valueForBalance() {
    return value;
  }

  @Override
  public String visitOn(SummaryTreeReport report) {
    return report.visitDeposit(this);
  }

}
