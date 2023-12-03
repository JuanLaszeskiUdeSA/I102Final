package self5;

import java.util.List;

public interface Accountable {
    int balance();
    List<Accountable> accounts();
    String report();
    String report(String prefix);
    String header();

}
