package appello17giugno2022;
import java.util.*;
public class Prenotazione {
	private LinkedList<String> percorso;
	private String nomeCliente;
	private String classe;
	
	public Prenotazione(LinkedList<String> percorso, String nomeCliente, String classe) {
		this.percorso=percorso;
		this.nomeCliente=nomeCliente;
		this.classe=classe;
	}

	public LinkedList<String> getPercorso() {
		return percorso;
	}

	public void setPercorso(LinkedList<String> percorso) {
		this.percorso = percorso;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
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
		Prenotazione p=(Prenotazione) o;
		return p.getClasse().equals(classe) && p.getNomeCliente().equals(nomeCliente) &&
				p.getPercorso().equals(percorso);
	}
	public String toString() {
		return "Percorso: "+percorso+", cliente: "+nomeCliente+", classe: "+classe;
	}
}
