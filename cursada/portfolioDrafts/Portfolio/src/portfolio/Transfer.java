package portfolio;

public class Transfer {
    public static void debitTransfer(Account from, Account to, int amount) {
        from.debit(amount);
        to.credit(amount);
    }

    public static void creditTransfer(Account from, Account to, int amount) {
        from.credit(amount);
        to.debit(amount);
    }
}
