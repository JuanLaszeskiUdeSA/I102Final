package portfolio;

import java.util.List;

public abstract class Accountable {
    public abstract int valueForBalance();
    public abstract String report();
    public abstract String report(String prefix);
    public abstract boolean contains(Accountable accountable);
    public abstract List<Account> accounts();
}
