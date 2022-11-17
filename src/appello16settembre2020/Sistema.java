package appello16settembre2020;
import java.util.*;
public class Sistema {
	private LinkedList<Messaggio> messaggi;
	private LinkedList<Utente> utenti;
	
	public Sistema(LinkedList<Messaggio> messaggi,LinkedList<Utente> utenti ) {
		this.messaggi=messaggi;
		this.utenti=utenti;
	}
	public LinkedList<String> nessunaLettura(String destinatario){
		LinkedList<String> res= new LinkedList<>();
		for(Messaggio m: messaggi) {
			if(m.getNomeDestinatario().equals(destinatario) && !m.letto() && !res.contains(m.getNomeMittente())) {
				res.add(m.getNomeMittente());
			}
		}
		return res;
	}
	public LinkedList<String> cittaUnica(int dataInizio, int dataFine){
		LinkedList<String> res= new LinkedList<>();
		LinkedList<String> nomiUtentiScremati= nomiMessaggiInviatiInData(dataInizio,dataFine);
		for(int i=0; i<nomiUtentiScremati.size(); i++) {
			LinkedList<String> destinatariScremati= trovaDestinatari(nomiUtentiScremati.get(i));
			int contaMittenti= contaMittente(nomiUtentiScremati.get(i));
			if(contaMittenti>=2 && verificaCitta(destinatariScremati) && !res.contains(nomiUtentiScremati.get(i))) {
				res.add(nomiUtentiScremati.get(i));
			}
		}
		return res;
		
	}
	private LinkedList<String> nomiMessaggiInviatiInData(int dataInizio, int dataFine){
		LinkedList<String> nomi= new LinkedList<>();
		for(Messaggio m: messaggi) {
			if(m.getData()>= dataInizio && m.getData()<= dataFine) {
				nomi.add(m.getNomeMittente());
			}
		}
		//System.out.println("Stampa la lista dei nomi in data: "+nomi);
		return nomi;
	}
	private int contaMittente(String nome) {
		int contatore=0;
		for(Messaggio m: messaggi) {
			if(m.getNomeMittente().equals(nome)) {
				contatore++;
			}
		}
		//System.out.println("Il contatore di"+nome+" è: "+contatore);
		return contatore;
	}
	private LinkedList<String> trovaDestinatari(String nome){
		LinkedList<String> destinatari= new LinkedList<>();
		for(Messaggio m:messaggi) {
			if(m.getNomeMittente().equals(nome)) {
				destinatari.add(m.getNomeDestinatario());
			}
		}
		//System.out.println("I destinatari di"+nome+" sono: "+destinatari);
		return destinatari;
	}
	private String getCittaDestinatario(String destinatario) {
		String citta=null;
		for(Utente u: utenti) {
			if(u.getNome().equals(destinatario)) {
				citta=u.getCitta();
			}
		}
		//System.out.println("La città di "+destinatario+" è: "+citta);
		return citta;
	}
	private boolean verificaCitta(LinkedList<String> destinatari) {
		for(int i=0; i<destinatari.size(); i++) {
			for(int j=1; j<destinatari.size(); j++) {
				//System.out.println("Stampa la prima citta: "+getCittaDestinatario(destinatari.get(i)) +" e la seconda: "+getCittaDestinatario(destinatari.get(j)));
				if(!getCittaDestinatario(destinatari.get(i)).equals(getCittaDestinatario(destinatari.get(j)))) {
					return false;
				}
			}
		}
		return true;
	}
	
	public LinkedList<String> mittentiFrequenti(int data, String citta){
		LinkedList<String> res= new LinkedList<>();
		LinkedList<String> mittentiScremati=nomiMessaggiInviatiInData(data);
		for(int i=0; i<mittentiScremati.size(); i++) {
			for(Messaggio m: messaggi) {
				if(m.getNomeMittente().equals(mittentiScremati.get(i))) {
					String destinatario=m.getNomeDestinatario();
					if(verificaCitta(destinatario,citta)) {
						res.add(mittentiScremati.get(i));
					}
				}
			}
		}
		return res;
	}
	private LinkedList<String> nomiMessaggiInviatiInData(int data){
		LinkedList<String> nomi= new LinkedList<>();
		for(Messaggio m: messaggi) {
			if(m.getData()== data) {
				nomi.add(m.getNomeMittente());
			}
		}
		return nomi;
	}
	private boolean verificaCitta(String destinatario, String citta ) {
		for(Utente u: utenti) {
			if(u.getNome().equals(destinatario) && !u.getCitta().equals(citta)) {
				return false;
			}
		}
		return true;
	}
}
