package lezioniSilvia.Oggetti;

public class Geometria {
	
	public static void main(String[] args) {
		Punto p1=new Punto(1,1);
		System.out.println(p1.getX());
		Punto p0=new Punto();
		
		
		double d=p1.distanza(p0);
		System.out.println("la distanza è: "+d);
		
		double d1=p0.distanza(p1);
		p1.sposta(0, p1.getY());
		
		
		System.out.println(p1);
	}

}
