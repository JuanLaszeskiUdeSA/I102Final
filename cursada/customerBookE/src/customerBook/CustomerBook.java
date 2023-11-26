package customerBook;

import java.util.ArrayList;
import java.util.List;

public class CustomerBook {
  public static String CannotSuspend = "Cannot suspend customer";
  public static String CustomerNotFound = "Customer not found";
  public static String CustomerAlreadyExists = "customer already exists!!!!!!";
  public static String CustomerNameCannotBeEmpty = "customer name cannot be empty!!!!!!";
  
  private List<String> active = new ArrayList();
  private List<String> suspended = new ArrayList();

  public boolean includesCustomerNamed( String aCustomerName) {
    return active.contains( aCustomerName ) || suspended.contains( aCustomerName );
  }

  public boolean isEmpty() { 
    return active.isEmpty() && suspended.isEmpty(); 
  }

  public void addCustomerNamed( String aCustomerName ) {
    if (aCustomerName.isEmpty()) { 
      throw new RuntimeException( CustomerNameCannotBeEmpty ); 
    }
    
    if (includesCustomerNamed( aCustomerName )) {
      throw new RuntimeException( CustomerAlreadyExists );
    }
    active.add( aCustomerName );
  }

  public int numberOfActiveCustomers() {
    return active.size();
  }

  public int numberOfCustomers() {
    return numberOfActiveCustomers() + numberOfSuspendedCustomers();
  }

  public int numberOfSuspendedCustomers() {
    return suspended.size();
  }

//  public void removeCustomerNamed( String aName ) {
//    if (active.contains( aName )) {
//      active.remove( aName );
//      return;
//    }
//
//    if (suspended.contains( aName )) {
//      suspended.remove( aName );
//      return;
//    }
//
//    throw new RuntimeException( CustomerNotFound );
//  }

//  public void removeCustomerNamed( String aName ) {
//    if (!includesCustomerNamed( aName )) {
//      throw new RuntimeException( CustomerNotFound );
//    }
//
//    active.remove( aName );
//    suspended.remove( aName );
//  }

  public void removeCustomerNamed( String aName ) {
    if (active.removeIf( (each) -> aName.equals( each ) )) {
      return;
    }

    if (suspended.removeIf( (each) -> aName.equals( each ) )) {
      return;
    }

    throw new RuntimeException( CustomerNotFound );
  }

  public void suspendCustomerNamed( String aName ) {
    if (!active.contains( aName )) { 
      throw new RuntimeException( CannotSuspend );
    }
    active.remove( aName );
    suspended.add( aName );
  }

}
