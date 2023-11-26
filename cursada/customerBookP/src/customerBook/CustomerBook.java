package customerBook;

import java.util.ArrayList;
import java.util.List;

public class CustomerBook {
    public static String customerNameCannotBeEmpty = "customer name cannot be empty!!!!!!";
    public static String customerAlreadyExists = "customer already exists!!!!!!";
    public static String customerNotFound = "Customer not found";
    public static String cannotSuspendCustomer = "Cannot suspend customer";

    private List<String> active = new ArrayList<>();
    private List<String> suspended = new ArrayList<>();

    public boolean includesCustomerNamed(String aCustomerName) {
        return active.contains(aCustomerName) || suspended.contains(aCustomerName);
    }

    public boolean isEmpty() {return active.isEmpty() && suspended.isEmpty();}

    public void addCustomerNamed(String string) {
        if (string.isEmpty()) {
            throw new RuntimeException(customerNameCannotBeEmpty);
        }

        if (active.contains(string) || suspended.contains(string)) {
            throw new RuntimeException(customerAlreadyExists);
        }

        active.add(string);
    }

    public int numberOfActiveCustomers() {return active.size();}

    public int numberOfCustomers() {return active.size() + suspended.size();}

    public int numberOfSuspendedCustomers() {return suspended.size();}

    public void removeCustomerNamed(String aName) {
        if (active.removeIf(each -> each.equals(aName))) {
            active.remove(aName);
            return;
        }

        if (suspended.removeIf(each -> each.equals(aName))) {
            suspended.remove(aName);
            return;
        }

        throw new RuntimeException(customerNotFound);
    }

    public void suspendCustomerNamed(String aName) {
        if (!active.contains(aName)) {
            throw new RuntimeException(cannotSuspendCustomer);
        }
        active.remove(aName);
        suspended.add(aName);
    }
}