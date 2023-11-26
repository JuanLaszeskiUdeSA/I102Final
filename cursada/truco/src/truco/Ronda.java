package truco;

import java.util.ArrayList;
import java.util.Objects;

public class Ronda {
    public static String noEsTurnoErrorDescription = "No es turno";
    private ArrayList<Carta> cartasDeManoDisponibles = new ArrayList<Carta>();
    private ArrayList<Carta> cartasDePieDisponibles = new ArrayList<Carta>();

    private ArrayList<Carta> cartasDeManoJugadas = new ArrayList<Carta>();

    private ArrayList<Carta> cartasDePieJugadas = new ArrayList<Carta>();
    private String turno;
    public Ronda(ArrayList<Carta> cartasDeManoDisponibles, ArrayList<Carta> cartasDePieDisponibles, ArrayList<Carta> cartasDeManoJugadas, ArrayList<Carta> cartasDePieJugadas) {}

    public Ronda() {}

    public Ronda with(ArrayList<Carta> cartasDeMano, ArrayList<Carta> cartasDePie) {
        cartasDeManoDisponibles = cartasDeMano;
        cartasDePieDisponibles = cartasDePie;
        cartasDeManoJugadas = new ArrayList<Carta>();
        cartasDePieJugadas = new ArrayList<Carta>();

        return new Ronda(cartasDeManoDisponibles, cartasDePieDisponibles, cartasDeManoJugadas, cartasDePieJugadas);
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public boolean turnoMano(){
        return Objects.equals(getTurno(), "mano");
    }

    public boolean turnoPie(){
        return Objects.equals(getTurno(), "pie");
    }

    private String getTurno() {
        return turno;
    }

    public void manoJuega(Carta unaCarta) {
        if (turnoMano()){
            cartasDeManoJugadas.add(unaCarta);
            cartasDeManoDisponibles.remove(unaCarta);
            setTurno("pie");
        }
        else {
            throw new Error(noEsTurnoErrorDescription);
        }
    }

    public ArrayList<Carta> getManoJugadas() {
        return cartasDeManoJugadas;
    }
}
