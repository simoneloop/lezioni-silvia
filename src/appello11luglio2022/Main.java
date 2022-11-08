package appello11luglio2022;
import java.util.*;
public class Main {
	public static void main(String[]args) {
		LinkedList<String>l1= new LinkedList<>();
		l1.add("F1"); l1.add("F2");
		LinkedList<Float>a1= new LinkedList<>();
		a1.add((float) 1.1); a1.add((float) 1.3);
		LinkedList<String>l2= new LinkedList<>();
		l2.add("F1");
		LinkedList<Float>a2= new LinkedList<>();
		a2.add((float) 2);
		LinkedList<Float>a3= new LinkedList<>();
		a3.add((float) 1.4); a3.add((float) 2);
		
		Merce m1= new Merce("M1","X",l1,a1);
		Merce m2= new Merce("M2","Y",l2,a2);
		Merce m3= new Merce("M3","X",l1,a3);
		
		Ordine or1= new Ordine("ORD1","M1",10,"F1",66);
		Ordine or2= new Ordine("ORD2","M3",5,"F1",100);
		Ordine or3= new Ordine("ORD3","M3",8,"F2",70);
		
		LinkedList<Merce> merci= new LinkedList<>();
		merci.add(m1); merci.add(m2); merci.add(m3);
		
		LinkedList<Ordine> ordini= new LinkedList<>();
		ordini.add(or1); ordini.add(or2); ordini.add(or3);
		
		Sistema s= new Sistema(merci,ordini);
		System.out.println(s.verificaMerciEOrdini());
		System.out.println(s.merciSopraSoglia(1.3f,1.5f));
		System.out.println(s.marcheOrdiniMassimi(50,80));
	
	
	}

}
