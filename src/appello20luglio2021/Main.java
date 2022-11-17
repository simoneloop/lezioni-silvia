package appello20luglio2021;
import java.util.*;
public class Main {
	public static void main(String[]args) {
		Calciatore ca1= new Calciatore("Bianchi","Inter");
		Calciatore ca2= new Calciatore("Verdi","Napoli");
		Calciatore ca3= new Calciatore("Rossi","Roma");
		Calciatore ca4= new Calciatore("Rossetti","Inter");
		Calciatore ca5= new Calciatore("Neri","Napoli");
		
		LinkedList<Integer> l1= new LinkedList<>();
		l1.add(300); l1.add(200); l1.add(300);
		LinkedList<Integer> l2= new LinkedList<>();
		l2.add(100); l2.add(50); l2.add(100);
		LinkedList<Integer> l3= new LinkedList<>();
		l3.add(100); l3.add(100);
		LinkedList<Integer> l4= new LinkedList<>();
		l4.add(100); l4.add(200); l4.add(200); l4.add(200);
		
		Contratto c1= new Contratto("Juventus","Bianchi",10000,l1);
		Contratto c2= new Contratto("Inter","Neri",5000,l2);
		Contratto c3= new Contratto("Juventus","Verdi",10000,l1);
		Contratto c4= new Contratto("Juventus","Rossi",5000,l3);
		Contratto c5= new Contratto("Napoli","Rossetti",20000,l4);
		
		LinkedList<Contratto>contratti= new LinkedList<>();
		contratti.add(c5);contratti.add(c4);contratti.add(c3);contratti.add(c2);contratti.add(c1);
		LinkedList<Calciatore>calciatori= new LinkedList<>();
		calciatori.add(ca5);calciatori.add(ca4);calciatori.add(ca3);calciatori.add(ca2);calciatori.add(ca1);
		
		Sistema s= new Sistema(contratti, calciatori);
		System.out.println(s.verificaDati());
		System.out.println(s.squadreAttive(20000));
		System.out.println(s.calciatoriPocoPremiati(100));
	}
}
