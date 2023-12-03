package self;

public class Fraccion extends Numero {

    private Entero numerator;
    private Entero denominator;

    public static Numero with(Entero aDividend, Entero aDivisor) {
        if (aDivisor.isZero()) {
            throw new IllegalArgumentException(CanNotDivideByZero);
        }

        if (aDividend.isZero()) {
            return Entero.with(0);
        }

        if (aDivisor.isNegative()) {
            return with((Entero) aDividend.negated(), (Entero) aDivisor.negated());
        }

        int greatestCommonDivisor = Numero.greatestCommonDivisor(aDividend.value(), aDivisor.value());
        Entero numerator = (Entero) Entero.with(aDividend.value() / greatestCommonDivisor);
        Entero denominator = (Entero) Entero.with(aDivisor.value() / greatestCommonDivisor);

        if (denominator.isOne()) {
            return Entero.with(numerator.value());
        }

        return new Fraccion(numerator, denominator);
    }

    public Fraccion(Entero aNumerator, Entero aDenominator) {
        if (aNumerator.isZero()) {
            throw new IllegalArgumentException("Una fraccion no puede ser cero");
        }
        if (aDenominator.isOne()) {
            throw new IllegalArgumentException("Una fraccion no puede tener denominador 1 porque sino es un entero");
        }
        numerator = aNumerator;
        denominator = aDenominator;
    }


    @Override
    public Numero addedTo(Numero anAdder) {
        return anAdder.addMeAsFraccion(this);
    }
    @Override
    public Numero addMeAsEntero(Entero firstAdder) {
        return firstAdder.multipliedBy(denominator()).addedTo(numerator())
                .dividedBy(denominator());
    }
    @Override
    public Numero addMeAsFraccion(Fraccion firstAdder) {
        return firstAdder.numerator().multipliedBy(denominator()).addedTo(firstAdder.denominator().multipliedBy(numerator()))
                .dividedBy(firstAdder.denominator().multipliedBy(denominator()));
    }

    @Override
    public Numero substractedBy(Numero aSubtracting) {
        return aSubtracting.subtractMeAsFraccion(this);
    }
    @Override
    public Numero subtractMeAsEntero(Entero minuend) {
        return minuend.multipliedBy( denominator() ).substractedBy( numerator() )
                .dividedBy( denominator() );
    }
    @Override
    public Numero subtractMeAsFraccion(Fraccion minuend) {
        return denominator().multipliedBy( minuend.numerator() ).substractedBy( numerator().multipliedBy( minuend.denominator() ) )
                .dividedBy( denominator().multipliedBy( minuend.denominator() ) );
    }

    @Override
    public Numero multipliedBy(Numero aMultiplier) {
        return aMultiplier.multiplyMeAsFraccion(this);
    }
    @Override
    public Numero multiplyMeAsEntero(Entero firstMultiplier) {
        return numerator.multipliedBy(firstMultiplier)
                .dividedBy(denominator);
    }
    @Override
    public Numero multiplyMeAsFraccion(Fraccion firstMultiplier) {
        return firstMultiplier.numerator().multipliedBy(numerator)
                .dividedBy(firstMultiplier.denominator().multipliedBy(denominator));
    }

    @Override
    public Numero dividedBy(Numero aDivisor) {
        return aDivisor.divideMeAsFraccion(this);
    }
    @Override
    public Numero divideMeAsEntero(Entero dividend) {
        return dividend.multipliedBy(denominator).dividedBy(numerator);
    }
    @Override
    public Numero divideMeAsFraccion(Fraccion dividend) {
        return dividend.numerator().multipliedBy(denominator)
                .dividedBy(dividend.denominator().multipliedBy(numerator));
    }

    @Override
    public boolean isNegative() {
        return numerator.isNegative();
    }

    @Override
    public boolean isOne() {
        return false;
    }

    @Override
    public boolean isZero() {
        return false;
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    @Override
    public boolean equals(Object anObject) {
      return Fraccion.class.isInstance( anObject ) &&
              numerator().multipliedBy( Fraccion.class.cast( anObject ).denominator() )
                      .equals( denominator().multipliedBy( Fraccion.class.cast( anObject ).numerator() ) );
    }

    public Entero numerator() {
        return numerator;
    }

    public Entero denominator() {
        return denominator;
    }
}
