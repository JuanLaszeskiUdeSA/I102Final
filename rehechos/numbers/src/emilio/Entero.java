package emilio;

public class Entero extends Numero {
    private int value;

    public static Entero with(int aValue) {
        return new Entero(aValue);
    }

    private Entero( int aValue ) {
        value = aValue;
    }

    public boolean isZero() {
        return value() == 0;
    }

    public boolean isOne() {
        return value() == 1;
    }

    public Numero addedTo( Numero anAdder ) {
        return anAdder.addMeAsEntero( this );
    }
    public Numero addMeAsEntero( Entero firstAdder ) {
        return new Entero( firstAdder.value() + value() );
    }
    public Numero addMeAsFraccion( Fraccion firstAdder ) {
        return firstAdder.numerator().addedTo( firstAdder.denominator().multipliedBy( this ) )
                .dividedBy( firstAdder.denominator() );
    }

    public Numero multipliedBy( Numero aMultiplier ) {
        return aMultiplier.multiplyMeAsEntero( this );
    }
    public Numero multiplyMeAsEntero( Entero firstMultiplier) {
        return new Entero( firstMultiplier.value() * value() );
    }
    public Numero multiplyMeAsFraccion( Fraccion firstMultiplier ) {
        return firstMultiplier.numerator().multipliedBy( this )
                .dividedBy( firstMultiplier.denominator() );
    }

    public Numero dividedBy( Numero aDivisor ) {
        return aDivisor.divideMeAsEntero( this );
    }
    public Numero divideMeAsEntero( Entero aDividend) {
        return Fraccion.with( aDividend, this );
    }
    public Numero divideMeAsFraccion(Fraccion aDividend) {
        return aDividend.numerator()
                .dividedBy( aDividend.denominator().multipliedBy( this ) );
    }

    public Numero substractedBy( Numero aMinuend ) {
        return aMinuend.subtractMeAsEntero( this );
    }
    public Numero subtractMeAsEntero(Entero aMinuend) {
        return Entero.with( aMinuend.value - value );
    }
    public Numero subtractMeAsFraccion(Fraccion aMinuend) {
        return aMinuend.numerator().substractedBy(multipliedBy( aMinuend.denominator()) )
                .dividedBy( aMinuend.denominator() );
    }

    public Numero greatestCommonDivisorWith( int anEntero ) {
        return new Entero( greatestCommonDivisor( value(), anEntero ) );
    }

    public boolean isNegative() {
        return value() < 0;
    }

    public String toString() {
        return "" + value();
    }

    public boolean equals( Object anObject ) {
        return Entero.class.isInstance( anObject ) &&
               value() == Entero.class.cast( anObject ).value();
    }

    public int hashCode() {
        return Integer.hashCode( value() );
    }

    // Accessors
    public int value() {        return value;       }

}

