package appello15febbraio2022;
import java.util.*;
public class Main {
	public static void main(String[]args) {
		LinkedList<String>l1= new LinkedList<>();
		l1.add("P1"); l1.add("P2");
		LinkedList<Integer>a1= new LinkedList<>();
		a1.add(10); a1.add(20);
		LinkedList<String>l2= new LinkedList<>();
		l2.add("P3");
		LinkedList<Integer>a2= new LinkedList<>();
		a2.add(40);
		LinkedList<String>l3= new LinkedList<>();
		l3.add("P1");
		LinkedList<Integer>a3= new LinkedList<>();
		a3.add(5);
		
		Prodotto p1= new Prodotto("P1", "nomeMarca1",1.00f);
		Prodotto p2= new Prodotto("P2", "nomeMarca2",1.50f);
		Prodotto p3= new Prodotto("P3", "nomeMarca2",2.00f); 
		
		Fattura f1= new Fattura("F1", "Cliente1",1,l1,a1);
		Fattura f2= new Fattura("F2", "Cliente2",1,l2,a2);
		Fattura f3= new Fattura("F3", "Cliente3",1,l3,a3);
		
		LinkedList<Prodotto> prodotti= new LinkedList<>();
		prodotti.add(p3); prodotti.add(p2); prodotti.add(p1);
		
		LinkedList<Fattura> fatture= new LinkedList<>();
		fatture.add(f3); fatture.add(f2); fatture.add(f1);
		
		Sistema s= new Sistema(prodotti, fatture);
		System.out.println(s.numeroEsemplariMarca("nomeMarca2"));
		System.out.println(s.marcheInComune("Cliente1"));
		System.out.println(s.maxCostoFattura(1));
	}
}
