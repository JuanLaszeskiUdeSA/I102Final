package codigorepetido;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;

public class CustomerBookTest {

  @Test public void testAddingCustomerShouldNotTakeMoreThan50Milliseconds() {
    CustomerBook customerBook = new CustomerBook();
    
    long millisecondsBeforeRunning = System.currentTimeMillis();
    customerBook.addCustomerNamed( "John Lennon" );
    long millisecondsAfterRunning = System.currentTimeMillis();
    
    assertTrue( millisecondsAfterRunning - millisecondsBeforeRunning < 50 );
  }

  @Test public void testRemovingCustomerShouldNotTakeMoreThan100Milliseconds() {
    CustomerBook customerBook = new CustomerBook();
    String paulMcCartney = "Paul McCartney";
    customerBook.addCustomerNamed( paulMcCartney );
    
    long millisecondsBeforeRunning = System.currentTimeMillis();
    customerBook.removeCustomerNamed( paulMcCartney );
    long millisecondsAfterRunning = System.currentTimeMillis();
    
    assertTrue( millisecondsAfterRunning - millisecondsBeforeRunning < 100 );
  }

  @Test public void testCanNotAddACustomerWithEmptyName() {
    CustomerBook customerBook = new CustomerBook();
    
    try {
      customerBook.addCustomerNamed( "" );
      fail( "Expected an Error to be thrown" );
    } catch (Exception e) {
      assertEquals( "customer name cannot be empty!!!!!!", e.getMessage() );
      assertTrue( customerBook.isEmpty() );
    }
  }

  @Test public void testCanNotRemoveAnInvalidCustomer() {
    CustomerBook customerBook = new CustomerBook();
    String johnLennon = "John Lennon";
    customerBook.addCustomerNamed( johnLennon );
    
    try {
      customerBook.removeCustomerNamed( "Paul McCartney" );
      fail( "Expected a NotFound exception to be thrown" );
    } catch (Exception e) {
      assertEquals( "Customer not found", e.getMessage() );
      assertEquals( 1, customerBook.numberOfCustomers() );
      assertTrue( customerBook.includesCustomerNamed( johnLennon ) );
    }
  }

  @Test public void testSuspendingACustomerShouldNotRemoveItFromCustomerBook() {
    CustomerBook customerBook = new CustomerBook();
    String paulMcCartney = "Paul McCartney";
    customerBook.addCustomerNamed( paulMcCartney );
    customerBook.suspendCustomerNamed( paulMcCartney );
    
    assertEquals( 0, customerBook.numberOfActiveCustomers() );
    assertEquals( 1, customerBook.numberOfSuspendedCustomers() );
    assertEquals( 1, customerBook.numberOfCustomers() );
    assertTrue( customerBook.includesCustomerNamed( paulMcCartney ) );
  }

  @Test public void testRemovingASuspendedCustomerShouldRemoveItFromCustomerBook() {
    CustomerBook customerBook = new CustomerBook();
    String paulMcCartney = "Paul McCartney";
    customerBook.addCustomerNamed( paulMcCartney );
    customerBook.suspendCustomerNamed( paulMcCartney );
    customerBook.removeCustomerNamed( paulMcCartney );
    
    assertEquals( 0, customerBook.numberOfActiveCustomers() );
    assertEquals( 0, customerBook.numberOfSuspendedCustomers() );
    assertEquals( 0, customerBook.numberOfCustomers() );
    assertFalse( customerBook.includesCustomerNamed( paulMcCartney ) );
  }

  @Test public void testAddingNewCustomerDoesAffectSuspendedStatus() {
    CustomerBook customerBook = new CustomerBook();
    String paulMcCartney = "Paul McCartney";
    String ringoStar = "Ringo Star";
    customerBook.addCustomerNamed( paulMcCartney );
    customerBook.suspendCustomerNamed( paulMcCartney );
    customerBook.addCustomerNamed( ringoStar );
    
    assertEquals( 1, customerBook.numberOfActiveCustomers() );
    assertEquals( 1, customerBook.numberOfSuspendedCustomers() );
    assertEquals( 2, customerBook.numberOfCustomers() );
    assertTrue( customerBook.includesCustomerNamed( paulMcCartney ) );
  }

  @Test public void testCanNotSuspendAnInvalidCustomer() {
    CustomerBook customerBook = new CustomerBook();
    String johnLennon = "John Lennon";
    customerBook.addCustomerNamed( johnLennon );
    
    try {
      customerBook.suspendCustomerNamed( "George Harrison" );
      fail( "Expected a CantSuspend exception to be thrown" );
    } catch (Exception e) {
      assertEquals( "Cannot suspend customer", e.getMessage() );
      assertEquals( 1, customerBook.numberOfCustomers() );
      assertTrue( customerBook.includesCustomerNamed( johnLennon ) );
    }
  }

  @Test public void testCanNotSuspendAnAlreadySuspendedCustomer() {
    CustomerBook customerBook = new CustomerBook();
    String johnLennon = "John Lennon";
    customerBook.addCustomerNamed( johnLennon );
    customerBook.suspendCustomerNamed( johnLennon );

    try {
      customerBook.suspendCustomerNamed( johnLennon );
      fail( "Expected a CantSuspend exception to be thrown" );
    } catch (Exception e) {
      assertEquals(  "Cannot suspend customer", e.getMessage() );
      assertEquals( 1, customerBook.numberOfCustomers() );
      assertTrue( customerBook.includesCustomerNamed( johnLennon ) );
    }
  }
}