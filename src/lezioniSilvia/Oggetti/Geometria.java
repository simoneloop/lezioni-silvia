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
		
		p0=p1; //shallow copy, oppure copia superficiale
		
		p1.sposta(10,20);
		System.out.println("p0"+p0); //problema dell'aliasing
		
		p0=new Punto(p1);//copia profonda oppure deep copy
		
		p1.sposta(1, 2);
		System.out.println("p0"+p0);
		int a=5;
		int b=a;
		
		String s="ciao";
		String s1=s;
		s=s.substring(2);
		System.out.println(s);
		
		System.out.println(s1);
		
		p0=null;
		p0=new Punto();
		Punto p2=new Punto(2,2);
		Triangolo t=new Triangolo(p0,p1,p2);
		Triangolo t1=new Triangolo(new Punto(),new Punto(1,2), new Punto(3,4));
		
		t1.getP1();
		
		t1.perimetro();
		System.out.println(t1);
		
		//razionali
		Razionale r=new Razionale(4,-6);
		Razionale r1=new Razionale(2,3);
		System.out.println(r.razionaliCreati());
		System.out.println(Razionale.razionaliCreati());
		
		
	}

}
