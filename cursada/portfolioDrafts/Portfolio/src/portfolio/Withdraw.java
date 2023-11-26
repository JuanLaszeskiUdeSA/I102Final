package portfolio;

public class Withdraw extends Transaction{
    public Withdraw(int value) {super(value);}

    public int valueForBalance() {return -super.value();}

    public String report() {return "Withdraw: " + value();}
}
