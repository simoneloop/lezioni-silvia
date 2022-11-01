package lezioniSilvia.Oggetti;

public class Ereditarietà {
	//l'ereditarietà quindi è una proprietà importantissima e cardine delle classi di java, consinste nella possibilità di:
	//progettare una nuova classe per estensione di una già esistente
	public static void main(String[]args) {
		ContoBancario diPinco=new ContoBancario("1",10);
		ContoBancario diGiov=new ContoBancario("1",100);
		
		System.out.println(diPinco.equals(diGiov));
		System.out.println(diPinco);
		diPinco.preleva(9);
		System.out.println(diPinco);
		diPinco.preleva(2);
		System.out.println(diPinco);
		ContoConFido diF=new ContoConFido("1",10,100);
		System.out.println(diF);
		
		ContoBancario[] listaConti=new ContoBancario[2];
		listaConti[0]=new ContoBancario("2",10);
		listaConti[1]=new ContoConFido("3",10,100);
		
		ContoConFido[] listaContiFido=new ContoConFido[2];
		listaContiFido[0]=new ContoConFido("4",10,100);
		//listaContiFido[1]=new ContoBancario("5",10);
		//ContoConFido  è-un(is-a) ContoBancario ma un ContoBancario NON è un Conto con fido.
		
		ContoConFido a=new ContoConFido("4",10,100);
		ContoConFido b=new ContoConFido("4",10,100);
		System.out.println(a.equals(b));
		
		
		
	}

}
