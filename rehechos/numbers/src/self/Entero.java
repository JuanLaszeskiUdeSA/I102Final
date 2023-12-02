package self;

public class Entero extends Numero {

  public int value;

  public static Entero with( int aValue ) {
    return new Entero( aValue );
  }

  public Entero( int aValue ) {
    value = aValue;
  }

  @Override
  public Numero addedTo( Numero anAdder ) {
    return anAdder.addMeAsEntero( this );
  }
  protected Numero addMeAsEntero(Entero entero) {
    return with( value + entero.value );
  }
  protected Numero addMeAsFraccion(Fraccion fraccion) {
    return fraccion.numerator().addedTo( fraccion.denominator().multipliedBy( this ) )
            .dividedBy( fraccion.denominator() );
  }

  @Override
  public Numero dividedBy( Numero aDivisor ) {
    return aDivisor.divideMeAsEntero( this );
  }
  protected Numero divideMeAsEntero(Entero entero) {
    if (entero.value == 0) throw new RuntimeException(Numero.CanNotDivideByZero);
    return with( entero.value / value );
  }
  protected Numero divideMeAsFraccion(Fraccion fraccion) {
    if (fraccion.numerator == 0) throw new RuntimeException(Numero.CanNotDivideByZero);
    return with( fraccion.numerator * denominator, fraccion.denominator * numerator);
  }

  @Override
  public Numero substractedBy(Numero aSusbtracter) {
    return aSusbtracter.substractMeAsEntero( this );
  }
  protected Numero substractMeAsEntero(Entero entero) {
    return with( entero.value - value );
  }
  protected Numero substractMeAsFraccion(Fraccion fraccion) {
    return with( fraccion.numerator - value * fraccion.denominator, fraccion.denominator );
  }

  @Override
  public Numero multipliedBy(Numero aMultiplier ) {
    return aMultiplier.multiplicarAEntero( this );
    
//    if( aMultiplier.type == Entero) {
//      return multiplicarAEntero( aMultiplier );
//    } else {  //fraccion
//      return multiplicarAFraccion( aMultiplier );
//    }
  }
  public Numero multiplicarAEntero( Entero anEnteroMultiplier ) {
    return with( value * anEnteroMultiplier.value );
  }
  public Numero multiplicarAFraccion( Fraccion aFraccionMultiplier ) {
    return with( value * aFraccionMultiplier.numerator, aFraccionMultiplier.denominator );
  }

  public Numero greatestCommonDivisorWith( int anEntero ) {
    return new Entero( greatestCommonDivisor( value, anEntero ) );
  }

  public Numero negated() {
      return new Entero( value * -1 );
  }

  public boolean isNegative() {
    return value < 0;
  }

  public boolean isZero() {
      return value == 0;
  }

  public boolean isOne() {
      return value == 1;
  }

  public String toString() {
    return String.valueOf( value );
  }

  public boolean equals( Object anObject ) {
    if (anObject instanceof Entero) {
      return value == ((Entero)anObject).value;
    }
    return false;
  }

  
}
