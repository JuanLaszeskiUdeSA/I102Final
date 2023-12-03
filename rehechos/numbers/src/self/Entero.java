package self;

public class Entero extends Numero {
    private int value;

    public Entero(int aValue) {
        value = aValue;
    }

    public static Numero with(int aValue) {
        return new Entero(aValue);
    }

    @Override
    public Numero addedTo(Numero anAdder) {
        return anAdder.addMeAsEntero(this);
    }
    @Override
    public Numero addMeAsEntero(Entero firstAdder) {
        return Entero.with(value + firstAdder.value);
    }
    @Override
    public Numero addMeAsFraccion(Fraccion firstAdder) {
        return firstAdder.numerator().addedTo( firstAdder.denominator().multipliedBy( this ) )
                .dividedBy( firstAdder.denominator() );
    }

    @Override
    public Numero substractedBy(Numero aSubtracting) {
        return aSubtracting.subtractMeAsEntero(this);
    }
    @Override
    public Numero subtractMeAsEntero(Entero minuend) {
        return Entero.with(minuend.value - value);
    }
    @Override
    public Numero subtractMeAsFraccion(Fraccion minuend) {
        return minuend.numerator().substractedBy(multipliedBy( minuend.denominator()) )
              .dividedBy( minuend.denominator() );
    }

    @Override
    public Numero multipliedBy(Numero aMultiplier) {
        return aMultiplier.multiplyMeAsEntero(this);
    }
    @Override
    public Numero multiplyMeAsEntero(Entero firstMultiplier) {
        return Entero.with(value * firstMultiplier.value);
    }
    @Override
    public Numero multiplyMeAsFraccion(Fraccion firstMultiplier) {
        return firstMultiplier.numerator().multipliedBy(this)
                .dividedBy(firstMultiplier.denominator());
    }

    @Override
    public Numero dividedBy(Numero aDivisor) {
        return aDivisor.divideMeAsEntero(this);
    }
    @Override
    public Numero divideMeAsEntero(Entero dividend) {
        return Fraccion.with(dividend, this);
    }
    @Override
    public Numero divideMeAsFraccion(Fraccion dividend) {
        return dividend.numerator()
                .dividedBy(dividend.denominator().multipliedBy(this));
    }

    public boolean isNegative() {
        return value < 0;
    }

    public boolean isOne() {
        return value == 1;
    }

    public boolean isZero() {
        return value == 0;
    }

    @Override
    public String toString() {
        return "" + value;
    }

    @Override
    public boolean equals(Object anObject) {
      return Entero.class.isInstance( anObject ) &&
              value() == Entero.class.cast( anObject ).value();
    }

    public int value() {
        return value;
    }


}
