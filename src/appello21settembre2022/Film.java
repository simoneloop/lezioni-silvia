package appello21settembre2022;

public class Film {
	private String titolo;
	private String regista;
	private int prezzoAcquisto;
	private int prezzoNoleggio;
	
	public Film(String titolo, String regista, int prezzoAcquisto, int prezzoNoleggio) {
		this.titolo=titolo;
		this.regista=regista;
		this.prezzoAcquisto=prezzoAcquisto;
		this.prezzoNoleggio=prezzoNoleggio;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getRegista() {
		return regista;
	}

	public void setRegista(String regista) {
		this.regista = regista;
	}

	public int getPrezzoAcquisto() {
		return prezzoAcquisto;
	}

	public void setPrezzoAcquisto(int prezzoAcquisto) {
		this.prezzoAcquisto = prezzoAcquisto;
	}

	public int getPrezzoNoleggio() {
		return prezzoNoleggio;
	}

	public void setPrezzoNoleggio(int prezzoNoleggio) {
		this.prezzoNoleggio = prezzoNoleggio;
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
		Film f=(Film) o;
		return f.getRegista().equals(regista) && f.getTitolo().equals(titolo) &&
				f.getPrezzoAcquisto()==prezzoAcquisto && f.getPrezzoNoleggio()==prezzoNoleggio;
	}
	public String toString() {
		return "Titolo: "+titolo+", regista "+regista+", prezzo acquisto "+prezzoAcquisto+", prezzo noleggio "+prezzoNoleggio;
	}
}
