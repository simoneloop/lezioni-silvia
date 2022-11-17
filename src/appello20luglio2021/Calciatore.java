package appello20luglio2021;

public class Calciatore {
	private String nome;
	private String squadraAttuale;
	
	public Calciatore(String nome, String squadraAttuale) {
		this.nome=nome;
		this.squadraAttuale=squadraAttuale;
	}

	public String getNome() {
		return nome;
	}

	public String getSquadraAttuale() {
		return squadraAttuale;
	}
	public boolean equals(Object o) {
		if(o==this)
			return true;
		if(o==null)
			return false;
		if(!(o.getClass()).equals(this.getClass()))
			return false;
		Calciatore cal= (Calciatore) o;
		return cal.getNome().equals(nome) && cal.getSquadraAttuale().equals(squadraAttuale);
	}
	public String toString() {
		return "Nome calciatore: "+nome+";Squadra attuale: "+squadraAttuale;
	}
}
