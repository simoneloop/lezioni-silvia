package appello23luglio2020;
import java.util.*;
public class Sistema {
	private LinkedList<Squadra> squadre;
	private LinkedList<Partita> partite;
	
	public Sistema(LinkedList<Squadra> squadre, LinkedList<Partita> partite) {
		this.squadre=squadre;
		this.partite=partite;
	}
	public LinkedList<String> squadreCasalinghe(){
		LinkedList<String> res= new LinkedList<>();
		LinkedList<Integer> occorrenze= new LinkedList<>();
		for(Squadra s: squadre) {
			int contaVittorie= contaVittorie(s);
			occorrenze.add(contaVittorie);
		}
		int massimo=occorrenze.get(0);
		for(int j=0; j<squadre.size(); j++) {
			if(massimo<occorrenze.get(j)) {
				massimo=occorrenze.get(j);	
			}
		}
		for(int i=0; i<occorrenze.size(); i++){
			if(occorrenze.get(i)==massimo) {
				res.add(squadre.get(i).getNome());
			}
		}
		return res;
	}
	private int contaVittorie(Squadra s) {
		int contatore=0;
		for(Partita p: partite) {
			String squadraCasa=p.getNomeSquadraInCasa();
			if(squadraCasa.equals(s.getNome())&& p.getGoalSquadraInCasa()>p.getGoalSquadraOspite()) {
				contatore++;
			}
		}
		return contatore;
	}
	
	public LinkedList<String> arbitriFuoriCitta(){
		LinkedList<String> res= new LinkedList<>();
		for(Partita p: partite) {
			LinkedList<String> squadreArbitrate= squadreArbitrate(p.getNomeArbitro());
				if(!verificaCitta(squadreArbitrate,p.getCittaArbitro())&& !res.contains(p.getNomeArbitro())) {
					res.add(p.getNomeArbitro());
				}
		}
		return res;
	}
	private LinkedList<String> squadreArbitrate(String arbitro){
		LinkedList<String> nomiSquadre= new LinkedList<>();
		for(Partita p: partite) {
			if(arbitro.equals(p.getNomeArbitro())&& !nomiSquadre.contains(p.getNomeSquadraInCasa())) {
				nomiSquadre.add(p.getNomeSquadraInCasa());
			}
		}
		return nomiSquadre;
	}
	private boolean verificaCitta(LinkedList<String> squadreArbitrate, String cittaArbitro) {
		for(Squadra s: squadre) {
			for(int i=0; i<squadreArbitrate.size(); i++) {
				if(s.getNome().equals(squadreArbitrate.get(i)) && cittaArbitro.equals(s.getCitta())) {
					return true;
				}
			}
		}
		return false;
	}
	
	public LinkedList<String> arbitri3Squadre(){
		LinkedList<String> res= new LinkedList<>();
		for(Partita p: partite) {
			LinkedList<String> squadreArbitrate= squadreArbitrate(p.getNomeArbitro());
			if(squadreArbitrate.size()>=3 && !res.contains(p.getNomeArbitro())) {
				res.add(p.getNomeArbitro());
			}
		}
		return res;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public LinkedList<String> arbitri3squadre(){
		LinkedList<String> res= new LinkedList<>();
		
		return res;
	}
	
}
