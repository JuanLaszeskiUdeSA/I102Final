

import java.util.Arrays;
import java.util.List;

public class Drug {

  private List<String> relieves;
  private String[] collateral = new String[] {};
  private String name;
 
  public Drug( String name ) {
    this.name = name;
  }

  public boolean heals( String symptom ) {
    for (int i = 0; i < relieves.size(); i++) {
      if (relieves.get( i ).equals( symptom ) ) {
          return true;
      }
    }
    return false;
  }
  
  public boolean aggravate( String prevalence ) {
    for (int i = 0; i < collateral.length; i++) {
      if (collateral[i].equals(prevalence)) {
          return true;
      }
    }
    return false;
  }

  public Drug releaves( String ... symptoms ) {
    relieves = Arrays.asList( symptoms );
    return this;
  }
  
  public Drug collateral( String ... symptoms ) {
    collateral = symptoms;
    return this;
  }

  public String name() { return name; }
  
}
