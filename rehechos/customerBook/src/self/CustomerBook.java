package self;

import java.util.ArrayList;
import java.util.List;

public class CustomerBook {
  public static String CustomerNameCannotBeEmpty = "customer name cannot be empty!!!!!!";
  public static String CannotSuspendCustomer = "Cannot suspend customer";
  public static String CustomerNotFound = "Customer not found";

  private List<String> active;
  private List<String> suspended;

  public CustomerBook() {
    active = new ArrayList();
    suspended = new ArrayList();
  }

  public boolean includesCustomerNamed( String s ) {
    return active.contains( s ) || suspended.contains( s );
  }

  public boolean isEmpty() { 
    return active.isEmpty() && suspended.isEmpty(); 
  }

  public void addCustomerNamed( String s ) {
    if (s.isEmpty()) { 
      throw new RuntimeException( CustomerNameCannotBeEmpty );
    }
    
    if (active.contains( s ) || suspended.contains( s )) {
      throw new RuntimeException( "customer already exists!!!!!!" );
    }
    active.add( s );
  }

  public int numberOfActiveCustomers() {
    return active.size();
  }

  public int numberOfCustomers() {
    return active.size() + suspended.size();
  }

  public int numberOfSuspendedCustomers() {
    return suspended.size();
  }

  public void removeCustomerNamed( String aName ) {
    /*for (int i = 0; i < active.size(); i++) {
      if (aName.equals( active.get( i ) )) {
        active.remove( i );
        return;
      }
    }
    for (int i = 0; i < suspended.size(); i++) {
      if (aName.equals( suspended.get( i ) )) {
        suspended.remove( i );
        return;
      }
    }*/
    if (!active.contains( aName ) && !suspended.contains( aName )) {
      throw new RuntimeException( CustomerNotFound );
    }
    active.remove( aName );
    suspended.remove( aName );
  }

  public void suspendCustomerNamed( String aName ) {
    if (!active.contains( aName )) { 
      throw new RuntimeException( "Cannot suspend customer" );
    }
    active.remove( aName );
    suspended.add( aName );
  }

}
