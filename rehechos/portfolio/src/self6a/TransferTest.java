package self6a;

import org.junit.jupiter.api.Test;
import portfolio6a.Account;
import portfolio6a.Transfer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TransferTest {

  @Test void testValueOfTransfer() {
    portfolio6a.Transfer transfer = transferOf( 10 );
    assertEquals( 10, transfer.value() );
  }
  
  @Test void testValueOfTransferShouldBePositive() {
    assertThrows( RuntimeException.class, () -> transferOf( 0 ) );
  }

  @Test void testValueOfOriginIsTransferValue() {
    portfolio6a.Transfer transfer = transferOf( 10 );
    assertEquals( transfer.value(), transfer.origin().value() );
  }

  @Test void testValueOfDestinationIsTransferValue() {
    portfolio6a.Transfer transfer = transferOf( 10 );
    assertEquals( transfer.value(), transfer.destination().value() );
  }

  @Test void testOriginIsDestinationOrigin() {
    portfolio6a.Transfer transfer = transferOf( 10 );
    assertEquals( transfer.origin(), transfer.destination().origin() );
  }
  
  @Test void testDestinationIsOriginDestination() {
    portfolio6a.Transfer transfer = transferOf( 10 );
    assertEquals( transfer.destination(), transfer.origin().destination() );
  }
 
  @Test void testTransferRegistry() {
    portfolio6a.Account anAccount = accountWith10();
    portfolio6a.Account anotherAccount = accountWith10();
    
    transferRegister( 10, anAccount, anotherAccount );
    assertEquals( 0, anAccount.balance() );
    assertEquals( 20, anotherAccount.balance() );
  }
   
  private portfolio6a.Transfer transferRegister(int anAmmount, portfolio6a.Account originAccount, portfolio6a.Account destinationAccount ) {
    return portfolio6a.Transfer.register( anAmmount, originAccount, destinationAccount );
  }

  private portfolio6a.Transfer transferOf(int anAmmount ) {
    return new Transfer( anAmmount );
  }

  private portfolio6a.Account accountWith10() {
    return new Account().deposit( 10 );
  }


  
}
