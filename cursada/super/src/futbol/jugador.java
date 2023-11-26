package futbol;

public class jugador {
    void correrLaPelota(){System.out.println("Corriendo la pelota");}
    void jugar(){correrLaPelota();}

    void jugarCon( jugador unJugador ) {
        unJugador.jugar();
        jugar();
    }
}
