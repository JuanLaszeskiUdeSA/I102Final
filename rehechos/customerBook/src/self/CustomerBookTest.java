package self;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerBookTest {

  private static String PaulMcCartney = "Paul McCartney";
  private static String JohnLennon = "John Lennon";

  @BeforeEach
    public void setUp() {
    customerBook = new CustomerBook();
    }

  @Test public void testAddingCustomerShouldNotTakeMoreThan50Milliseconds() {
    ensureTakesLessThanMilliseconds(() -> customerBook.addCustomerNamed( JohnLennon), 50);
  }

  @Test public void testRemovingCustomerShouldNotTakeMoreThan100Milliseconds() {
    customerBook.addCustomerNamed( PaulMcCartney );
    
    ensureTakesLessThanMilliseconds(() -> customerBook.removeCustomerNamed( PaulMcCartney ), 100);
  }

  @Test public void testCanNotAddACustomerWithEmptyName() {
    CustomerBook customerBook = new CustomerBook();
    
    /*try {
      customerBook.addCustomerNamed( "" );
      fail( "Expected an Error to be thrown" );
    } catch (Exception e) {
      assertEquals(CustomerNameCannotBeEmpty, e.getMessage() );

    }*/
    assertThrowsLike(() -> customerBook.addCustomerNamed( "" ), CustomerBook.CustomerNameCannotBeEmpty);
    assertTrue( customerBook.isEmpty() );


  }

  @Test public void testCanNotRemoveAnInvalidCustomer() {
    customerBook.addCustomerNamed( JohnLennon );
    
    /*try {
      customerBook.removeCustomerNamed( "Paul McCartney" );
      fail( "Expected a NotFound exception to be thrown" );
    } catch (Exception e) {
      assertEquals( "Customer not found", e.getMessage() );
    }*/
    assertThrowsLike(() -> customerBook.removeCustomerNamed( PaulMcCartney ), CustomerBook.CustomerNotFound);
    assertEquals( 1, customerBook.numberOfCustomers() );
    assertTrue( customerBook.includesCustomerNamed( JohnLennon ) );
  }

  @Test public void testSuspendingACustomerShouldNotRemoveItFromCustomerBook() {
    customerBook.addCustomerNamed( PaulMcCartney );
    customerBook.suspendCustomerNamed( PaulMcCartney );
    assertNumberOfCustomersTypes( 0, 1, 1 );
    assertTrue( customerBook.includesCustomerNamed( PaulMcCartney ) );
  }

  @Test public void testRemovingASuspendedCustomerShouldRemoveItFromCustomerBook() {
    customerBook.addCustomerNamed( PaulMcCartney );
    customerBook.suspendCustomerNamed( PaulMcCartney );
    customerBook.removeCustomerNamed( PaulMcCartney );
    
    assertNumberOfCustomersTypes( 0, 0, 0 );
    assertFalse( customerBook.includesCustomerNamed( PaulMcCartney ) );
  }

  @Test public void testAddingNewCustomerDoesAffectSuspendedStatus() {
    customerBook.addCustomerNamed( PaulMcCartney );
    customerBook.suspendCustomerNamed( PaulMcCartney );
    customerBook.addCustomerNamed( "Ringo Star" );
    
    assertNumberOfCustomersTypes( 1, 1, 2 );
    assertTrue( customerBook.includesCustomerNamed( PaulMcCartney ) );
  }

  @Test public void testCanNotSuspendAnInvalidCustomer() {
    customerBook.addCustomerNamed( JohnLennon );
    
    /*try {
      customerBook.suspendCustomerNamed( "George Harrison" );
      fail( "Expected a CantSuspend exception to be thrown" );
    } catch (Exception e) {
      assertEquals( "Cannot suspend customer", e.getMessage() );
      assertEquals( 1, customerBook.numberOfCustomers() );
      assertTrue( customerBook.includesCustomerNamed( johnLennon ) );
    }*/
    assertThrowsLike(() -> customerBook.suspendCustomerNamed( "George Harrison" ), CustomerBook.CannotSuspendCustomer);
    assertEquals( 1, customerBook.numberOfCustomers() );
    assertTrue( customerBook.includesCustomerNamed( JohnLennon ) );
  }

  @Test public void testCanNotSuspendAnAlreadySuspendedCustomer() {
    customerBook.addCustomerNamed( JohnLennon );
    customerBook.suspendCustomerNamed( JohnLennon );

    /*try {
      customerBook.suspendCustomerNamed( johnLennon );
      fail( "Expected a CantSuspend exception to be thrown" );
    } catch (Exception e) {
      assertEquals(  "Cannot suspend customer", e.getMessage() );
      assertEquals( 1, customerBook.numberOfCustomers() );
      assertTrue( customerBook.includesCustomerNamed( johnLennon ) );
    }*/
    assertThrowsLike(() -> customerBook.suspendCustomerNamed( JohnLennon ), CustomerBook.CannotSuspendCustomer);
    assertEquals( 1, customerBook.numberOfCustomers() );
    assertTrue( customerBook.includesCustomerNamed( JohnLennon ) );
  }

  private void assertThrowsLike(Executable executable, String message) {
    assertEquals(message, assertThrows(Exception.class, executable).getMessage());
  }

  private void ensureTakesLessThanMilliseconds(Runnable toRun, int milliseconds) {
    long millisecondsBeforeRunning = System.currentTimeMillis();
    toRun.run();
    long millisecondsAfterRunning = System.currentTimeMillis();
    assertTrue( millisecondsAfterRunning - millisecondsBeforeRunning < milliseconds );
  }

  private void assertNumberOfCustomersTypes(int active, int suspended, int total) {
    assertEquals( active, customerBook.numberOfActiveCustomers() );
    assertEquals( suspended, customerBook.numberOfSuspendedCustomers() );
    assertEquals( total, customerBook.numberOfCustomers() );
  }

  private CustomerBook customerBook;
}