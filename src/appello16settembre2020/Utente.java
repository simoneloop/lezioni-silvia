package appello16settembre2020;

public class Utente {
	private String nome;
	private String citta;
	
	public Utente(String nome, String citta) {
		this.nome=nome;
		this.citta=citta;
	}

	public String getNome() {
		return nome;
	}

	public String getCitta() {
		return citta;
	}
	public boolean equals(Object o) {
		if(o==this)
			return true;
		if(o==null)
			return false;
		if(!(o.getClass().equals(this.getClass())))
			return false;
		Utente u= (Utente) o;
		return u.nome.equals(nome) && u.citta.equals(citta);
	}
	public String toString() {
		return "Nome utente: "+nome+", la sua cittÃ : "+citta;
	}

}
