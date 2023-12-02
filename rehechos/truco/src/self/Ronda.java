package self;

import java.util.ArrayList;

public class Ronda {

	public static final String NoSeValeCartearse = "No se puede jugar una carta no disponible";
	public static String noEsTurnoErrorDescription = "No es turno";
	private ArrayList<Carta> cartasDeManoDisponibles;
	private ArrayList<Carta> cartasDePieDisponibles;
	private ArrayList<Carta> cartasDeManoJugadas;
	private ArrayList<Carta> cartasDePieJugadas;
	private String turno;

	public Ronda(ArrayList<Carta> cartasDeManoDisponibles, ArrayList<Carta> cartasDePieDisponibles,
							ArrayList<Carta> cartasDeManoJugadas, ArrayList<Carta> cartasDePieJugadas ) {
		this.cartasDeManoDisponibles = cartasDeManoDisponibles;
		this.cartasDePieDisponibles = cartasDePieDisponibles;
		this.cartasDeManoJugadas = cartasDeManoJugadas;
		this.cartasDePieJugadas = cartasDePieJugadas;
		this.turno = "mano";
	}	
	public Ronda() {}
	
	public Ronda with(ArrayList<Carta> cartasDeMano, ArrayList<Carta> cartasDePie ) {
		cartasDeManoDisponibles = cartasDeMano;
		cartasDePieDisponibles = cartasDePie;
		cartasDeManoJugadas = new ArrayList<>();
		cartasDePieJugadas = new ArrayList<>();

		return new Ronda(cartasDeManoDisponibles, cartasDePieDisponibles, cartasDeManoJugadas, cartasDePieJugadas );
	}
	
	public void setTurno(String turno) {
		this.turno = turno;
	}

	public boolean turnoMano() {
		return getTurno()== "mano" ;
	}

	public boolean turnoPie() {
		return getTurno()== "pie";
	}

	public void manoJuega(Carta carta) {
		if(turno == "mano") {
			if (!cartasDeManoDisponibles.contains(carta)) {
				throw new Error (NoSeValeCartearse);
			}
			cartasDeManoJugadas.add(carta);
			setTurno("pie");
		}
		else {
			throw new Error (noEsTurnoErrorDescription);
		}
	}

	public void pieJuega(Carta asDeCopa) {
		if(turno == "pie") {
			if (!cartasDePieDisponibles.contains(asDeCopa)) {
				throw new Error (NoSeValeCartearse);
			}
			cartasDePieJugadas.add(asDeCopa);
			setTurno("mano");
		}
		else {
			throw new Error (noEsTurnoErrorDescription);
		}
	}


	//Accesors

	private String getTurno() {
		return turno;
	}

	public ArrayList<Carta> cartasDeManoJugadas() {
		return cartasDeManoJugadas;
	}
	public ArrayList<Carta> cartasDePieJugadas() {
		return cartasDePieJugadas;
	}

}
