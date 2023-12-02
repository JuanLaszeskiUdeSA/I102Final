package self;

public class Carta {
	private String palo;
	private int numero;
	
	public Carta(String palo, int i) {
		this.palo = palo;
		this.numero = i;
	}

	public String getPalo() {
		return palo;
	}
	public int getNumero() {
		return numero;
	}

	@Override
	public boolean equals(Object obj) {
		return this == obj ||
				( obj != null &&
				  getClass() == obj.getClass() &&
				  palo.equals( ((Carta)obj).palo ) &&
				  numero == ((Carta)obj).numero );
	}


}
