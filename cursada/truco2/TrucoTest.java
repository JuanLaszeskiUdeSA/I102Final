package truco;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class TrucoTest {

	Ronda ronda;
	List<Carta> cartasDeMano;
	List<Carta> cartasDePie;

	@BeforeEach
	public void setUp() {
		ronda = new Ronda();
		cartasDeMano = Arrays.asList(Carta.Basto(1), Carta.Basto(7), Carta.Oro(1));
		cartasDePie = Arrays.asList(Carta.Copa(1), Carta.Copa(7), Carta.Espada(1));
		ronda = ronda.with(cartasDeMano, cartasDePie);
	}
	
	@Test
    public void test01SiempreEmpiezaJugandoLaMano() {
			ronda.setTurno("mano");
			
			assertTrue(ronda.turnoMano());
			assertFalse(ronda.turnoPie());
	}
	
	@Test
	public void test02EnElPrimerEnfrentamientoLuegoDeLaManoJuegaElPie() {
		ronda.setTurno("mano");
		ronda.manoJuega(Carta.Basto(1));
		
		assertFalse(ronda.turnoMano());
		assertTrue(ronda.turnoPie());		
	}
	
	@Test
	public void test03EnElPrimerEnfrentamientoNoPuedeJugarLaManoDosVeces() {
		ronda.setTurno("mano");
		ronda.manoJuega(Carta.Basto(1));
		assertThrowsLike(() -> ronda.manoJuega(Carta.Basto(1)), Ronda.noEsTurnoErrorDescription);
		assertFalse(ronda.turnoMano());
		assertTrue(ronda.turnoPie());
		assertEquals(Carta.Basto(1), ronda.getManoJugadas().get(0));
	}

	@Test
	public void test04PieNoPuedeJugarCuandoLeTocaLaMano() {
		ronda.setTurno("mano");
		assertThrowsLike(() -> ronda.pieJuega(Carta.Copa(1)), Ronda.noEsTurnoErrorDescription);
		assertTrue(ronda.turnoMano());
		assertFalse(ronda.turnoPie());
		assertTrue(ronda.getManoJugadas().isEmpty());
	}

	@Test
	public void test05ManoSoloPuedeJugarCartasDisponibles(){
		ronda.setTurno("mano");
		assertThrowsLike(() -> ronda.manoJuega(Carta.Copa(2)), Ronda.cartaNoDisponibleErrorDescription);
		assertTrue(ronda.turnoMano());
		assertFalse(ronda.turnoPie());
		assertTrue(ronda.getManoJugadas().isEmpty());
	}

	@Test
	public void test06PieSoloPuedeJugarCartasDisponibles(){
		ronda.setTurno("mano");
		ronda.manoJuega(cartasDeMano.get(0));
		assertThrowsLike(() -> ronda.pieJuega(Carta.Basto(2)), Ronda.cartaNoDisponibleErrorDescription);
		assertFalse(ronda.turnoMano());
		assertTrue(ronda.turnoPie());
		assertEquals(Carta.Basto(1), ronda.getManoJugadas().get(0));
		assertTrue(ronda.getPieJugadas().isEmpty());
	}

	private void assertThrowsLike(Executable executable, String message) {
		assertEquals(message, assertThrows(Error.class, executable).getMessage());
	}
}