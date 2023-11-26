package portfolio;

public class Deposit extends Transaction{
    public Deposit(int value) {super(value);}

    public int valueForBalance() {return super.value();}

    public String report() {return "Deposit: " + value();}
}
