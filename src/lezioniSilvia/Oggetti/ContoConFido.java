package lezioniSilvia.Oggetti;

public class ContoConFido extends ContoBancario {

	private double fido=1000;//default
	public ContoConFido(String numero) {
		super(numero);///il pronome super si riferisce alla super classe, ovvero alla classe madre. 
		//in questo caso sto evocando il costruttore della casse ContoBancario e gli sto passando un numero di conto
	}
	public ContoConFido(String numero, double bilancio) {
		super(numero,bilancio);
	}
	
	public ContoConFido(String numero, double bilancio, double fido) {
		super(numero, bilancio);
		this.fido=fido;
	}
	
	//saldo =10
	//fido=1000
	
	//1009-10=999
	//1000-999=1
	
	
	public boolean preleva(double quantità) {
		if(quantità>0) {
			if(quantità<super.saldo()) {
				super.preleva(quantità);
				return true;
			}										
			else if(quantità<super.saldo()+fido) {
				double eccesso=quantità-super.saldo();
				fido-=eccesso;
				super.preleva(super.saldo());//prelevo tutto il saldo 
				return true;
			}
		}
		return false;
	}
	
	public double getFido() {return this.fido;}
	public void nuovoFido(double fido) {
		this.fido=fido;
	}
	
	public String toString() {
		return super.toString() +" fido= "+fido;
	}
	
	public boolean equals(Object o) {
		if(!(o instanceof ContoConFido))return false;
		if(o==this)return true;
		ContoConFido c=(ContoConFido)o;
		return super.conto()==c.conto() &&super.saldo()==c.saldo() && this.fido==c.getFido();
		
	}
	

}
