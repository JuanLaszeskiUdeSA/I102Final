package numeros;

public abstract class Numero {
    public String type;
    public Numero() {
    }
    public static Numero with(int aDividend, int aDivisor) {
        if (aDivisor == 0) {
            throw new IllegalArgumentException(Fraccion.CanNotDivideByZero);
        }

        if (aDividend == 0) {
            return Entero.with(0);
        }

        if (aDivisor < 0) {
            return with(-aDividend, -aDivisor);
        }

        int greatestCommonDivisor = Numero.greatestCommonDivisor(aDividend, aDivisor);
        int numerator = aDividend / greatestCommonDivisor;
        int denominator = aDivisor / greatestCommonDivisor;

        if (denominator == 1) {
            return Entero.with(numerator);
        }

        return new Fraccion(numerator, denominator);
    }

    public Numero substractedBy(Numero aSustracter) {
        throw new UnsupportedOperationException("Tipo de número no soportado");
    }

    public Numero multipliedBy(Numero aMultiplier){
        throw new UnsupportedOperationException("Tipo de número no soportado");
    };

    public Numero addedTo(Numero anAdder) {
        throw new UnsupportedOperationException("Tipo de número no soportado");
    }

    public Numero dividedBy(Numero aDivisor) {
        if (this == aDivisor) {
            return Entero.with(1);
        }

        throw new UnsupportedOperationException("Tipo de número no soportado");
    }

    public Numero greatestCommonDivisorWith(int anEntero) {
        throw new UnsupportedOperationException("Tipo de número no soportado");
    }

    public Numero negated() {
        throw new UnsupportedOperationException("Tipo de número no soportado");
    }

    public  boolean isOne(){return false;}
    public boolean isZero() {return false;}

    public String toString() {
        throw new UnsupportedOperationException("Tipo de número no soportado");
    }

    public boolean equals(Object anObject) {
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public static int greatestCommonDivisor(int a, int b) {
        int temp;
        while (b != 0) {
            temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    protected abstract Numero addMeAsEntero(numeros.Entero entero);

    protected abstract Numero multiplyMeAsEntero(numeros.Entero entero);

    protected abstract Numero substractMeAsEntero(numeros.Entero entero);

    protected abstract Numero dividedMeAsEntero(numeros.Entero entero);

    protected abstract Numero addMeAsFraccion(numeros.Fraccion fraccion);

    protected abstract Numero multiplyMeAsFraccion(numeros.Fraccion fraccion);

    protected abstract Numero dividedMeAsFraccion(numeros.Fraccion fraccion);

    protected abstract boolean equalsMeAsEntero(numeros.Entero entero);

    protected abstract boolean equalsMeAsFraccion(numeros.Fraccion fraccion);

    protected abstract Numero substractMeAsFraccion(Fraccion fraccion);
}