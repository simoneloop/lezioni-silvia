package appello16settembre2020;

public class Messaggio {
	private String nomeMittente;
	private String nomeDestinatario;
	private int data;
	private boolean letto;
	
	public Messaggio(String nomeMittente, String nomeDestinatario, int data, boolean letto) {
		this.nomeMittente= nomeMittente;
		this.nomeDestinatario= nomeDestinatario;
		this.data=data;
		this.letto=letto;
	}

	public String getNomeMittente() {
		return nomeMittente;
	}

	public String getNomeDestinatario() {
		return nomeDestinatario;
	}

	public int getData() {
		return data;
	}
	
	public boolean letto() {
		return letto;
	}
	public boolean equals(Object o) {
		if(o==this)
			return true;
		if(o==null)
			return false;
		if(!(o.getClass().equals(this.getClass())))
			return false;
		Messaggio m= (Messaggio) o;
		return m.nomeMittente.equals(nomeMittente) && m.nomeDestinatario.equals(nomeDestinatario) &&
				m.data==data && m.letto==letto;
	
	}
	public String toString() {
		return "Nome mittente: "+nomeMittente+", nome destinatario: "+nomeDestinatario+
				", in data: "+data+ "Ã¨ stato letto? "+letto;
	}
	
}
