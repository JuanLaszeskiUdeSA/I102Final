package self;

public abstract class Numero {
    static public String CanNotDivideByZero = "No se puede dividir por cero!!!!!!";


    public abstract Numero multipliedBy( Numero aMultiplier );
    public abstract Numero multiplicarAEntero( Entero anEnteroMultiplier );
    public abstract Numero multiplicarAFraccion( Fraccion aFraccionMultiplier );

    public abstract Numero substractedBy( Numero aMultiplier );
    protected abstract Numero substractMeAsEntero(Entero entero);
    protected abstract Numero substractMeAsFraccion(Fraccion fraccion);

    public Numero addedTo( Numero anAdder ) {
        /*if (type == Entero && anAdder.type == Entero) {
            return new Entero( value + anAdder.value );
        }

        if (type == Fraccion && anAdder.type == Fraccion) {
            int newNumerator = ( numerator * anAdder.denominator ) + ( denominator * anAdder.numerator );
            int newDenominator = denominator * anAdder.denominator;
            return with( newNumerator, newDenominator );
        }
*/
        throw new UnsupportedOperationException( "Tipo de número no soportado" );
    }
    protected abstract Numero addMeAsEntero(Entero entero);
    protected abstract Numero addMeAsFraccion(Fraccion fraccion);

    public Numero dividedBy( Numero aDivisor ) {
        /*if (type == Entero) {
            return new Entero( value / aDivisor.value );
        }
*/
        throw new UnsupportedOperationException( "Tipo de número no soportado" );
    }
    protected abstract Numero divideMeAsEntero(Entero entero);
    protected abstract Numero divideMeAsFraccion(Fraccion fraccion);

    public Numero greatestCommonDivisorWith( int anEntero ) {
        /*if (type == Entero) {
            return new Entero( greatestCommonDivisor( value, anEntero ) );
        }
*/
        throw new UnsupportedOperationException( "Tipo de número no soportado" );
    }

    public Numero negated() {
        /*if (type == Entero) {
            return new Entero( value * -1 );
        }
        if (type == Fraccion) {
            return new Fraccion( numerator * -1, denominator );
        }*/

        throw new UnsupportedOperationException( "Tipo de número no soportado" );
    }

    public boolean isNegative() {
        /*if (type == Entero) {
            return value < 0;
        }
        if (type == Fraccion) {
            return denominator < 0;
        }*/
        throw new UnsupportedOperationException( "Tipo de número no soportado" );
    }

    public boolean isOne() {
        /*if (type == Entero) {
            return value == 1;
        }
        if (type == Fraccion) {
            return false;
        }*/
        throw new UnsupportedOperationException( "Tipo de número no soportado" );
    }

    public boolean isZero() {
        /*if (type == Entero) {
            return value == 0;
        }
        if (type == Fraccion) {
            return false;
        }*/
        throw new UnsupportedOperationException( "Tipo de número no soportado" );
    }

    public String toString() {
        /*if (type == Entero) {
            return "" + value;
        }
        if (type == Fraccion) {
            return "" + numerator + "/" + denominator;
        }*/
        throw new UnsupportedOperationException( "Tipo de número no soportado" );
    }

    public boolean equals( Object anObject ) {
        /*if (Numero.class.isInstance( anObject )) {
            Numero other = Numero.class.cast( anObject );
            if (type == other.type) {
                if (type == Entero) {
                    return value == other.value();
                } else if (type == Fraccion) {
                    return numerator * other.denominator() == denominator * other.numerator();
                }
            }
        }*/
        return false;
    }

    /*public int hashCode() {
        if (type == Entero) {
            return Integer.hashCode( value );
        }
        if (type == Fraccion) {
            return Double.hashCode( (double) numerator / (double) denominator );
        }
        return 0;
    }*/
    // accessors
    public int denominator() {  return denominator; }
    public int value() {        return value;       }

    public int numerator() {    return numerator;   }

    public static int greatestCommonDivisor( int a, int b ) {
        int temp;
        while (b != 0) {
            temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }


}
