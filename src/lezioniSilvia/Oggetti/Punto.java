package lezioniSilvia.Oggetti;

public class Punto {
	//programmare nuovi tipi ad hoc per il problema che stiamo andando a studiare
	//un oggetto utilizza tipi base ma anche altri oggetti per creare un oggetto più complesso
	
	
	//variabili di istanza
	private double x,y;
	
	//supponiamo che vogliamo inserire solo punti positivi
	
	//metodo principale per gli oggetti?
	//costruttori
	
	//costruttore "normale"
	public Punto(double x,double y) {
		this.x=x;
		this.y=y;
	}
	
	//costruttore di default
	public Punto() {
		x=0;
		y=0;
	}
	
	//overloading è:
	//definire più metodi con lo stesso nome.
	//java richiede che questi metodi siano differenziati dal numero e/o tipi dei parametri in modo che sia sempre univoca la chiamata
	public Punto(Punto p) {
		x=p.x;
		y=p.y;
	}
	
	//metodi accessori
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public void sposta(double x, double y) {
		this.x=x;
		this.y=y;
	}
	
	public double distanza(Punto p) {
		double d=Math.sqrt((p.x-x)*(p.x-x)+(p.y-y)*(p.y-y));
		return d;
	}
	
	public String toString() {
		return "<"+x+","+y+">";
	}
	
	
	

}
