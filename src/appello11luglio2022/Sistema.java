package appello11luglio2022;
import java.util.*;
public class Sistema {
	private LinkedList<Merce> merci;
	private LinkedList<Ordine> ordini;
	
	public Sistema(LinkedList<Merce> merci, LinkedList<Ordine> ordini) {
		this.merci=merci;
		this.ordini=ordini;
	}
	public boolean verificaMerciEOrdini() {
		if(verificaMerci() && verificaOrdini()) {
			return true;
		}
		return false;
	}
	private boolean verificaMerci() {
		for(Merce m: merci) {
			String marca=m.getMarca();
			LinkedList<String> lista=m.getListaFornitori();
			LinkedList<Float> prezzi=m.getListaPrezzi();
			if(lista.size()==prezzi.size() && !lista.contains(marca)) {
				return true;
			}
		}
		return false;
		
	}
	private boolean verificaOrdini() {
		boolean verifica;
		for(Ordine or: ordini) {
			verifica=false;
			String merceIndicata=or.getMerce();
			for(Merce m: merci) {
				LinkedList<String> lFornitori=m.getListaFornitori();
				if(merceIndicata.equals(m.getNome())&&lFornitori.contains(or.getFornitore())) {
					verifica=true;
				}
			}
			if(!verifica) {
				return false;
			}
		}
		return true;
	}
	
	public LinkedList<String> merciSopraSoglia(float sogliaMinima, float sogliaMedia){
		if(!verificaMerciEOrdini()) {
			return null;
		}
		LinkedList<String> res= new LinkedList<>();
		for(Merce m: merci) {
			LinkedList<String> listaFornitori=m.getListaFornitori();
			LinkedList<Float> listaPrezzi=m.getListaPrezzi();
			if(listaFornitori.size()>=1 && trovaMin(listaPrezzi)>sogliaMinima && trovaMedia(listaPrezzi)>sogliaMedia) {
				res.add(m.getMarca());
			}
		}
		return res;
	}
	private float trovaMin(LinkedList<Float> lista) {
		float minimo;
		ListIterator<Float> it=lista.listIterator();
		minimo=it.next();
		while(it.hasNext()) {
			float t2=it.next();
			if(minimo>t2) {
				minimo=t2;
			}
		}
		return minimo;
	}
	private float trovaMedia(LinkedList<Float> lista) {
		float media;
		ListIterator<Float> it= lista.listIterator();
		media=it.next();
		while(it.hasNext()) {
			media+=it.next();
		}
		return media/lista.size();
	}
	
	public LinkedList<String> marcheOrdiniMassimi(int d1, int d2){
		if(!verificaMerciEOrdini()) {
			return null;
		}
		LinkedList<String> res= new LinkedList<>();
		for(Merce m: merci) {
			
		}
		
		return res;
	}
	private float calcolaImporto(LinkedList<Float> listaPrezzi, LinkedList<String> listaFornitori,int d1, int d2) {
		LinkedList<Float> listaImporti= new LinkedList<>();
		float massimo=0;
		for(int i=0; i<listaPrezzi.size(); i++) {
			for(Ordine or: ordini) {
				if(listaFornitori.get(i).equals(or.getFornitore())&& d1>=or.getData() && d2<=or.getData()) {
					listaImporti.add(or.getQuantita()*listaPrezzi.get(i));
				}
				ListIterator<Float> it=listaImporti.listIterator();
				massimo=it.next();
				while(it.hasNext()) {
					float t1=it.next();
					if(massimo>t1) {
						massimo=t1;
					}
				}
			}
		}
		return massimo;
	}
	
}
