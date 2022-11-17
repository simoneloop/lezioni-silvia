package appello15febbraio2022;

public class Prodotto {
	private String nome;
	private String marca;
	private float prezzoUnitario;
	
	public Prodotto(String nome, String marca, float prezzoUnitario) {
		this.nome=nome;
		this.marca=marca;
		this.prezzoUnitario=prezzoUnitario;
	}

	public String getNome() {
		return nome;
	}

	public String getMarca() {
		return marca;
	}

	public float getPrezzoUnitario() {
		return prezzoUnitario;
	}
	public boolean equals(Object o) {
		if(o==this)
			return true;
		if(o==null)
			return false;
		if(!(o.getClass().equals(this.getClass())))
			return false;
		Prodotto p = (Prodotto) o;
		return p.nome.equals(nome)&& p.marca.equals(marca)&& p.prezzoUnitario==prezzoUnitario;
	}
	public String toString() {
		return "Il prodotto "+nome+"della marca "+marca+"ha il prezzo (in euro) pari a "+prezzoUnitario;
	}
}
