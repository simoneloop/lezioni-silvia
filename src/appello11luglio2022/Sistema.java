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
		LinkedList<Ordine> ordiniInData= troviamoOrdini(d1,d2);
		float massimo=calcolaImporto(ordiniInData.get(0));
		res.add(tornaMarca(ordiniInData.get(0)));
		for(int i=1; i<ordiniInData.size(); i++) {
			if(massimo<calcolaImporto(ordiniInData.get(i)) && !res.contains(tornaMarca(ordiniInData.get(i)))){
				massimo=calcolaImporto(ordiniInData.get(i));
				res.clear();
				res.add(tornaMarca(ordiniInData.get(i)));
			}
			else if(massimo==calcolaImporto(ordiniInData.get(i))&& !res.contains(tornaMarca(ordiniInData.get(i)))) {
				res.add(tornaMarca(ordiniInData.get(i)));
			}
		}
		return res;
	}
	private LinkedList<Ordine> troviamoOrdini(int d1, int d2){
		LinkedList<Ordine> res= new LinkedList<>();
		for(Ordine or: ordini) {
			if(or.getData()>=d1 && or.getData()<=d2) {
				res.add(or);
			}
		}
		return res;
	}
	private float calcolaImporto(Ordine or) {
		float importo=0;
		String merce=or.getMerce();
		String fornitore=or.getFornitore();
		int quantita=or.getQuantita();
		for(Merce m: merci) {
			if(m.getNome().equals(merce)) {
				int i=0;
				for(String s: m.getListaFornitori()) {
					if(fornitore.equals(s)) {
						importo=quantita*m.getListaPrezzi().get(i); 
					}
					i++;
				}
			}
		}
		return importo;
	}
	private String tornaMarca(Ordine or) {
		String nomeMarca=null;
		for(Merce m:merci) {
			if(m.getNome().equals(or.getMerce())) {
				nomeMarca=m.getMarca();
			}
		}
		return nomeMarca;
	}
	
}
