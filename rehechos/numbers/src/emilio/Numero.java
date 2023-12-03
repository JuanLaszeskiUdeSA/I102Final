package emilio;

public abstract class Numero {
    static public String CanNotDivideByZero = "No se puede dividir por cero!!!!!!";

    public abstract Numero multipliedBy( Numero aMultiplier );
    public abstract Numero multiplyMeAsEntero( Entero firstAdder );
    public abstract Numero multiplyMeAsFraccion( Fraccion firstAdder );

    public abstract Numero addedTo( Numero anAdder );
    public abstract Numero addMeAsFraccion( Fraccion firstAdder );
    public abstract Numero addMeAsEntero( Entero firstAdder );

    public abstract Numero dividedBy( Numero aDivisor );
    public abstract Numero divideMeAsEntero( Entero dividend );
    public abstract Numero divideMeAsFraccion(Fraccion aDividend);

    public abstract Numero substractedBy( Numero aDivisor );
    public abstract Numero subtractMeAsEntero(Entero anEnteroMinuend);
    public abstract Numero subtractMeAsFraccion(Fraccion aFraccionMinuend);

    public abstract boolean isNegative();

    public boolean isOne() {
        return false;
    }
    public boolean isZero() {
        return false;
    }
    public Numero negated() {
        return multipliedBy(Entero.with(-1));
    }

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
