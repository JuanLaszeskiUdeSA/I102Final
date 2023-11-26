package numeros;

public class Entero extends Numero {
    public static String Entero = "Entero";
    public int value;

    public Entero(int aValue) {
        type = Entero;
        value = aValue;
    }

    public static Entero with(int aValue) {
        return new Entero(aValue);
    }

    public boolean isZero() {
        return value == 0;
    }

    public boolean isOne() {
        return value == 1;
    }

    public Entero greatestCommonDivisorWith(int anEntero) {
        return new Entero(greatestCommonDivisor(value, anEntero));
    }

    public Entero negated() {
        return new Entero(value * -1);
    }

    public boolean isNegative() {
        return value < 0;
    }

    public String toString() {
        return "" + value;
    }

    public Numero addedTo(Numero anAdder) {
        return anAdder.addMeAsEntero(this);
    }
    @Override
    protected Numero addMeAsEntero(Entero firstAdder) {
        return new Entero(firstAdder.value + value);
    }
    @Override
    protected Numero addMeAsFraccion(numeros.Fraccion firstAdder) {
        return Numero.with(firstAdder.numerator + (value * firstAdder.denominator),
                firstAdder.denominator);
    }

    public Numero multipliedBy(Numero aMultiplier) {
        return aMultiplier.multiplyMeAsEntero(this);
    }
    @Override
    protected Numero multiplyMeAsEntero(Entero firstMultiplier) {
        return new Entero(firstMultiplier.value * value);
    }

    @Override
    protected Numero multiplyMeAsFraccion(numeros.Fraccion firstMultiplier) {
        return Numero.with(firstMultiplier.numerator * value, firstMultiplier.denominator);
    }

    public Numero dividedBy(Numero aDivisor) {
        return aDivisor.dividedMeAsEntero(this);
    }

    @Override
    protected Numero dividedMeAsEntero(numeros.Entero aDividend) {
        return Numero.with(aDividend.value, this.value());
    }
    @Override
    protected Numero dividedMeAsFraccion(numeros.Fraccion fraccion) {
        return Numero.with(fraccion.numerator, fraccion.denominator * value);
    }
    public Numero substractedBy(Numero aSubtracting) {
        return aSubtracting.substractMeAsEntero(this);
    }
    @Override
    protected Numero substractMeAsEntero(numeros.Entero aMinuend) {
        return new Entero(aMinuend.value - value);
    }
    @Override
    protected Numero substractMeAsFraccion(Fraccion aMinuend) {
        return Numero.with((aMinuend.numerator * value) - aMinuend.denominator, aMinuend.denominator);
    }

    @Override
    protected boolean equalsMeAsEntero(numeros.Entero other) {
        return value == other.value;
    }

    @Override
    protected boolean equalsMeAsFraccion(Fraccion fraccion) {
        return false;
    }

    public boolean equals(Object anObject) {
        if (Numero.class.isInstance(anObject)) {
            Numero other = Numero.class.cast(anObject);
            return other.equalsMeAsEntero(this);
        }
        return false;
    }

    public int hashCode() {
        return Integer.hashCode(value);
    }

    public int value() {
        return value;
    }
}