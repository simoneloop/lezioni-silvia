package lezioniSilvia;

//testi,messaggi,codici
public class Stringhe {
	
	public static void main(String[]args) {
		//a5,b6
		String titolo="titolo";//literal- letterali

		String nuovoTitolo=new String("nuovo titolo");
		
		char c='c';//i char vengono denotati dal singolo apice ', le stringhe invece dai doppi apici "
		char[] arraySottotitolo= {'h','e','l','l','o'};
		String sottotitolo=new String(arraySottotitolo);
		
		System.out.println(arraySottotitolo[1]);
		System.out.println(sottotitolo.charAt(4));
		String s="hello world";
		String t="hello world";
		
		
		System.out.println(s==t);
		System.out.println(s.equals(t));
		//molto più sicuro e corretto utilizzare questa notazione perché per esempio:
		//se fossero su un sistema distribuito non sarebbero nella stessa pool
		//funziona solo per le stringhe e non per altri oggetti, praticamente grazie alla string pool s e t sono la stessa stringa ripescata
		//quindi in questo caso hanno lo stesso puntatore
		//se no per gli altri oggetti ==controlla l'indirizzo di memoria
		String descrizione="lezione sulle stringhe ...";
		System.out.println("lunghezza: "+descrizione.length());
		char primoCarattere=descrizione.charAt(0);
		String str1="hello";
		String str2="world";
		String str4=str1+str2;
		String str3=str1.concat(str2);
		
		
		titolo="i promessi sposi";
		String a=titolo.substring(2);
		System.out.println(a);
		String b=titolo.substring(2,10);
		System.out.println(b);
		
		titolo.substring(2);
		System.out.println(titolo);
		
		//replace
		//LE STRINGHE SONO OGGETTI IMMUTABILI ED è FACILE CADERE IN ERRORI DEL GENERE
		String messaggio="ciao xx xx ciao xxx";
		messaggio.replace("xx","world");
		System.out.println(messaggio);
		messaggio=messaggio.replace("xx", "world");
		System.out.println(messaggio);
		String data="20/10/2022";
		data=data.replace("/","-");
		System.out.println(data);
		String [] date=data.split("-");
		for(int i=0;i<date.length;i++) {
			System.out.print(date[i]+" ");
		}
		System.out.println();
		String giorno=date[0];
		String mese=date[1];
		String anno=date[2];
		
		//isEmpty ritorna true solo se la stringa è ""
		//trim ritorna una copia della stringa di partenza eliminando gli spazi ad inizio e fine
		String email="    ciao@   mondo.it    ";
		
		System.out.println(email);
		//email=email.trim();
		System.out.println(email);
		
		
		System.out.println(email.replace(" ", ""));
		
		
		System.out.println(email.contains("@"));
		
		
	}
	
	
	
	
	

}
