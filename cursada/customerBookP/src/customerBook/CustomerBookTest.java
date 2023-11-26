package customerBook;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class CustomerBookTest {

    @Test
    public void testAddingCustomerShouldNotTakeMoreThan50Milliseconds() {
        ensureTakesLessThanMilliseconds(() -> new CustomerBook().addCustomerNamed(johnLennon), 50);
    }

    @Test
    public void testRemovingCustomerShouldNotTakeMoreThan100Milliseconds() {
        ensureTakesLessThanMilliseconds(() -> customerBookWith(paulMcCartney).removeCustomerNamed(paulMcCartney), 100);
    }

    @Test
    public void testCanNotAddACustomerWithEmptyName() {
        CustomerBook customerBook = new CustomerBook();

        assertThrowsLike(() -> customerBook.addCustomerNamed(""), CustomerBook.customerNameCannotBeEmpty);

        assertTrue(customerBook.isEmpty());
    }

    @Test
    public void testCanNotRemoveAnInvalidCustomer() {
        CustomerBook customerBook = customerBookWith(johnLennon);

        assertThrowsLike(() -> customerBook.removeCustomerNamed(paulMcCartney), CustomerBook.customerNotFound);

        assertEquals(1, customerBook.numberOfCustomers());
        assertTrue(customerBook.includesCustomerNamed(johnLennon));
    }

    @Test
    public void testSuspendingACustomerShouldNotRemoveItFromCustomerBook() {
        CustomerBook customerBook = customerBookSuspended(paulMcCartney);

        assertCustomersDistribution(customerBook, 0, 1, 1);
        assertTrue(customerBook.includesCustomerNamed(paulMcCartney));
    }

    @Test
    public void testRemovingASuspendedCustomerShouldRemoveItFromCustomerBook() {
        CustomerBook customerBook = customerBookSuspended(paulMcCartney);
        customerBook.removeCustomerNamed(paulMcCartney);

        assertCustomersDistribution(customerBook, 0, 0, 0);
        assertFalse(customerBook.includesCustomerNamed(paulMcCartney));
    }

    @Test
    public void testAddingNewCustomerDoesAffectSuspendedStatus() {
        CustomerBook customerBook = customerBookSuspended(paulMcCartney);
        customerBook.addCustomerNamed("Ringo Star");

        assertCustomersDistribution(customerBook, 1, 1, 2);
        assertTrue(customerBook.includesCustomerNamed(paulMcCartney));
    }

    @Test
    public void testCanNotSuspendAnInvalidCustomer() {
        assertThrowsLike(() -> customerBookWith(johnLennon).suspendCustomerNamed("George Harrison"), CustomerBook.cannotSuspendCustomer);
    }

    @Test
    public void testCanNotSuspendAnAlreadySuspendedCustomer() {
        CustomerBook customerBook = customerBookSuspended(johnLennon);

        assertThrowsLike(() -> customerBook.suspendCustomerNamed(johnLennon), CustomerBook.cannotSuspendCustomer);
    }

    private static String paulMcCartney = "Paul McCartney";
    private static String johnLennon = "John Lennon";

    private CustomerBook customerBookWith(String aCustomerName) {
        CustomerBook customerBook = new CustomerBook();
        customerBook.addCustomerNamed(aCustomerName);
        return customerBook;
    }

    private CustomerBook customerBookSuspended(String aCustomerName) {
        CustomerBook customerBook = customerBookWith(aCustomerName);
        customerBook.suspendCustomerNamed(aCustomerName);
        return customerBook;
    }

    private void ensureTakesLessThanMilliseconds(Runnable toBeRun, int timeToMeassure) {
        long millisecondsBeforeRunning = System.currentTimeMillis();
        toBeRun.run();
        assertTrue(System.currentTimeMillis() - millisecondsBeforeRunning < timeToMeassure);
    }

    private void assertThrowsLike(Executable executable, String message) {
        assertEquals(message, assertThrows(Exception.class, executable).getMessage());
    }

    private void assertCustomersDistribution(CustomerBook customerBook, int active, int suspended, int total) {
        assertEquals(active, customerBook.numberOfActiveCustomers());
        assertEquals(suspended, customerBook.numberOfSuspendedCustomers());
        assertEquals(total, customerBook.numberOfCustomers());
    }
}