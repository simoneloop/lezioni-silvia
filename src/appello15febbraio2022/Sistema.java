package appello15febbraio2022;
import java.util.*;
public class Sistema {
	private LinkedList<Prodotto> prodotti;
	private LinkedList<Fattura> fatture;
	
	public Sistema(LinkedList<Prodotto> prodotti,LinkedList<Fattura> fatture ) {
		this.prodotti=prodotti;
		this.fatture=fatture;
	}
	
	public int numeroEsemplariMarca(String m) {
		int numeroComplessivo=0;
		LinkedList<String> prodottiMarca= prodottiDellaMarca(m);
		int somma=0;
		for(int i=0; i<prodottiMarca.size(); i++) {
			for(Fattura f: fatture) {
				LinkedList<String> prodotti= f.getProdotti();
				LinkedList<Integer> quantita= f.getQuantita();
				for(int j=0; j<prodotti.size(); j++) {
					if(prodottiMarca.get(i).equals(prodotti.get(j))) {
						somma+=quantita.get(j);
						//System.out.println("Somma: "+somma);
					}
				}
			}
			if(somma>numeroComplessivo) {
				numeroComplessivo=somma;
			}
		}
		return numeroComplessivo;
	}
	private LinkedList<String> prodottiDellaMarca(String m){
		LinkedList<String> nomi= new LinkedList<>();
		for(Prodotto p: prodotti) {
			if(p.getMarca().equals(m)) {
				nomi.add(p.getNome());
			}
		}
		//System.out.println("Lista dei prodotti di marca "+m+": "+nomi);
		return nomi;
	}
	
	public LinkedList<String> marcheInComune(String nomeCliente){
		LinkedList<String> res= new LinkedList<>();
		for(Fattura f: fatture) {
			LinkedList<String> acquistiCliente= acquistiCliente(nomeCliente);
	//		System.out.println("La lista dei prodotti di "+nomeCliente+" è :"+acquistiCliente);
			LinkedList<String> acquistiAltriClienti= acquistiAltriClienti(nomeCliente);
	//		System.out.println("La lista dei prodotti dei clienti diversi da "+nomeCliente+" è :"+acquistiAltriClienti);
			for(int i=0; i<acquistiCliente.size(); i++) {
				for(int j=0; j<acquistiAltriClienti.size(); j++) {
					if(getMarca(acquistiCliente.get(i)).equals(getMarca(acquistiAltriClienti.get(j))) && 
						!res.contains(f.getCliente())&&	f.getCliente()!=nomeCliente) {
						res.add(f.getCliente());
					}
				}
			}
		}
		return res;
	}
	private LinkedList<String> acquistiCliente(String nomeCliente){
		LinkedList<String> res= new LinkedList<>();
		for(Fattura f: fatture) {
			if(nomeCliente.equals(f.getCliente())) {
				res.addAll(f.getProdotti());
			}
		}
		return res;
	}
	private LinkedList<String> acquistiAltriClienti(String nomeCliente){
		LinkedList<String> res= new LinkedList<>();
		for(Fattura f: fatture) {
			if(!f.getCliente().equals(nomeCliente)) {
				res.addAll(f.getProdotti());
			}
		}
		return res;
	}
	private String getMarca(String prodotto) {
		String nomeMarca=null;
		for(Prodotto p: prodotti) {
			if(p.getNome().equals(prodotto)) {
				nomeMarca=p.getMarca();
			}
		}
		return nomeMarca;
	}
	
	public float maxCostoFattura(int d) {
		float massimo=0;
		for(Fattura f: fatture) {
			if(f.getData()==d) {
				float somma=0;
				LinkedList<String> prodotti=f.getProdotti();
				LinkedList<Integer> quantita=f.getQuantita();
				for(int i=0; i<prodotti.size(); i++){
					float prezzo= getPrezzo(prodotti.get(i));
					//System.out.println("Prezzo: "+prezzo);
					somma+=prezzo*quantita.get(i);
					//System.out.println("Somma: "+somma);
				}
				if(somma>massimo) {
					massimo=somma;
				}
			}
		}
		return massimo;
	}
	private float getPrezzo(String prodotto) {
		float prezzo=0;
		for(Prodotto p: prodotti) {
			if(p.getNome().equals(prodotto)) {
				prezzo=p.getPrezzoUnitario();
			}
		}
		return prezzo;
	}
}
