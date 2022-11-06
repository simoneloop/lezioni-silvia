package appello17giugno2022;
import java.util.*;

public class Main {
	public static void main(String [] args) {
		Volo v1= new Volo("Roma","Milano",300,150);
		Volo v2= new Volo("Lamezia","Roma",200,120);
		Volo v3= new Volo("Lamezia","Milano",240,130);
		Volo v4= new Volo("Roma","Londra",450,250);
		Volo v5= new Volo("Milano","Parigi",350,200);
		
		LinkedList<String> l1= new LinkedList<>();
		l1.add("Lamezia");l1.add("Roma");l1.add("Londra");
		LinkedList<String> l2= new LinkedList<>();
		l2.add("Roma");l2.add("Milano");l2.add("Parigi");
		LinkedList<String> l3= new LinkedList<>();
		l3.add("Milano");l3.add("Parigi");
		LinkedList<String> l4= new LinkedList<>();
		l4.add("Lamezia");l4.add("Milano");l4.add("Parigi");
		LinkedList<String> l5= new LinkedList<>();
		l5.add("Lamezia");l5.add("Roma");
		
		Prenotazione p1= new Prenotazione(l1,"Rossi","business");
		Prenotazione p2= new Prenotazione(l2,"Rossi","business");
		Prenotazione p3= new Prenotazione(l3,"Bianchi","economica");
		Prenotazione p4= new Prenotazione(l4,"Bianchi","economica");
		Prenotazione p5= new Prenotazione(l5,"Verdi","economica");
		
		LinkedList<Volo> voli= new LinkedList<>();
		voli.add(v5);voli.add(v4);voli.add(v3);voli.add(v2);voli.add(v1);
		LinkedList<Prenotazione> prenotazioni= new LinkedList<>();
		prenotazioni.add(p5);prenotazioni.add(p4);prenotazioni.add(p3);
		prenotazioni.add(p2);prenotazioni.add(p1);
		
		Sistema s= new Sistema(voli, prenotazioni);
		System.out.println(s.verificaPrenotazioni());
		System.out.println(s.voloMax());
		System.out.println(s.destinazioneComune("Rossi"));
	}
}
