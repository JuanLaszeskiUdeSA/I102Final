package portfolio8f;

public class Withdraw extends Transaction {

  public Withdraw( int value ) {
    super( value );
  }

  public int valueForBalance() {
    return value * -1;
  }

  public void accept( PortfolioVisitor visitor ) {
    visitor.visitWithdraw( this );
  }

}
