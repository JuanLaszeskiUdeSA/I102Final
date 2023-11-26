package portfolio6a;

public class Deposit extends Transaction {

  public Deposit( int value ) {
    super( value );
  }

  public int valueForBalance() {
    return value;
  }

  public String header() {return "Deposit: ";}

}
