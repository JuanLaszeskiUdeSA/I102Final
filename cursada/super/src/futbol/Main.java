package futbol;

import abc.A;
import abc.B;
import abc.C;

public class Main {
    public static void main(String[] args) {
        new Arquero().jugarCon( new Delantero() );
        new Defensor().jugar();
    }
}