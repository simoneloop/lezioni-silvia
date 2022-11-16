package appello27gennaio2021;

public class Fornitore {
	private String nome;
	private String citta;
	
	public Fornitore(String nome,String citta) {
		this.nome=nome;
		this.citta=citta;
	}
	public String getCitta() {
		return citta;
	}
	public String getNome() {
		return nome;
	} 
	
	
	public boolean equals(Object o) {
		if(o==null) {
			return false;
		}
		if(o==this) {
			return true;
		}
		if(!(o.getClass().equals(this.getClass()))) {
			return false;
		}
		Fornitore f=(Fornitore) o;
		return f.getNome().equals(nome) &&
				f.getCitta().equals(citta);
	}
	
	public String toString() {
		return "nome: "+nome+", città: "+citta;
	}
}
