package appello01febbario2022;
import java.util.*;
public class Intervento {
	private String nomeTecnico;
	private LinkedList<String> tipiOperazione;
	private int data;
	private int durata;
	
	public Intervento(String nomeTecnico, LinkedList<String> tipiOperazione, int data, int durata) {
		this.nomeTecnico=nomeTecnico;
		this.tipiOperazione=tipiOperazione;
		this.data=data;
		this.durata=durata;
	}

	public String getNomeTecnico() {
		return nomeTecnico;
	}

	public void setNomeTecnico(String nomeTecnico) {
		this.nomeTecnico = nomeTecnico;
	}

	public LinkedList<String> getTipiOperazione() {
		return tipiOperazione;
	}

	public void setTipiOperazione(LinkedList<String> tipiOperazione) {
		this.tipiOperazione = tipiOperazione;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public int getDurata() {
		return durata;
	}

	public void setDurata(int durata) {
		this.durata = durata;
	}
	public boolean equals(Object o) {
		if(o==this)
			return true;
		if(o==null)
			return false;
		if(!(o.getClass().equals(this.getClass())))
			return false;
		Intervento i= (Intervento) o;
		return i.getTipiOperazione().equals(tipiOperazione) && i.getNomeTecnico().equals(nomeTecnico)&&
				i.getData()==data && i.getDurata()==durata;
	}
	public String toString() {
		return "Nome tecnico: "+nomeTecnico+", tipi di operazioni: "+tipiOperazione+", in data: "+data+
				"per la durata di: "+durata;
	}
}
