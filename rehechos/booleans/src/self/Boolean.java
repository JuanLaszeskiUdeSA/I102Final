package self;

public abstract class Boolean {

  
 static Boolean True() {
    return new True();
  }

  static Boolean False() {
    return new False();
  }

  public boolean equals( Object other ) {
    return other.getClass() == getClass();
  }

/*  public Boolean yy( Boolean v ) {
    if ( value ) {
      return v;
    } else {
      return False();
    }
  }
  
  public Boolean oo( Boolean v ) {
    if ( value ) {
      return True();
    } else {
      return v;
    }  
  }
  public Boolean not() {
    if ( value ) {
      return False();
    } else {
      return True();
    }
  }*/
    public abstract Boolean yy( Boolean v );
    public abstract Boolean oo( Boolean v );
    public abstract Boolean not();
}
