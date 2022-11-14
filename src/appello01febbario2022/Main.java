package appello01febbario2022;
import java.util.*;
public class Main {
	public static void main(String []args) {
		Tecnico t1= new Tecnico("Mario", 20);
		Tecnico t2= new Tecnico("Giovanni", 30);
		Tecnico t3= new Tecnico("Luca", 15);
		
		LinkedList<String> l1= new LinkedList<>();
		l1.add("Riparazione"); l1.add("Manutenzione");
		LinkedList<String> l2= new LinkedList<>();
		l2.add("Riparazione");
		LinkedList<String> l3= new LinkedList<>();
		l3.add("Manutenzione");
		
		Intervento i1= new Intervento("Giovanni", l1, 10, 2);
		Intervento i2= new Intervento("Luca", l2, 15, 2);
		Intervento i3= new Intervento("Luca", l3, 15, 1);
		Intervento i4= new Intervento("Mario", l2, 20, 2);
		Intervento i5= new Intervento("Mario", l2, 10, 2);
		Intervento i6= new Intervento("Giovanni", l3, 15, 1);
		
		LinkedList<Tecnico> tecnici= new LinkedList<>();
		tecnici.add(t3); tecnici.add(t2); tecnici.add(t1);
		
		LinkedList<Intervento> interventi= new LinkedList<>();
		interventi.add(i6); interventi.add(i5); interventi.add(i4);
		interventi.add(i3); interventi.add(i2); interventi.add(i1);
		
		Sistema s= new Sistema(tecnici, interventi);
		System.out.println(s.tecnicoMax());
		System.out.println(s.tecniciRiparatori(2));
		System.out.println(s.tecniciJolly(20, 10, 20, 2));
//	
	}
}
