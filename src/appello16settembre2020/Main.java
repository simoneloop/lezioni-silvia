package appello16settembre2020;
import java.util.*;
public class Main {
	public static void main(String[] args) {
		Utente u1= new Utente("Utente A", "Roma");
		Utente u2= new Utente("Utente B", "Roma");
		Utente u3= new Utente("Utente C", "Milano");
		Utente u4= new Utente("Utente D", "Milano");
		
		Messaggio m1= new Messaggio("Utente A", "Utente B",10,false);
		Messaggio m2= new Messaggio("Utente A", "Utente B",11,false);
		Messaggio m3= new Messaggio("Utente B", "Utente C",15,true);
		Messaggio m4= new Messaggio("Utente B", "Utente D",16,false);
		Messaggio m5= new Messaggio("Utente C", "Utente A",15,true);
		Messaggio m6= new Messaggio("Utente C", "Utente D",16,false);
		Messaggio m7= new Messaggio("Utente D", "Utente C",16,true);
		
		LinkedList<Utente> utenti= new LinkedList<>();
		utenti.add(u1); utenti.add(u2); utenti.add(u3); utenti.add(u4);
		
		LinkedList<Messaggio> messaggi= new LinkedList<>();
		messaggi.add(m7); messaggi.add(m6); messaggi.add(m5); messaggi.add(m4);
		messaggi.add(m3); messaggi.add(m2); messaggi.add(m1);
		
		Sistema s= new Sistema(messaggi, utenti);
		System.out.println(s.nessunaLettura(("Utente B")));
		System.out.println(s.cittaUnica(14, 16));
		System.out.println(s.mittentiFrequenti(15,"Roma"));
		
	}
}
