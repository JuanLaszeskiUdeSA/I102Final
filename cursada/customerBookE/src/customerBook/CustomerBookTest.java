package customerBook;

import static org.junit.jupiter.api.Assertions.assertEquals; 
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class CustomerBookTest {

  @Test public void testAddingCustomerShouldNotTakeMoreThan50Milliseconds() {
    ensureTakesLesThanMilliseconds( () ->  new CustomerBook().addCustomerNamed( "John Lennon" ), 50 );
  }

  @Test public void testRemovingCustomerShouldNotTakeMoreThan100Milliseconds() {
    String paulMcCartney = "Paul McCartney";
    ensureTakesLesThanMilliseconds( () -> customerBookWith( paulMcCartney ).removeCustomerNamed( paulMcCartney ), 100 );
  }

  @Test public void testCanNotAddACustomerWithEmptyName() {
    CustomerBook customerBook = new CustomerBook();
    
    assertThrowsLike( () -> customerBook.addCustomerNamed( "" ), CustomerBook.CustomerNameCannotBeEmpty );
    
    assertTrue( customerBook.isEmpty() );
    
  }

  private void assertThrowsLike( Executable executable, String message ) {
    
    assertEquals( message,
                  assertThrows( Exception.class, executable ).getMessage() );
  }

  @Test public void testCanNotRemoveAnInvalidCustomer() {
    String johnLennon = "John Lennon";
    CustomerBook customerBook = customerBookWith( johnLennon );
    
    assertThrowsLike( () -> customerBook.removeCustomerNamed( "Paul McCartney" ),
                      "Customer not found" );
    
    assertEquals( 1, customerBook.numberOfCustomers() );
    assertTrue( customerBook.includesCustomerNamed( johnLennon ) );
  }

  @Test public void testSuspendingACustomerShouldNotRemoveItFromCustomerBook() {
    String paulMcCartney = "Paul McCartney";
    CustomerBook customerBook = customerBookWithSuspended( paulMcCartney );
    
    ensureCustomerDistribution( 0, 1, 1, customerBook );
    assertTrue( customerBook.includesCustomerNamed( paulMcCartney ) );
  }

  @Test public void testRemovingASuspendedCustomerShouldRemoveItFromCustomerBook() {
    String paulMcCartney = "Paul McCartney";
    CustomerBook customerBook = customerBookWithSuspended( paulMcCartney );
    customerBook.removeCustomerNamed( paulMcCartney );
    
    ensureCustomerDistribution( 0, 0, 0, customerBook );
    assertFalse( customerBook.includesCustomerNamed( paulMcCartney ) );
  }

  @Test public void testAddingNewCustomerDoesAffectSuspendedStatus() {
    String paulMcCartney = "Paul McCartney";
    String ringoStar = "Ringo Star";
    CustomerBook customerBook = customerBookWithSuspended( paulMcCartney );
    customerBook.addCustomerNamed( ringoStar );
    
    ensureCustomerDistribution( 1, 1, 2, customerBook );
    assertTrue( customerBook.includesCustomerNamed( paulMcCartney ) );
  }

  @Test public void testCanNotSuspendAnInvalidCustomer() {
    String johnLennon = "John Lennon";
    CustomerBook customerBook = customerBookWith( johnLennon );    

    assertThrowsLike( () -> customerBook.suspendCustomerNamed( "George Harrison" ),
                      CustomerBook.CannotSuspend );
    assertEquals( 1, customerBook.numberOfCustomers() );
    assertTrue( customerBook.includesCustomerNamed( johnLennon ) );
  
  }

  @Test public void testCanNotSuspendAnAlreadySuspendedCustomer() {
    String johnLennon = "John Lennon";
    CustomerBook customerBook = customerBookWithSuspended( johnLennon );

    assertThrowsLike( () -> customerBook.suspendCustomerNamed( johnLennon ),
                      CustomerBook.CannotSuspend   );
    assertEquals( 1, customerBook.numberOfCustomers() );
    assertTrue( customerBook.includesCustomerNamed( johnLennon ) );
  }

  private void ensureCustomerDistribution( int active, int suspended, int total, CustomerBook customerBook ) {
    assertEquals( active, customerBook.numberOfActiveCustomers() );
    assertEquals( suspended, customerBook.numberOfSuspendedCustomers() );
    assertEquals( total, customerBook.numberOfCustomers() );
  }

  private CustomerBook customerBookWithSuspended( String johnLennon ) {
    CustomerBook customerBook = customerBookWith( johnLennon );    
    customerBook.suspendCustomerNamed( johnLennon );
    return customerBook;
  }

  private CustomerBook customerBookWith( String paulMcCartney ) {
    CustomerBook customerBook = new CustomerBook();
    customerBook.addCustomerNamed( paulMcCartney );
    return customerBook;
  }

  private void ensureTakesLesThanMilliseconds( Runnable run, int timeToMeassure ) {
    long millisecondsBeforeRunning = System.currentTimeMillis();
    run.run();
    assertTrue( System.currentTimeMillis() - millisecondsBeforeRunning < timeToMeassure );
  }

}