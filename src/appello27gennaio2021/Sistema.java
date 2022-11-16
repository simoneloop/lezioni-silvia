package appello27gennaio2021;
import java.util.*;
public class Sistema {
	private LinkedList<Fornitore> fornitori;
	private LinkedList<Merce> merci;
	
	public Sistema(LinkedList<Fornitore> fornitori,LinkedList<Merce> merci) {
		this.fornitori=fornitori;
		this.merci=merci;
	}
	public LinkedList<String> grandiFornitori(){
		LinkedList<String> res= new LinkedList<>();
		LinkedList<Integer> occorrenze= new LinkedList<>();
		for(Fornitore f: fornitori) {
			int conta=contaFornitoriInMerci(f);
			occorrenze.add(conta);
		}
		int massimo=occorrenze.get(0);
		for(int i=1; i<occorrenze.size(); i++) {
			if(massimo<occorrenze.get(i)) {
				massimo=occorrenze.get(i);
			}
		}
		for(int j=0; j<occorrenze.size(); j++){
			if(occorrenze.get(j)==massimo) {
				res.add(fornitori.get(j).getNome());
			}
		}
		return res;
	}
	private int contaFornitoriInMerci(Fornitore f){
		int contatore=0;
		for(Merce m: merci) {
			LinkedList<String> fornitori=m.getFornitori();
			if(fornitori.contains(f.getNome())) {
				contatore++;
			}
		}
		return contatore;
	}
	public LinkedList<String> fornitoriMonoMarca(String marca){
		LinkedList<String> res= new LinkedList<>();
		for(Fornitore f: fornitori) {
			if(!fornitoriTraditori(marca,f.getNome())) {
				res.add(f.getNome());
			}
		}
		return res;
	}
	private boolean fornitoriTraditori(String marca, String nome) {
		for(Merce m: merci) {
			if(!m.getMarca().equals(marca) && m.getFornitori().contains(nome)) {
				return true;
			}
		}
		return false;
	}
	public LinkedList<String> merciCittaDiverse(){
		LinkedList<String> res= new LinkedList<>();
		for(Merce m: merci) {
			LinkedList<String> fornitori=m.getFornitori();
			LinkedList<String> citta= new LinkedList<>();
			for(int i=0; i<fornitori.size(); i++) {
				String cittaFornitore=cittaFornitore(fornitori.get(i));
				if(!cittaFornitore.contains(cittaFornitore)) {
					citta.add(cittaFornitore);
				}
			}
			if(citta.size()>=2) {
				res.add(m.getMarca());
			}
		}
		return res;
	}
	private String cittaFornitore(String nome) {
		String nomeCitta=null;
		for(Fornitore f: fornitori) {
			if(f.getNome().equals(nome)) {
				nomeCitta=f.getCitta();
			}
		}
		return nomeCitta;
	}
}
