package truco;

public class Carta {
	private String palo;
	private int numero;
	
	public Carta(String palo, int i) {
		this.palo = palo;
		this.numero = i;
	}

	private static Carta with(String palo, int i) {
		return new Carta(palo, i);
	}
	public static Carta Basto(int i) {
		return with("basto", i);
	}
	public static Carta Oro(int i) {
		return with("oro", i);
	}
	public static Carta Copa(int i) {
		return with("copa", i);
	}
	public static Carta Espada(int i) {
		return with("espada", i);
	}

	public boolean equals(Object obj) {
		Carta otraCarta = (Carta) obj;
		return this.palo == otraCarta.palo && this.numero == otraCarta.numero;
	}
}
