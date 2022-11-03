package lezioniSilvia.Collezioni;

import java.util.ArrayList;

import lezioniSilvia.Eccezioni.EccezioneIndiceNonValido;
import lezioniSilvia.Eccezioni.EccezioneListaVuota;

public class ListaConcatenataInt {
	
	private NodoInt testa;
	private NodoInt coda;
	private int lunghezza;
	
	private void inizializza() {
		testa=null;
		coda=null;
		lunghezza=0;
	}
	
	public ListaConcatenataInt() {
		inizializza();
	}
	
	public ListaConcatenataInt(ListaConcatenataInt l) {
		inizializza();
		for(NodoInt n=l.testa;n!=null;n=n.getSuccessivo()) {
			aggiungiInCoda(n.getInfo());
		}
	}
	
	public NodoInt getCoda() {
		return coda;
	}
	public NodoInt getTesta() {
		return testa;
	}
	
	public void svuota() {
		inizializza();
	}

	
	
	
	public ListaConcatenataInt(ArrayList<Integer>a) {
		inizializza();
		
		for(int v:a) {
			aggiungiInCoda(v);
		}
	}
	
	public ListaConcatenataInt(Integer[] a) {
		inizializza();
		
		for(int v:a) {
			aggiungiInCoda(v);
		}
	}
	
	public int getLunghezza() {
		return lunghezza;
	}
	
	
	public void aggiungiInCoda(int info) {
		NodoInt nuovoNodo=new NodoInt(info,null);
		if(eVuota()) {
			testa=nuovoNodo;
			coda=nuovoNodo;
		}
		else {
			coda.setSuccessivo(nuovoNodo);
			coda=nuovoNodo;
		}
		lunghezza++;
	}
	public void aggiungiInTesta(int info) {
		NodoInt nuovoNodo=new NodoInt(info,null);
		if(eVuota()) {
			testa=nuovoNodo;
			coda=nuovoNodo;
		}
		else {
			nuovoNodo.setSuccessivo(testa);
			testa=nuovoNodo;
		}
		lunghezza++;
	}
	
	public boolean eVuota() {
		return lunghezza==0;
	}
	
	public String toString() {
		String s="[";
		for(NodoInt n=testa;n!=null;n=n.getSuccessivo()) {
			s+=n;
			if(n.getSuccessivo()!=null) {
				s+=", ";
			}
		}
		s+="]";
		return s;
	}
	
	public void rimuoviTesta() {
		if(eVuota()) {
			throw new EccezioneListaVuota();
		}
		if(lunghezza==1) {
			inizializza();
			return;
		}
		testa=testa.getSuccessivo();
		lunghezza--;
		if(testa==null) {
			coda=null;
		}
	}
	
	public void rimuoviCoda() {
		if(eVuota()) {
			throw new EccezioneListaVuota();
		}
		if(lunghezza==1) {
			inizializza();
			return;
		}
		for(NodoInt n=testa; n!=null;n=n.getSuccessivo()) {
			if(n.getSuccessivo()==coda) {
				n.setSuccessivo(null);
				coda=n;
			}
		}
		lunghezza--;
	}
	
	public ListaConcatenataInt listaInvertita() {
		ListaConcatenataInt ret=new ListaConcatenataInt();
		for(NodoInt n=testa;n!=null;n=n.getSuccessivo()) {
			ret.aggiungiInTesta(n.getInfo());
		}
		return ret;
	}
	
	public int get(int indice) {
		if(indice<0 || indice>lunghezza) {
			throw new EccezioneIndiceNonValido();
		}
		NodoInt n=testa;
		for(int i=0;i<indice;i++) {
			n=n.getSuccessivo();
		}
		return n.getInfo();
	}
	
	public void rimuovi(int indice){
		if(indice<0 || indice>lunghezza) {
			throw new EccezioneIndiceNonValido();
		}
		if(indice==0) {
			rimuoviTesta();
			return;
		}
		if(indice==lunghezza-1) {
			rimuoviCoda();
			return;
		}
		NodoInt n=testa;
		for(int i=0;i<indice-1;i++) {
			n=n.getSuccessivo();
		}
		n.setSuccessivo(n.getSuccessivo().getSuccessivo());
		lunghezza--;
	}
	
}
