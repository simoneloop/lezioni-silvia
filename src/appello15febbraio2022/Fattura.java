package appello15febbraio2022;
import java.util.*;
public class Fattura {
	private String ID;
	private String cliente;
	private int data;
	private LinkedList<String> prodotti;
	private LinkedList<Integer> quantita;
	
	public Fattura(String ID, String cliente, int data, LinkedList<String> prodotti, LinkedList<Integer> quantita) {
		this.ID=ID;
		this.cliente=cliente;
		this.data=data;
		this.prodotti=prodotti;
		this.quantita=quantita;
	}

	public String getID() {
		return ID;
	}

	public String getCliente() {
		return cliente;
	}

	public int getData() {
		return data;
	}

	public LinkedList<String> getProdotti() {
		return prodotti;
	}

	public LinkedList<Integer> getQuantita() {
		return quantita;
	}
	public boolean equals(Object o) {
		if(o==this)
			return true;
		if(o==null)
			return false;
		if(!(o.getClass().equals(this.getClass())))
			return false;
		Fattura f = (Fattura) o;
		return f.cliente.equals(cliente) && f.prodotti.equals(prodotti) && f.quantita.equals(quantita)&&
				f.data==data && f.ID==ID;		
	}
	public String toString() {
		return "ID: "+ID+ "Cliente: "+cliente+"Prodotti: "+prodotti+"QuantitÃ : "+quantita;
				
	}
}
