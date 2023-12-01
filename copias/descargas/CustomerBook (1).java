package codigorepetido;

import java.util.ArrayList;
import java.util.List;

public class CustomerBook {
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
      throw new RuntimeException( "customer name cannot be empty!!!!!!" ); 
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
    for (int i = 0; i < active.size(); i++) {
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
    }
    throw new RuntimeException( "Customer not found" );
  }

  public void suspendCustomerNamed( String aName ) {
    if (!active.contains( aName )) { 
      throw new RuntimeException( "Cannot suspend customer" );
    }
    active.remove( aName );
    suspended.add( aName );
  }

}
