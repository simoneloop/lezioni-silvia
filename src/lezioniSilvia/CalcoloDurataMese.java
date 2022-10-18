package lezioniSilvia;
import java.util.*;
//inseriamo un anno compreso tra 1091 e 2099, inseriamo un mese da 1 a 12 e ritorna il numero di giorni in quel mese
public class CalcoloDurataMese {
	
	// 5/4
	//8/4
	
	public static void main(String[]args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("anno[1091,2099]: "); int anno=sc.nextInt();System.out.println();
		System.out.print("mese[1,12]: ");int mese=sc.nextInt();System.out.println();
		int durata;
		switch(mese) {
		case 1: case 3: case 5: case 7: case 8: case 10:
		case 12: durata=31; break;
		case 2:durata=(anno%4==0)?29:28;break;
		default: durata=30;
		}
		System.out.println("durata: "+durata);
	}

}
