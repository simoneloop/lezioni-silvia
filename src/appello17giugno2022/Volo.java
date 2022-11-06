package appello17giugno2022;

public class Volo {
	private String partenza;
	private String arrivo;
	private int prezzoBusiness;
	private int prezzoEconomica;
	
	public Volo(String partenza, String arrivo, int prezzoBusiness, int prezzoEconomica) {
		this.partenza=partenza;
		this.arrivo=arrivo;
		this.prezzoBusiness=prezzoBusiness;
		this.prezzoEconomica=prezzoEconomica;
	}

	public String getPartenza() {
		return partenza;
	}

	public void setPartenza(String partenza) {
		this.partenza = partenza;
	}

	public String getArrivo() {
		return arrivo;
	}

	public void setArrivo(String arrivo) {
		this.arrivo = arrivo;
	}

	public int getPrezzoBusiness() {
		return prezzoBusiness;
	}

	public void setPrezzoBusiness(int prezzoBusiness) {
		this.prezzoBusiness = prezzoBusiness;
	}

	public int getPrezzoEconomica() {
		return prezzoEconomica;
	}

	public void setPrezzoEconomica(int prezzoEconomica) {
		this.prezzoEconomica = prezzoEconomica;
	}
	public boolean equals(Object o) {
		if(o==null) {
			return false;	
		}
		if(o==this) {
			return true;
		}
		if(!(o.getClass().equals(this.getClass()))){
			return false;
		}
		Volo v=(Volo) o;
		return v.getArrivo().equals(arrivo) && v.getPartenza().equals(partenza) &&
				v.getPrezzoBusiness()==prezzoBusiness && v.getPrezzoEconomica()==prezzoEconomica;
	}
	public String toString() {
		return "Partenza: "+partenza+", arrivo: "+arrivo+", prezzo business: "+prezzoBusiness+
				", prezzo economica: "+prezzoEconomica;
	}
}
