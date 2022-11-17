package appello20luglio2021;
import java.util.*;
public class Sistema {
	private LinkedList<Contratto> contratti;
	private LinkedList<Calciatore> calciatori;
	
	public Sistema(LinkedList<Contratto> contratti, LinkedList<Calciatore> calciatori) {
		this.contratti=contratti;
		this.calciatori=calciatori;
	}
	public boolean verificaDati() {
		for(Contratto c: contratti) {
			if(!verificaCalciatori(c)) {
				return false;
			}
		}
		return true;
	}
	private boolean verificaCalciatori(Contratto c) {
		for(Calciatore cal: calciatori) {
			if(c.getCalciatore().equals(cal.getNome()) && c.getSquadra().equals(cal.getSquadraAttuale())) {
				return false;
			}
		}
		return true;
	}
	
	public LinkedList<String> squadreAttive(int pMin){
		LinkedList<String> res= new LinkedList<>();
		LinkedList<String> squadreUniche= new LinkedList<>();
		for(Contratto c: contratti) {
			if(!squadreUniche.contains(c.getSquadra())) {
				squadreUniche.add(c.getSquadra());
			}
		}
		LinkedList<String> squadreScremate= scrematuraSquadre(squadreUniche,pMin);
		for(int i=0; i<squadreScremate.size(); i++) {
			LinkedList<String> squadreDiverse= new LinkedList<>();
			for(Contratto c: contratti) {
				if(squadreScremate.get(i).equals(c.getSquadra()) && !squadreDiverse.contains(getsquadraAttuale(c.getCalciatore()))) {
					squadreDiverse.add(getsquadraAttuale(c.getCalciatore()));
				}
			}
			if(squadreDiverse.size()>=3) {
				res.add(squadreScremate.get(i));
			}
		}
		return res;
	}
	private LinkedList<String> scrematuraSquadre(LinkedList<String> squadreUniche, int pMin){
		LinkedList<String> risultato= new LinkedList<>();
		for(int i=0; i<squadreUniche.size(); i++) {
			int contatore=0;
			int prezzo=0;
			for(Contratto c: contratti) {
				if(c.getSquadra().equals(squadreUniche.get(i))) {
					contatore++;
					prezzo+=c.getPrezzo();
				}
			}
			if(contatore>=3 && prezzo>=pMin) {
				risultato.add(squadreUniche.get(i));
			}
		}
		return risultato;
		
	}
	private String getsquadraAttuale(String nome) {
		String nomeSquadra=null;
		for(Calciatore cal: calciatori) {
			if(cal.getNome().equals(nome)) {
				nomeSquadra=cal.getSquadraAttuale();
			}
		}
		return nomeSquadra;
	}
	
	public LinkedList<String> calciatoriPocoPremiati(int pMax){
		LinkedList<String> res= new LinkedList<>();
		for(Contratto c: contratti) {
			LinkedList<Integer> premi=c.getPremi();
			if(verificaPremi(pMax,premi)) {
				res.add(c.getCalciatore());
			}
		}
		return res;
	}
	private boolean verificaPremi(int pMax, LinkedList<Integer> premi) {
		for(int i=0; i<premi.size(); i++) {
			if(premi.get(i)>pMax) {
				return false;
			}
		}
		return true;
	}
}
