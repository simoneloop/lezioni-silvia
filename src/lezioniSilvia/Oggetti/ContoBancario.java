package lezioniSilvia.Oggetti;


//L'oggetto ContoBancario definisce le usuali operazioni di deposito e prelievo
//un conto è identificato da un numero espresso mediante una stringa, e un double bilancio
//non è permesso al bilancio di andare in "rosso" ovvero prelevare più di quanto disponibile
//a questo scopo il metodo preleva() ritorna una booleano, true se il prelievo è andato a buon fine false altrimenti

public class ContoBancario{
	
	private String numero;
	private double bilancio=0;
	
	public ContoBancario(String numero) {
		this.numero=numero;
	}
	public ContoBancario(String numero, double bilancio) {
		this.numero=numero;
		this.bilancio=bilancio;
	}
	
	public void deposita(double quantità) {
		if(quantità>0) {
			bilancio+=quantità;
		}
	}
	
	public boolean preleva(double quantità) {
		if(bilancio-quantità>=0) {//quantità>bilancio return false;
			bilancio-=quantità;
			return true;
		}
		return false;
	}
	
	public double saldo() {return bilancio;}
	public String conto() {return numero;}
	public String toString() {
		return "numero di conto: "+numero+" bilancio: "+bilancio;
	}

	//questa notazione dell'equals sarà sempre così
	public boolean equals(Object o) {
		if(!(o instanceof ContoBancario))return false;
		if(o==this)return true;
		ContoBancario c=(ContoBancario)o;
		return this.numero==c.numero && this.bilancio==c.bilancio;
		
	}
}
