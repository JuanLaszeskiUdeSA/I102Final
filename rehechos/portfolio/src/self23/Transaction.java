package self23;

public class Transaction {
    private int amount;
    private String type;

    public Transaction(int amount, String type) {
        this.amount = amount;
        this.type = type;
    }

    public static Transaction deposit(int amount) {
        return new Transaction(amount, "Deposit");
    }

    public static Transaction withdraw(int amount) {
        return new Transaction(amount, "Withdraw");
    }

    public int value() {
        if (type.equals("Deposit")) {
            return amount;
        } else {
            return -amount;
        }
    }

    public String report() {
        return type + ": " + amount;
    }
}
