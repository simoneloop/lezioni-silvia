package lezioniSilvia.EserciziOggetti;
import java.util.*;
//creare una classe monetina con un campo intero "faccia", e due costanti pubbliche "testa" e "croce"
//(già inizializzate a 0 e 1) e i seguenti metodi:
	//costruttore di default che lancia inizialmente la monetina per impostare la faccia
	//lancia() che fissa casualmente la faccia della monetina(tra testa e croce)
	//getFaccia() ritorna (intero) la faccia attuale della monetina
	//toString() ritorna in stringa la faccia corrente della monetina
public class Monetina {
	private int faccia;
	private final int TESTA=0;
	private final int CROCE=1;
	
	public void lancia() {
		faccia=(int)(Math.random()*2); 
	}
	public Monetina() {
		lancia();
	}
	public int getFaccia() {
		return faccia;
	}
	
	public String toString() {
		if(faccia==TESTA) {
			return "Testa";
		}
		else {
			return "Croce";
		}
	}
	public boolean equals(Object o) {
		if(o==this)
			return true;
		if(o==null)
			return false;
		if(!(o.getClass().equals(this.getClass())))
			return false;
		Monetina m=(Monetina)o;
		return m.faccia==faccia; 
	}
	//una volta creato l'oggetto
	//creare un programma basato su monetina, che crea due monetine m1 e m2 e le lancia ripetutamente, 
	//fino a che una delle due non realizza 3 testa consecutive.


}
