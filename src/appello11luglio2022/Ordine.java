package appello11luglio2022;

public class Ordine {
	private String iD;
	private String merce;
	private int quantita;
	private String fornitore;
	private int data;
	
	public Ordine(String iD, String merce, int quantita, String fornitore, int data ) {
		this.iD=iD;
		this.merce=merce;
		this.quantita=quantita;
		this.fornitore=fornitore;
		this.data=data;
	}

	public String getiD() {
		return iD;
	}

	public void setiD(String iD) {
		this.iD = iD;
	}

	public String getMerce() {
		return merce;
	}

	public void setMerce(String merce) {
		this.merce = merce;
	}

	public int getQuantita() {
		return quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}

	public String getFornitore() {
		return fornitore;
	}

	public void setFornitore(String fornitore) {
		this.fornitore = fornitore;
	}
	
	public int getData() {
		return data;
	}
	
	public void setData(int data) {
		this.data=data;
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
		Ordine or=(Ordine) o;
		return or.getFornitore().equals(fornitore) && or.getiD().equals(iD) && or.getMerce().equals(merce) &&
				or.getQuantita()==quantita && or.getData()==data;
	}
	public String toString() {
		return "ID: "+iD+", Merce: "+merce+", Quantità: "+quantita+", Fornitore: "+fornitore+
				", Data: "+data;
	}

}
