package lezioniSilvia.EserciziOggetti;
//una volta creato l'oggetto
	//creare un programma basato su monetina, che crea due monetine m1 e m2 e le lancia ripetutamente, 
	//fino a che una delle due non realizza 3 testa consecutive.
public class LancioMonetine {
	public static void main(String[]args) {
		boolean condizione;
		int contatorem1=0;
		int contatorem2=0;
		Monetina m1= new Monetina();
		Monetina m2= new Monetina();
		do {
			m1.lancia(); m2.lancia();
			System.out.println("La moneta m1 ha restituito: "+m1+" e la moneta m2 ha restituito: "+m2);
			int faccia1=m1.getFaccia();
			int faccia2=m2.getFaccia();
			if(faccia1==0) {
				contatorem1++;
			}
			else {
				contatorem1=0;
			}
			if(faccia2==0){
				contatorem2++;
			}
			else{
				contatorem2=0;
			}
			System.out.println("Il contatore m1 è= "+contatorem1+" e il contatore m2 è= "+contatorem2);
			condizione=contatorem1==3||contatorem2==3?false:true;
		}
		while(condizione);
	}

}
