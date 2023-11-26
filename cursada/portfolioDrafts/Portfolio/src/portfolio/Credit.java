package portfolio;

public class Credit extends Transaction{
    public Credit(int value) {super(value);}

    public int valueForBalance() {return super.value();}

    public String report() {return "Transferencia recibida: " + value();}
}
