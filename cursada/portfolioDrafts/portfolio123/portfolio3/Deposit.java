package portfolio3;

public class Deposit extends Transaction {
    public static Transaction deposit( int value ) { return new Deposit(value );  }

    public Deposit(int value) {super(value);}

    public int valueForBalance() {return value();}
    public String reportDetail() {return "Deposit: " + value();}
}