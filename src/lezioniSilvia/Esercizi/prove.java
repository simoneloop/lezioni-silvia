package lezioniSilvia.Esercizi;

public class prove {
	
	public static void main(String[]args){
		int[] v= {1,2,3,4,5,6,7,8};
		int x=1;
		int maxValore=v[v.length-1];
		int min=v[0];
		boolean trovato=false;
		int valoreMedio=(min+maxValore)/2;
		while(min<=maxValore && !trovato) {
			if(v[valoreMedio]==x) {
				trovato=true;
				//System.out.println("Il valore "+x+" è in posizione: "+valoreMedio); //return valore medio.
			}
			else {
				if(v[valoreMedio]>x) {
					maxValore=v[valoreMedio-1];
				}
				else {
					min=v[valoreMedio+1];
				}
			}
			if(trovato=true) {
				System.out.println("Il valore "+x+" è in posizione: "); //return valore medio.
				
			}
			else {
				System.out.println("Il valore "+x+" non è presente"); //return -1.
			}
		}
	}	
}
