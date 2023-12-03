package portfolio3;

public class Transaction {
  private int value;
  private char type;

  static public Transaction deposit( int value ) { return new Transaction( 'D', value );  }
  static public Transaction withdraw( int value ) { return new Transaction( 'W', value );  }

  public Transaction( char type, int value ) {
    this.type = type;
    this.value = value;
  }
  
  public boolean isDeposit() {
    return type == 'D'; 
  }
  
  public int value() {
    return value;
  }
  
  public int valueForBalance() {
    return type == 'D' ? value : (value * -1);
  }
  
  public String reportDetail() {
    return ( type == 'D' ? "Deposit: " : "Withdraw: " ) + value;
  }
  

}
