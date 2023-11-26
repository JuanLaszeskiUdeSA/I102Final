package truco;

import java.util.ArrayList;
import java.util.List;

public class Ronda {

	public static String cartaNoDisponibleErrorDescription = "Carta no disponible";
	public static String noEsTurnoErrorDescription = "No es turno";
	private List<Carta> cartasDeManoDisponibles;
	private List<Carta> cartasDePieDisponibles;
	private List<Carta> cartasDeManoJugadas;
	private List<Carta> cartasDePieJugadas;
	private String turno;

	public Ronda() {}
	public Ronda(List<Carta> cartasDeManoDisponibles, List<Carta> cartasDePieDisponibles,
				 List<Carta> cartasDeManoJugadas, List<Carta> cartasDePieJugadas) {
		this.cartasDeManoDisponibles = cartasDeManoDisponibles;
		this.cartasDePieDisponibles = cartasDePieDisponibles;
		this.cartasDeManoJugadas = cartasDeManoJugadas;
		this.cartasDePieJugadas = cartasDePieJugadas;
	}	

	public Ronda with(List<Carta> cartasDeMano, List<Carta> cartasDePie ) {
		cartasDeManoDisponibles = new ArrayList<Carta> (cartasDeMano);
		cartasDePieDisponibles = new ArrayList<Carta>(cartasDePie);
		cartasDeManoJugadas = new ArrayList<Carta>();
		cartasDePieJugadas = new ArrayList<Carta>();

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

	public void manoJuega(Carta unaCarta) {
		if(turno == "mano") {
			if (cartasDeManoDisponibles.contains(unaCarta)) {
				cartasDeManoJugadas.add(unaCarta);
				setTurno("pie");
			} else {throw new Error(cartaNoDisponibleErrorDescription);}
		}
		else {throw new Error (noEsTurnoErrorDescription);}
	}

	public void pieJuega(Carta carta){
		if (turnoPie()) {
			if(turnoPie()){
				if (cartasDePieDisponibles.contains(carta)) {
					cartasDePieJugadas.add(carta);
					setTurno("mano");
				} else {throw new Error(cartaNoDisponibleErrorDescription);}
			}
		}
		else {throw new Error (noEsTurnoErrorDescription);}
	}

	private String getTurno() {return turno;}
	public List<Carta> getManoJugadas () {return cartasDeManoJugadas;}
	public List<Carta> getPieJugadas () {return cartasDePieJugadas;}
	public List<Carta> getManoDisponibles () {return cartasDeManoDisponibles;}
	public List<Carta> getPieDisponibles () {return cartasDePieDisponibles;}
}