package appello21settembre2022;
import java.util.*;
public class Sistema {
	private LinkedList<Cliente> clienti;
	private LinkedList<Film> filmati;
	
	public Sistema(LinkedList<Cliente> clienti, LinkedList<Film> filmati) {
		this.clienti=clienti;
		this.filmati=filmati;
	}
	public String clienteMax() {
		String nome=null;
		int massimo=calcolaPrezzi(clienti.get(0));
		nome=clienti.get(0).getNome();
		for(int i=1; i<clienti.size(); i++) {
			if(massimo<calcolaPrezzi(clienti.get(i))) {
				massimo=calcolaPrezzi(clienti.get(i));
				nome=clienti.get(i).getNome();
			}
		}
		return nome;
	}
	private int calcolaPrezzi(Cliente c) {
		int somma=0;
		LinkedList<String> nomiFilm=c.getTitoli();
		LinkedList<String> modalita=c.getModalita();
		for(Film f: filmati) {
			for(int i=0; i<nomiFilm.size(); i++) {
				if(f.getTitolo().equals(nomiFilm.get(i))) {
					if(modalita.get(i).equals("acquisto")) {
						somma+=f.getPrezzoAcquisto();
					}
					else {
						somma+=f.getPrezzoNoleggio();
					}
				}
			}
		}
		return somma;
	}
	public boolean verificaDati(String s) {
		Cliente cliente=null;
		for(Cliente c: clienti) {
			String nomeCliente=c.getNome();
			if(nomeCliente.equals(s)) {
				cliente=c;
			}
		}
		return (verificaAcquistiCliente(cliente));
	}
	private boolean verificaAcquistiCliente(Cliente c) {
		LinkedList<String> nomi= c.getTitoli();
		LinkedList<String> modalita= c.getModalita();
		for(int i=0; i<nomi.size(); i++) {
			for(int j=i+1; j<nomi.size(); j++) {
				if(nomi.get(i).equals(nomi.get(j))) {
					if(modalita.get(i).equals(modalita.get(j))&& modalita.get(i).equals("acquisto")){
						return false;
					}
				}
			}
		}
		return true;
	}
	public String registaApprezzato(int d1, int d2) {
		LinkedList<String> registi= trovaRegisti();
		int dimensione=registi.size();
		LinkedList<Integer> contatori= contaFilm(dimensione);
		for(int i=0; i<registi.size(); i++) {
			for(Film f: filmati) {
				if(f.getRegista().equals(registi.get(i))) {
					String nomeFilm=f.getTitolo();
					int conta=conta(nomeFilm,d1,d2);
					//System.out.println("Conta= "+conta);
					if(conta>0) {
						contatori.set(i,contatori.get(i)+conta);
					}
				}
			}
		}
		System.out.println("Lista registi"+registi);
		System.out.println("Lista contatore"+ contatori);
		int indice= indiceMassimo(contatori);
		return registi.get(indice);
		
	}
	private LinkedList<String> trovaRegisti(){
		LinkedList<String> res= new LinkedList<>();
		for(Film f: filmati) {
			if(!res.contains(f.getRegista())) {
				res.add(f.getRegista());
			}
		}
		return res;
	}
	private LinkedList<Integer> contaFilm(int dimensione){
		LinkedList<Integer> res=new LinkedList<>();
		for(int d=0; d<dimensione; d++) {
			res.add(0);
		}
		return res;
	}
	private int conta(String nomeFilm, int d1, int d2) {
		int count=0;
		for(Cliente c: clienti) {
			boolean trovato=false;
			LinkedList<Integer> date=c.getDate();
			LinkedList<String> titoli= c.getTitoli();
			for(int j=0; j<titoli.size(); j++) {
				//System.out.println(titoli.get(j).equals(nomeFilm));
				if(titoli.get(j).equals(nomeFilm)) {
					if(date.get(j)>=d1 && date.get(j)<=d2 && !trovato) {
						count++;
						trovato=true;
					}
				}
			}
		}
		return count;
	}
	private int indiceMassimo(LinkedList<Integer>contatori) {
		int indice=0;
		int massimo=contatori.get(0);
		for(int i=1; i<contatori.size(); i++) {
			if(massimo<contatori.get(i)) {
				massimo=contatori.get(i);
				indice=i;
			}
		}
		return indice;
	}

}
