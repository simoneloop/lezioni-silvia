package appello21settembre2022;
import java.util.*;
public class Cliente {
	private String nome;
	private LinkedList<String> titoli;
	private LinkedList<String> modalita;
	private LinkedList<Integer> date;
	 public Cliente(String nome, LinkedList<String> titoli, LinkedList<String> modalita, LinkedList<Integer>date ) {
		 this.titoli=titoli;
		 this.nome=nome;
		 this.modalita=modalita;
		 this.date=date;
	 }
	
	public LinkedList<Integer> getDate() {
		return date;
	}
	
	public LinkedList<String> getModalita() {
		return modalita;
	}
	
	public String getNome() {
		return nome;
	}
	
	public LinkedList<String> getTitoli() {
		return titoli;
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
		Cliente c=(Cliente) o;
		return nome.equals(c.getNome())&& titoli.equals(c.getTitoli())&& modalita.equals(c.getModalita())&& date.equals(c.getDate());
	}
	public String toString() {
		return "nome: "+nome+" , titoli film: "+titoli+" ,modalità: "+modalita+" ,"+"in date: "+date;
	}

}