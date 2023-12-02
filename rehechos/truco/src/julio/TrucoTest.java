package julio;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TrucoTest {
	
	@Test
    public void test01SiempreEmpiezaJugandoLaMano() {
			Ronda ronda = new Ronda();
			ronda.setTurno("mano");
			
			assertTrue(ronda.turnoMano());
			assertFalse(ronda.turnoPie());
	}
	
	@Test
	public void test02EnElPrimerEnfrentamientoLuegoDeLaManoJuegaElPie() {
		Ronda ronda = new Ronda();
		ArrayList<Carta> cartasDeMano = new ArrayList<Carta>();
		ArrayList<Carta> cartasDePie = new ArrayList<Carta>();
		
		Carta anchoDeBasto = new Carta("basto", 1);
		Carta sietDeBasto = new Carta("basto", 7);
		Carta asDeOro = new Carta("oro", 1);
		Carta asDeCopa = new Carta("copa", 1);
		Carta sieteDeCopa = new Carta("copa", 7);
		Carta anchoDeEspada = new Carta("espada", 1);
		
		cartasDeMano.add(anchoDeBasto);
		cartasDeMano.add(sietDeBasto);
		cartasDeMano.add(asDeOro);
		cartasDePie.add(asDeCopa);
		cartasDePie.add(sieteDeCopa);
		cartasDePie.add(anchoDeEspada);
		
		ronda.with(cartasDeMano, cartasDePie);
		ronda.setTurno("mano");
		ronda.manoJuega(anchoDeBasto);
		
		assertFalse(ronda.turnoMano());
		assertTrue(ronda.turnoPie());		
	}
	
	@Test
	public void test03() {
		
		Ronda ronda = new Ronda();
		ArrayList<Carta> cartasDeMano = new ArrayList<Carta>();
		ArrayList<Carta> cartasDePie = new ArrayList<Carta>();
		
		Carta anchoDeBasto = new Carta("basto", 1);
		Carta sietDeBasto = new Carta("basto", 7);
		Carta asDeOro = new Carta("oro", 1);
		Carta asDeCopa = new Carta("copa", 1);
		Carta sieteDeCopa = new Carta("copa", 7);
		Carta anchoDeEspada = new Carta("espada", 1);
		
		cartasDeMano.add(anchoDeBasto);
		cartasDeMano.add(sietDeBasto);
		cartasDeMano.add(asDeOro);
		cartasDePie.add(asDeCopa);
		cartasDePie.add(sieteDeCopa);
		cartasDePie.add(anchoDeEspada);
		
		ronda.with(cartasDeMano, cartasDePie);
		ronda.setTurno("mano");
		ronda.manoJuega(anchoDeBasto);
		
		try {
			ronda.manoJuega(sietDeBasto);
		}catch(Error e) {
			assertTrue(e.getMessage().equals(ronda.noEsTurnoErrorDescription) );
			assertFalse(ronda.turnoMano());
			assertTrue(ronda.turnoPie());	
			//asertar que la carta jugada es efectivamente el anchoDeBasto
			
		}
		
		
	}
}




