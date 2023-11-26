package portfolio3;

public class Withdraw extends Transaction {
    public static Transaction withdraw( int value ) { return new Withdraw( value );  }

    public Withdraw( int value) {super(value);}

    public int valueForBalance() {return value() * -1;}
    public String reportDetail() {return "Withdraw: " + value();}
}
