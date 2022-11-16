package appello23luglio2020;

public class Squadra {
	private String nome;
	private String citta;
	
	public Squadra(String nome, String citta) {
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
		if (o==this)
			return true;
		if (o==null)
			return false;
		if (!(o.getClass().equals(this.getClass())))
			return false;
		Squadra s= (Squadra) o;
		return s.nome.equals(nome)&& s.citta.equals(citta);			
	}
	public String toString() {
		return "Nome della squadra: "+nome+",la città  dove gioca: "+citta;
	}
}
