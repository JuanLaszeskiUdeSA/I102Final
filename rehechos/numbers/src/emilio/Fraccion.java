package emilio;

public class Fraccion extends Numero {
    private Entero numerator;
    private Entero denominator;

    public static Numero with( Entero aDividend, Entero aDivisor ) {
        if (aDivisor.isZero()) {
            throw new IllegalArgumentException( CanNotDivideByZero );
        }

        if (aDividend.isZero()) {
            return Entero.with( 0 );
        }

        if (aDivisor.isNegative() ) {
            return aDividend.negated().dividedBy( aDivisor.negated() );
        }

        int greatestCommonDivisor = Numero.greatestCommonDivisor( aDividend.value(), aDivisor.value() );
        Entero numerator = Entero.with( aDividend.value() / greatestCommonDivisor );
        Entero denominator = Entero.with( aDivisor.value() / greatestCommonDivisor );

        if (denominator.isOne()) {
            return numerator;
        }

        return new Fraccion( numerator, denominator );
    }

    private Fraccion( Entero aNumerator, Entero aDenominator ) {
        if (aNumerator.isZero()) {
            throw new IllegalArgumentException( "Una fraccion no puede ser cero" );
        }
        if (aDenominator.isOne()) {
            throw new IllegalArgumentException( "Una fraccion no puede tener denominador 1 porque sino es un entero" );
        }
        numerator = aNumerator;
        denominator = aDenominator;
    }

    public Numero addedTo( Numero anAdder ) {
        return anAdder.addMeAsFraccion( this );
    }
    public Numero addMeAsFraccion( Fraccion firstAdder ) {
        return firstAdder.numerator().multipliedBy( denominator() ).addedTo( firstAdder.denominator().multipliedBy( numerator() ) )
                .dividedBy( firstAdder.denominator().multipliedBy( denominator() ) );
    }
    public Numero addMeAsEntero( Entero firstAdder ) {
        return firstAdder.multipliedBy( denominator() ).addedTo( numerator() )
                .dividedBy( denominator() );
    }

    public Numero multipliedBy( Numero aMultiplier ) {
        return aMultiplier.multiplyMeAsFraccion( this );
    }
    public Numero multiplyMeAsEntero(  Entero firstMultiplier ) {
        return numerator().multipliedBy( firstMultiplier )
                .dividedBy( denominator() );
    }
    public Numero multiplyMeAsFraccion( Fraccion firstMultiplier ) {
        return firstMultiplier.numerator().multipliedBy( numerator() )
                .dividedBy( firstMultiplier.denominator().multipliedBy( denominator() ) );
    }

    public Numero substractedBy( Numero aDivisor ) {
        return aDivisor.subtractMeAsFraccion( this );
    }
    public Numero subtractMeAsFraccion(Fraccion aSubtrahend) {
        return denominator().multipliedBy( aSubtrahend.numerator() ).substractedBy( numerator().multipliedBy( aSubtrahend.denominator() ) )
                .dividedBy( denominator().multipliedBy( aSubtrahend.denominator() ) );
    }
    public Numero subtractMeAsEntero(Entero aMinuend) {
        return aMinuend.multipliedBy( denominator() ).substractedBy( numerator() )
                .dividedBy( denominator() );
    }

    public Numero dividedBy( Numero aDivisor ) {
        return aDivisor.divideMeAsFraccion( this );
    }
    public Numero divideMeAsEntero( Entero aDividend ) {
        return aDividend.multipliedBy( denominator() ).dividedBy( numerator() );
    }
    public Numero divideMeAsFraccion(Fraccion aDividend) {
        return aDividend.numerator().multipliedBy( denominator() )
                .dividedBy( aDividend.denominator().multipliedBy( numerator() ) );
	  }

    public boolean isNegative() {
        return denominator().isNegative();
    }

    public String toString() {
        return "" + numerator() + "/" + denominator();
    }

    public boolean equals( Object anObject ) {
        return Fraccion.class.isInstance( anObject ) &&
               numerator().multipliedBy( Fraccion.class.cast( anObject ).denominator() )
                  .equals( denominator().multipliedBy( Fraccion.class.cast( anObject ).numerator() ) );
    }

    public int hashCode() {
        return numerator().hashCode() * denominator().hashCode();
    }

    // Accessors
    public Entero denominator() {  return denominator; }
    public Entero numerator() {    return numerator;   }

}
