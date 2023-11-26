package truco;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


public class TrucoTest {
    @Test
    public void test01() {
        Ronda ronda = new Ronda();
        ronda.setTurno("mano");

        assertTrue(ronda.turnoMano());
        assertFalse(ronda.turnoPie());
    }

    @Test
    public void test02EnElPrimerEnfrentamientoDespuesDeLaManoJuegaElPie() {
        Ronda ronda = new Ronda();

        ArrayList<Carta> cartasDeMano = new ArrayList<Carta>();
        ArrayList<Carta> cartasDePie = new ArrayList<Carta>();

        Carta anchodeBasto = new Carta("Basto", 1);
        Carta sieteDeBasto = new Carta("Basto", 7);
        Carta asDeOro = new Carta("Oro", 1);
        Carta sieteDeCopa = new Carta("Copa", 7);
        Carta asDeCopa = new Carta("Copa", 1);
        Carta anchoDeEspada = new Carta("Espada", 1);

        cartasDeMano.add(anchodeBasto);
        cartasDeMano.add(sieteDeBasto);
        cartasDeMano.add(asDeOro);
        cartasDePie.add(sieteDeCopa);
        cartasDePie.add(asDeCopa);
        cartasDePie.add(anchoDeEspada);

        ronda.with(cartasDeMano, cartasDePie);
        ronda.setTurno("mano");
        ronda.manoJuega(anchodeBasto);
    }

    @Test
    public void test03EnElPrimerEnfrentamientoLaManoJuegaDosVeces() {
        Ronda ronda = new Ronda();

        ArrayList<Carta> cartasDeMano = new ArrayList<Carta>();
        ArrayList<Carta> cartasDePie = new ArrayList<Carta>();

        Carta anchodeBasto = new Carta("Basto", 1);
        Carta sieteDeBasto = new Carta("Basto", 7);
        Carta asDeOro = new Carta("Oro", 1);
        Carta sieteDeCopa = new Carta("Copa", 7);
        Carta asDeCopa = new Carta("Copa", 1);
        Carta anchoDeEspada = new Carta("Espada", 1);

        cartasDeMano.add(anchodeBasto);
        cartasDeMano.add(sieteDeBasto);
        cartasDeMano.add(asDeOro);
        cartasDePie.add(sieteDeCopa);
        cartasDePie.add(asDeCopa);
        cartasDePie.add(anchoDeEspada);

        ronda.with(cartasDeMano, cartasDePie);
        ronda.setTurno("mano");
        ronda.manoJuega(anchodeBasto);

        try {
            ronda.manoJuega(sieteDeBasto);
        } catch (Error e) {
            assertEquals(e.getMessage(), Ronda.noEsTurnoErrorDescription);
            assertFalse(ronda.turnoMano());
            assertTrue(ronda.turnoPie());
            assertEquals(anchodeBasto, ronda.getManoJugadas().get(0));
        }
    }
}
