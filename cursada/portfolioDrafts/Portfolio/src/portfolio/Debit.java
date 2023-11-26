package portfolio;

public class Debit extends Transaction{
    public Debit(int value) {super(value);}

    public int valueForBalance() {return super.value() * -1;}

    public String report() {return "Transferencia enviada: " + value();}
}
