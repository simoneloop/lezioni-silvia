package appello21settembre2022;
import java.util.*;
public class Main {
	public static void main(String[]args) {
		LinkedList<String>t1= new LinkedList<>();
		t1.add("Film B"); t1.add("Film D");
		LinkedList<String>t2= new LinkedList<>();
		t2.add("Film B"); t2.add("Film A");
		LinkedList<String>t3= new LinkedList<>();
		t3.add("Film B"); t3.add("Film A");
		LinkedList<String>t4= new LinkedList<>();
		t4.add("Film C"); t4.add("Film C");
		
		LinkedList<String>m1= new LinkedList<>();
		m1.add("acquisto"); m1.add("acquisto");
		LinkedList<String>m2= new LinkedList<>();
		m2.add("noleggio"); m2.add("acquisto");
		LinkedList<String>m3= new LinkedList<>();
		m3.add("acquisto"); m3.add("noleggio");
		LinkedList<String>m4= new LinkedList<>();
		m4.add("noleggiato"); m4.add("noleggiato");
		
		LinkedList<Integer>d1= new LinkedList<>();
		d1.add(10); d1.add(20);
		LinkedList<Integer>d2= new LinkedList<>();
		d2.add(10); d2.add(20);
		LinkedList<Integer>d3= new LinkedList<>();
		d3.add(15); d3.add(30);
		LinkedList<Integer>d4= new LinkedList<>();
		d4.add(5); d4.add(25);
		
		Cliente c1= new Cliente("Mario",t1,m1,d1);
		Cliente c2= new Cliente("Luigi",t2,m2,d2);
		Cliente c3= new Cliente("Anna",t3,m3,d3);
		Cliente c4= new Cliente("Lucia",t4,m4,d4);
		
		Film f1= new Film("Film A","Rossi",10,5);
		Film f2= new Film("Film B","Verdi",8,4);
		Film f3= new Film("Film C","Rossi",10,5);
		Film f4= new Film("Film D","Verdi",12,6);
		
		LinkedList<Cliente> clienti= new LinkedList<>();
		clienti.add(c1); clienti.add(c2); clienti.add(c3); clienti.add(c4);
		
		LinkedList<Film> filmati= new LinkedList<>();
		filmati.add(f1); filmati.add(f2); filmati.add(f3); filmati.add(f4);
		
		Sistema s= new Sistema(clienti,filmati);
		System.out.println(s.verificaDati("Lucia"));
		System.out.println(s.clienteMax());
		System.out.println(s.registaApprezzato(10,20));
	
	}
}
