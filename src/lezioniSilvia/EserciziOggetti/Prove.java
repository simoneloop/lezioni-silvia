package lezioniSilvia.EserciziOggetti;

public class Prove {
	public static void main(String[]args) {
		Monetina m1=new Monetina();
		int count=0;
		int lanci=10;
		for(int i=0; i<lanci; i++) {
			m1.lancia();
			System.out.println("E' uscito "+m1);
			int faccia=m1.getFaccia();
			if(faccia==1) {
				count++;
			}
			else {
				count--;
			}
		}
		System.out.println("Il contatore è incrementato di "+count);
	}
}
