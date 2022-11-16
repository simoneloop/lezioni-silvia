package appello23luglio2020;
import java.util.*;
public class Main {
	public static void main (String [] args) {
		Squadra s1= new Squadra("Juventus", "Torino");
		Squadra s2= new Squadra("Milan", "Milano");
		Squadra s3= new Squadra("Lazio", "Roma");
		
		Partita p1= new Partita("Juventus", "Milan", 2, 0,"Arbitro A", "Roma");
		Partita p2= new Partita("Milan", "Juventus", 1, 3,"Arbitro A", "Roma");
		Partita p3= new Partita("Lazio", "Milan", 2, 0, "Arbitro A", "Roma");
		Partita p4= new Partita("Juventus", "Lazio", 2, 0,"Arbitro B", "Milano");
		Partita p5= new Partita("Lazio", "Juventus", 2, 1,"Arbitro B", "Milano");
		Partita p6= new Partita("Milan", "Lazio", 1, 1,"Arbitro A", "Roma");
		
		
		LinkedList<Squadra> squadre= new LinkedList<>();
		squadre.add(s1); squadre.add(s2); squadre.add(s3);
		
		LinkedList<Partita> partite= new LinkedList<>();
		partite.add(p1); partite.add(p2); partite.add(p3); 
		partite.add(p4); partite.add(p5); partite.add(p6);
		
		Sistema s = new Sistema(squadre,partite);
		System.out.println(s.squadreCasalinghe());
		System.out.println(s.arbitriFuoriCitta());
		System.out.println(s.arbitri3Squadre());
	}
}
