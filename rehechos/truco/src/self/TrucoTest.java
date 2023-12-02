package self;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

public class TrucoTest {
	@BeforeEach
	public void setUp() {
		ronda = new Ronda();
		ronda.setTurno("mano");
		anchoDeBasto = new Carta("basto", 1);
		sietDeBasto = new Carta("basto", 7);
		asDeOro = new Carta("oro", 1);
		asDeCopa = new Carta("copa", 1);
		sieteDeCopa = new Carta("copa", 7);
		anchoDeEspada = new Carta("espada", 1);
		cartasDeMano = new ArrayList<>();
		cartasDePie = new ArrayList<>();
	}
	
	@Test
    public void test01SiempreEmpiezaJugandoLaMano() {
			assertTrue(ronda.turnoMano());
			assertFalse(ronda.turnoPie());
	}
	
	@Test
	public void test02EnElPrimerEnfrentamientoLuegoDeLaManoJuegaElPie() {
		repartirCartas();
		ronda.with(cartasDeMano, cartasDePie);
		ronda.manoJuega(anchoDeBasto);
		assertFalse(ronda.turnoMano());
		assertTrue(ronda.turnoPie());		
	}
	
	@Test
	public void test03ManoNoPuedeJugarDosVeces() {
		repartirCartas();
		ronda.with(cartasDeMano, cartasDePie);
		ronda.manoJuega(anchoDeBasto);

		assertThrowsLike( () -> ronda.manoJuega(sietDeBasto), Ronda.noEsTurnoErrorDescription );
		assertFalse(ronda.turnoMano());
		assertTrue(ronda.turnoPie());
		assertEquals(anchoDeBasto, ronda.cartasDeManoJugadas().get(0));
	}

	@Test
	public void test04PieNoPuedeJugarDosVeces() {
		repartirCartas();
		ronda.with(cartasDeMano, cartasDePie);
		ronda.manoJuega(anchoDeBasto);
		ronda.pieJuega(asDeCopa);

		assertThrowsLike( () -> ronda.pieJuega(sieteDeCopa), Ronda.noEsTurnoErrorDescription );
		assertFalse(ronda.turnoPie());
		assertTrue(ronda.turnoMano());
		assertEquals(asDeCopa, ronda.cartasDePieJugadas().get(0));
	}

	@Test
	public void test05NoSePuedeJugarUnaCartaNoDisponible() {
		repartirCartas();
		ronda.with(cartasDeMano, cartasDePie);
		assertThrowsLike( () -> ronda.manoJuega(asDeCopa), Ronda.NoSeValeCartearse );

	}

	private void assertThrowsLike(Executable executable, String message ) {
	    assertEquals( message, assertThrows( Error.class, executable ).getMessage() );
	}

	private void repartirCartas() {
		cartasDeMano.add(anchoDeBasto);
		cartasDeMano.add(sietDeBasto);
		cartasDeMano.add(asDeOro);
		cartasDePie.add(asDeCopa);
		cartasDePie.add(sieteDeCopa);
		cartasDePie.add(anchoDeEspada);
	}

	private Ronda ronda;
	private Carta anchoDeBasto;
	private Carta sietDeBasto;
	private Carta asDeOro;
	private Carta asDeCopa;
	private Carta sieteDeCopa;
	private Carta anchoDeEspada;
	private ArrayList<Carta> cartasDeMano;
	private ArrayList<Carta> cartasDePie;
}




