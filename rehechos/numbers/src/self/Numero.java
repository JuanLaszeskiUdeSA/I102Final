package self;

public abstract class Numero {
    static public String CanNotDivideByZero = "No se puede dividir por cero!!!!!!";

    /*public static String Entero = "Entero";
    public static String Fraccion = "Fraccion";
    public String type;
    public int value;
    public int numerator;
    public int denominator;*/


    public abstract Numero addedTo( Numero anAdder );
    public abstract Numero addMeAsEntero( Entero firstAdder );
    public abstract Numero addMeAsFraccion( Fraccion firstAdder );

    public abstract Numero substractedBy(Numero aSubtracting );
    public abstract Numero subtractMeAsEntero( Entero minuend );
    public abstract Numero subtractMeAsFraccion( Fraccion minuend );

    public abstract Numero multipliedBy( Numero aMultiplier );
    public abstract Numero multiplyMeAsEntero( Entero firstMultiplier );
    public abstract Numero multiplyMeAsFraccion( Fraccion firstMultiplier );

    public abstract Numero dividedBy( Numero aDivisor );
    public abstract Numero divideMeAsEntero( Entero dividend );
    public abstract Numero divideMeAsFraccion( Fraccion dividend );

    public abstract boolean isNegative();
    public abstract boolean isOne();
    public abstract boolean isZero();
    public abstract String toString();
    public abstract boolean equals( Object anObject );

    public Numero negated(){return multipliedBy(Entero.with(-1));}









    /*public Numero greatestCommonDivisorWith( int anEntero ) {
        if (type == Entero) {
            return new Entero( greatestCommonDivisor( value, anEntero ) );
        }

        throw new UnsupportedOperationException( "Tipo de número no soportado" );
    }

    public Numero negated() {
        if (type == Entero) {
            return new Entero( value * -1 );
        }
        if (type == Fraccion) {
            return new Fraccion( numerator * -1, denominator );
        }

        throw new UnsupportedOperationException( "Tipo de número no soportado" );
    }

    public boolean isNegative() {
        if (type == Entero) {
            return value < 0;
        }
        if (type == Fraccion) {
            return denominator < 0;
        }
        throw new UnsupportedOperationException( "Tipo de número no soportado" );
    }

    public boolean isOne() {
        if (type == Entero) {
            return value == 1;
        }
        if (type == Fraccion) {
            return false;
        }
        throw new UnsupportedOperationException( "Tipo de número no soportado" );
    }

    public boolean isZero() {
        if (type == Entero) {
            return value == 0;
        }
        if (type == Fraccion) {
            return false;
        }
        throw new UnsupportedOperationException( "Tipo de número no soportado" );
    }

    public String toString() {
        if (type == Entero) {
            return "" + value;
        }
        if (type == Fraccion) {
            return "" + numerator + "/" + denominator;
        }
        throw new UnsupportedOperationException( "Tipo de número no soportado" );
    }

    public boolean equals( Object anObject ) {
        if (Numero.class.isInstance( anObject )) {
            Numero other = Numero.class.cast( anObject );
            if (type == other.type) {
                if (type == Entero) {
                    return value == other.value();
                } else if (type == Fraccion) {
                    return numerator * other.denominator() == denominator * other.numerator();
                }
            }
        }
        return false;
    }

    public int hashCode() {
        if (type == Entero) {
            return Integer.hashCode( value );
        }
        if (type == Fraccion) {
            return Double.hashCode( (double) numerator / (double) denominator );
        }
        return 0;
    }

    // accessors
    public int denominator() {  return denominator; }
    public int value() {        return value;       }
    public int numerator() {    return numerator;   }*/

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
