package lezioniSilvia.Oggetti;

public class Triangolo {
	private Punto p1,p2,p3;//vertici del triangolo
	private double a,b,c;//lunghezza dei 3 lati
	
	public Triangolo(Punto p1, Punto p2, Punto p3) {
		a=p1.distanza(p2);
		b=p2.distanza(p3);
		c=p3.distanza(p1);
		if(a>0 && b>0 && c>0) {
			this.p1=p1;
			this.p2=p2;
			this.p3=p3;
		}
		else {
			System.out.println("problema");
			System.exit(-1);
		}
		
	}
	
	public Triangolo(Triangolo t) {
		p1=new Punto(t.p1);
		p2=new Punto(t.p2);
		p3=new Punto(t.p3);
		this.a=t.a;
		this.b=t.b;
		this.c=t.c;
	}
	public double getA() {
		return a;
	}
	public double getB() {
		return b;
	}
	public double getC() {
		return c;
	}
	
	public Punto getP1() {
		return p1;
	}
	public Punto getP2() {
		return p2;
	}
	 public Punto getP3() {
		return p3;
	}
	
	public double perimetro() {
		return a+b+c;
	}
	
	public double area() {
		double semiperimetro=this.perimetro()/2;
		return Math.sqrt(semiperimetro*(semiperimetro-a)*(semiperimetro-b)*(semiperimetro-c));
	}
	
	public String toString() {
		return "Triangolo con vertici: "+p1+" "+p2+" "+p3;
	}
	
	
	

	

}
