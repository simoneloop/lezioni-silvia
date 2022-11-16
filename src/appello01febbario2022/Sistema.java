package appello01febbario2022;
import java.util.*;
public class Sistema {
	private LinkedList<Tecnico> tecnici;
	private LinkedList<Intervento> interventi;
	
	public Sistema(LinkedList<Tecnico> tecnici,LinkedList<Intervento> interventi) {
		this.tecnici=tecnici;
		this.interventi=interventi;
	}
	public Tecnico tecnicoMax() {
		int massimo=0;
		Tecnico nomeTecnico=null;
		for(Tecnico t: tecnici) {
			int costo=calcolaCostoComplessivo(t);
			if(costo>massimo) {
				massimo=costo;
				nomeTecnico=t;
			}
		}
		return nomeTecnico;
		
	}
	private int calcolaCostoComplessivo(Tecnico t) {
		int costo=0; int somma=0;
		String nomeTecnico= t.getNome();
		for(Intervento i: interventi) {
			if(i.getNomeTecnico().equals(nomeTecnico)) {
				somma+=i.getDurata();
				costo=t.getCostoOrario()*somma;
			}
		}
		//System.out.println("Il tecnico "+nomeTecnico+" ha un costo complessivo di: "+costo);
		return costo;
	}
	public LinkedList<String> tecniciRiparatori(int r){
		LinkedList<String> res= new LinkedList<>();
		for (Tecnico t: tecnici) {
			int contatore=contaRiparazioni(t);
			if(contatore>=r) {
				res.add(t.getNome());
			}
		}
		return res;
	}
	private int contaRiparazioni(Tecnico t) {
		LinkedList<String> listaOperazioniTecnico= new LinkedList<>();
		int contatore=0;
		for (Intervento i: interventi) {
			if(t.getNome().equals(i.getNomeTecnico())) {
				listaOperazioniTecnico.addAll(i.getTipiOperazione());
				if(listaOperazioniTecnico.contains("Riparazione")) {
					contatore++;
				}
			}
		}
		return contatore;
	}
	public LinkedList<String> tecniciJolly(int cm, int d1, int d2, int t1){
		LinkedList<String> res= new LinkedList<>();
		LinkedList<String> nomiTecnici= tecniciConCostoOrarioMinore(cm);
		for(Intervento i: interventi) {
			if(i.getData()>=d1 && i.getData()<=d2) {
				for(int j=0; j<nomiTecnici.size(); j++) {
					if(nomiTecnici.get(j).equals(i.getNomeTecnico())) {
						int conta=contaOperazioniDiverse(nomiTecnici.get(j));
						if(conta>=t1 && !res.contains(nomiTecnici.get(j))) {
							res.add(nomiTecnici.get(j));
						}
					}
				}
			}
		}	
		return res;
		
	}
	private LinkedList<String> tecniciConCostoOrarioMinore(int cm) {
		LinkedList<String> nomiTecnici=new LinkedList<>();
		for(Tecnico t: tecnici) {
			if(t.getCostoOrario()<=cm) {
				nomiTecnici.add(t.getNome());
			}
		}
		//System.out.println("Stampa i tecnici che hanno costo <=cm: "+nomiTecnici);
		return nomiTecnici;
	}
	private int contaOperazioniDiverse(String nome) {
		LinkedList<String> lista= new LinkedList<>();
		for (Intervento i: interventi) {
			LinkedList<String> tipi=i.getTipiOperazione();
			if(nome.equals(i.getNomeTecnico())) {
				for(int j=0; j<tipi.size(); j++) {
					if(!lista.contains(tipi.get(j))) {
						lista.add(tipi.get(j));
					}
				}
			}
		}
		return lista.size();
	}
}
