package numeros;

public class Fraccion extends Numero {

    static public String CanNotDivideByZero = "No se puede dividir por cero!!!!!!";
    public static String Fraccion = "Fraccion";

    public int numerator;
    public int denominator;

    public Fraccion(int aNumerator, int aDenominator) {
        if (aNumerator == 0) {
            throw new IllegalArgumentException("Una fraccion no puede ser cero");
        }
        if (aDenominator == 1) {
            throw new IllegalArgumentException("Una fraccion no puede tener denominador 1 porque sino es un entero");
        }
        if (aDenominator == 0) {
            throw new IllegalArgumentException(CanNotDivideByZero);
        }
        type = Fraccion;
        numerator = aNumerator;
        denominator = aDenominator;
    }

    public Fraccion negated() {
        return new Fraccion(numerator * -1, denominator);
    }

    public String toString() {
        return "" + numerator + "/" + denominator;
    }
    public Numero addedTo(Numero anAdder) {
        return anAdder.addMeAsFraccion(this);
    }
    @Override
    protected Numero addMeAsFraccion(numeros.Fraccion firstAdder) {
        return new Fraccion((firstAdder.numerator * denominator) + (numerator * firstAdder.denominator),
                firstAdder.denominator * denominator);
    }
    @Override
    protected Numero addMeAsEntero(numeros.Entero firstAdder) {
        return Numero.with((firstAdder.value * denominator) + numerator, denominator);
    }

    public Numero multipliedBy(Numero aMultiplier) {
        return aMultiplier.multiplyMeAsFraccion(this);
    }
    @Override
    protected Numero multiplyMeAsFraccion(numeros.Fraccion firstMultiplier) {
        return Numero.with(numerator * firstMultiplier.numerator, denominator * firstMultiplier.denominator);
    }
    @Override
    protected Numero multiplyMeAsEntero(numeros.Entero firstMultiplier) {
        return Numero.with(firstMultiplier.value * numerator, denominator);
    }

    public Numero dividedBy(Numero aDivisor) {
        return aDivisor.dividedMeAsFraccion(this);
    }
    @Override
    protected Numero dividedMeAsFraccion(numeros.Fraccion aDividend) {
        return Numero.with(aDividend.numerator * denominator, aDividend.denominator * numerator);
    }
    @Override
    protected Numero dividedMeAsEntero(numeros.Entero entero) {
        return Numero.with(entero.value * denominator, numerator);
    }

    public Numero substractedBy(Numero aSubtracting) {
        return aSubtracting.substractMeAsFraccion(this);
    }
    @Override
    protected Numero substractMeAsEntero(numeros.Entero entero) {
        return Numero.with((entero.value * denominator) - numerator, denominator);
    }
    @Override
    protected Numero substractMeAsFraccion(numeros.Fraccion aMinuend) {
        return Numero.with((aMinuend.numerator * denominator) - (numerator * aMinuend.denominator),
                aMinuend.denominator * denominator);
    }

    @Override
    protected boolean equalsMeAsEntero(Entero entero) {
        return entero.value * denominator == numerator;
    }

    @Override
    protected boolean equalsMeAsFraccion(numeros.Fraccion fraccion) {
        return fraccion.numerator * denominator == numerator * fraccion.denominator;
    }

    public boolean equals(Object anObject) {
        if (Numero.class.isInstance(anObject)) {
            Numero other = Numero.class.cast(anObject);
            return other.equalsMeAsFraccion(this);
        }
        return false;
    }

    public int hashCode() {
        return Double.hashCode((double) numerator / (double) denominator);
    }

    public int denominator() {
        return denominator;
    }

    public int numerator() {
        return numerator;
    }
}
