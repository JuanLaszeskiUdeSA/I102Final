package portfolio6a;

public class Withdraw extends Transaction {

  public Withdraw( int value ) {
    super( value );
  }

  public int valueForBalance() {
    return value * -1;
  }

  @Override
  public String visitOn(SummaryTreeReport report) {
    return report.visitWithdraw(this);
  }

}
