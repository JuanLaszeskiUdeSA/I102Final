package self;

public class Fraccion extends Numero {

  public Entero numerator;
  public Entero denominator;

  public static Numero with( Entero aDividend, Entero aDivisor ) {
    if (aDivisor.isZero()) {
      throw new IllegalArgumentException( CanNotDivideByZero );
    }

    if (aDividend.isZero()) {
      return Entero.with( 0 );
    }

    if (aDivisor.isNegative() ) {
      return with( (Entero) aDividend.negated(), (Entero) aDivisor.negated() );
    }

    int greatestCommonDivisor = Numero.greatestCommonDivisor( aDividend.value(), aDivisor.value() );
    Entero numerator = Entero.with( aDividend.value() / greatestCommonDivisor );
    Entero denominator = Entero.with( aDivisor.value() / greatestCommonDivisor );

    if (denominator.isOne()) {
      return numerator;
    }

    return new Fraccion( numerator, denominator );
  }

  public Fraccion( Entero aNumerator, Entero aDenominator ) {
    if (aNumerator.isZero()) {
        throw new IllegalArgumentException( "Una fraccion no puede ser cero" );
    }
    if (aDenominator.isOne()) {
        throw new IllegalArgumentException( "Una fraccion no puede tener denominador 1 porque sino es un entero" );
    }
    numerator = aNumerator;
    denominator = aDenominator;
  }

  @Override
  public Numero multipliedBy(Numero aMultiplier ) {
    return aMultiplier.multiplicarAFraccion( this );
  }
  public Numero multiplicarAEntero( Entero anEnteroMultiplier ) {
    return with( anEnteroMultiplier.value * numerator, denominator );
  }
  public Numero multiplicarAFraccion( Fraccion aFraccionMultiplier ) {
    return aFraccionMultiplier.numerator().multipliedBy( numerator() )
            .dividedBy( aFraccionMultiplier.denominator().multipliedBy( denominator() ) );
  }

  @Override
  public Numero addedTo(Numero anAdder) {
    return anAdder.addMeAsFraccion( this );
  }
  protected Numero addMeAsEntero(Entero entero) {
    return with( entero.value + numerator * denominator, denominator);
  }
  protected Numero addMeAsFraccion(Fraccion fraccion) {
    return with( numerator * fraccion.denominator + fraccion.numerator * denominator, denominator * fraccion.denominator);
  }

  @Override
  public Numero dividedBy(Numero aDivisor) {
    return aDivisor.divideMeAsFraccion( this );
  }
  protected Numero divideMeAsEntero(Entero entero) {
    if (entero.value == 0) throw new RuntimeException(Numero.CanNotDivideByZero);
    return with( entero.value * denominator, numerator);
  }
  protected Numero divideMeAsFraccion(Fraccion fraccion) {
    if (fraccion.numerator == 0) throw new RuntimeException(Numero.CanNotDivideByZero);
    return with( numerator * fraccion.denominator, denominator * fraccion.numerator);
  }

  @Override
  public Numero substractedBy(Numero aMultiplier) {
    return aMultiplier.substractMeAsFraccion( this );
  }
  protected Numero substractMeAsFraccion(Fraccion fraccion) {
    return with( -numerator * fraccion.denominator + fraccion.numerator * denominator, denominator * fraccion.denominator);
  }
  protected Numero substractMeAsEntero(Entero entero) {
    return with( entero.value - numerator * denominator, denominator);
  }

  public Numero negated() {
    return with( -numerator, denominator );
  }

  public boolean isNegative() {
    return numerator < 0;
  }

  public boolean isZero() {
    return false;
  }

  public boolean isOne() {
      return false;
  }

  public String toString() {
    return numerator + "/" + denominator;
  }

  public boolean equals( Object anObject ) {
    if (anObject instanceof Fraccion) {
      Fraccion aFraccion = (Fraccion) anObject;
      return numerator == aFraccion.numerator && denominator == aFraccion.denominator;
    }
    return false;
  }

}
