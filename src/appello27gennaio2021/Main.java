package appello27gennaio2021;
import java.util.*;
public class Main {
	public static void main(String[]args) {
		LinkedList<String> l1= new LinkedList<>();
		l1.add("F1"); l1.add("F4");
		LinkedList<String> l2= new LinkedList<>();
		l2.add("F1"); l2.add("F2"); l2.add("F3");
		LinkedList<String> l3= new LinkedList<>();
		l3.add("F3");
		
		Fornitore f1= new Fornitore("F1", "Roma");
		Fornitore f2= new Fornitore("F2", "Roma");
		Fornitore f3= new Fornitore("F3", "Milano");
		Fornitore f4= new Fornitore("F4", "Roma");
	
		Merce m1= new Merce("M1", "Barilla", l1);
		Merce m2= new Merce("M2", "Barilla", l2);
		Merce m3= new Merce("M3", "Voiello", l3);
		
		LinkedList<Fornitore> fornitori= new LinkedList<>();
		fornitori.add(f4); fornitori.add(f3); fornitori.add(f2); fornitori.add(f1);
		LinkedList<Merce> merci= new LinkedList<>();
		merci.add(m3); merci.add(m2); merci.add(m1);
		
		Sistema s= new Sistema(fornitori, merci);
		System.out.println(s.grandiFornitori());
		System.out.println(s.fornitoriMonoMarca("Barilla"));
		System.out.println(s.merciCittaDiverse());
	}
}
