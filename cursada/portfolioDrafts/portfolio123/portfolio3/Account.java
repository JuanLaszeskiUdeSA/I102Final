package portfolio3;

import java.util.ArrayList;
import java.util.List;

public class Account {
  private List<Transaction> transactions = new ArrayList<>();
  
  public int balance() {
    return transactions.stream()
        .map(Transaction::valueForBalance)
        .reduce(0, Integer::sum);
  }

  public Account deposit( int anAmount ) {
    transactions.add( Deposit.deposit( anAmount ) );
    return this;
  }

  public Account withdraw( int anAmount ) {
    if (balance() - anAmount < 0) {
      throw new RuntimeException( "not enough money in the account" );
    }
    
    transactions.add( Withdraw.withdraw( anAmount ) );
    return this;
  }

  public String report() {
    List<String> report = new ArrayList<>();
        
    transactions.forEach( (transaction) -> {
      report.add( transaction.reportDetail() );
    });
    
    report.add( "Balance: " + balance() );
    
    return String.join("\n", report);
  }
}