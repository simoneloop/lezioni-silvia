package appello17giugno2022;
import java.util.*;

public class Sistema {
	private LinkedList<Volo> voli;
	private LinkedList<Prenotazione> prenotazioni;
	
	public Sistema(LinkedList<Volo> voli, LinkedList<Prenotazione> prenotazioni) {
		this.voli=voli;
		this.prenotazioni=prenotazioni;
	}
	public boolean verificaPrenotazioni() {
		for(Prenotazione p: prenotazioni) {
			if(!esisteVolo(p)) {
				return false;
			}
		}
		return true;
	}
	private boolean esisteVolo(Prenotazione p) {
		for(Volo v: voli) {
			LinkedList<String> lista=p.getPercorso();
			ListIterator<String> it= lista.listIterator();
			String t1=it.next();
			while(it.hasNext()) {
				String t2=it.next();
				if(v.getPartenza().equals(t1)&& v.getArrivo().equals(t2))
					return true;
				 t1=t2;
			}
		}
		return false;
	}
	
	public Volo voloMax() {
		Volo voloScelto=null;
		int count=0;
		for(Volo v: voli) {
			int sommaMax=calcolaIncasso(v);
			if(sommaMax>count) {
				count=sommaMax;
				voloScelto=v;
			}
		}
		return voloScelto;
	}
	private int calcolaIncasso(Volo v) {
		int somma=0; 
		int pb=0; 
		int pe=0;
		for(Prenotazione p: prenotazioni) {
			LinkedList<String> lista=p.getPercorso();
			if(lista.contains(v.getPartenza())&& lista.contains(v.getArrivo())) {
				if(p.getClasse().equals("business")) pb++;
				else pe++;
				somma=pb*v.getPrezzoBusiness()+pe*v.getPrezzoEconomica();
			}
		}
		return somma;
	}
	public LinkedList<String> destinazioneComune(String cliente){
		LinkedList<String> nomiClienti=new LinkedList<>();
		for(Prenotazione p: prenotazioni) {
			if(!p.getNomeCliente().equals(cliente)) {
				String nomeDiverso=p.getNomeCliente();
				if(verificaDestinazioni(cliente,nomeDiverso)&& !nomiClienti.contains(nomeDiverso)) {
					nomiClienti.add(nomeDiverso);
				}
			}
		}
		return nomiClienti;
	}
	private boolean verificaDestinazioni(String cliente, String nomeDiverso) {
		LinkedList<String> destinazioniCliente= new LinkedList<>();
		LinkedList<String> destinazioniAltroCliente= new LinkedList<>();
		for(Prenotazione p: prenotazioni) {
			LinkedList<String> lista= p.getPercorso();
			if(p.getNomeCliente().equals(cliente)) {
				destinazioniCliente.add(lista.getLast());
			}
			if(p.getNomeCliente().equals(nomeDiverso)) {
				destinazioniAltroCliente.add(lista.getLast());
			}
		}
		for(int i=0; i<destinazioniAltroCliente.size(); i++) {
			if(destinazioniCliente.contains(destinazioniAltroCliente.get(i))) {
				return true;
			}		
		}
		return false;
	}
	
}
