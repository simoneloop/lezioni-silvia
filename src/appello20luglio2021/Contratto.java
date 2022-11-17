package appello20luglio2021;
import java.util.*;
public class Contratto {
	private String squadra;
	private String calciatore;
	private int prezzo;
	private LinkedList<Integer> premi;
	
	public Contratto(String squadra, String calciatore, int prezzo, LinkedList<Integer> premi) {
		this.squadra=squadra;
		this.calciatore=calciatore;
		this.prezzo=prezzo;
		this.premi=premi;
	}

	public String getSquadra() {
		return squadra;
	}

	public String getCalciatore() {
		return calciatore;
	}

	public int getPrezzo() {
		return prezzo;
	}

	public LinkedList<Integer> getPremi() {
		return premi;
	}
	public boolean equals(Object o) {
		if(o==this)
			return true;
		if(o==null)
			return false;
		if(!(o.getClass()).equals(this.getClass()))
			return false;
		Contratto con= (Contratto) o;
		return con.getCalciatore().equals(calciatore)&& con.getPremi().equals(premi)&& 
				con.getSquadra().equals(squadra)&& con.getPrezzo()==prezzo;
	}
	public String toString() {
		return "Nome squadra: "+squadra+";Nome calciatore: "+calciatore+";Prezzo: "+prezzo+
				";Premi: "+premi;
	}
}
