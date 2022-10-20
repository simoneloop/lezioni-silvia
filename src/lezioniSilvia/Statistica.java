package lezioniSilvia;
import java.util.*;
public class Statistica {
	//Un programma che legge un intero n e quindi legge n voti universitari, calcola e stampa:
	//il voto min
	//il voto max
	//il voto medio
	//la moda 
	static Scanner sc=new Scanner(System.in);//variabile globale
	
	public static void main(String[]args) {
		System.out.println("statistica di voti di un campione di studenti");
		System.out.println("quanti studenti?");
		int n=sc.nextInt();
		int voti[]=new int[n];
		leggiVoti(voti);
		int min=trovaMin(voti);
		int max=trovaMax(voti);
		double media=trovaMedia(voti);
		int moda=trovaModa(voti);
		stampaVoti(min,max,media,moda);
	}
	
	
	static void leggiVoti(int[]voti) {
		//partiamo dall'assunzione che i voti siano correttamente scritti da 18 a 30;
		System.out.println("fornire "+voti.length+" voti da 18 a 30");
		for(int i=0;i<voti.length;i++) {
			voti[i]=sc.nextInt();
		}
		
	}
	static int trovaMin(int[]voti) {
		//[18,20,30,25]
		int min=voti[0];
		for(int i=1;i<voti.length;i++) {
			if(voti[i]<min) {
				min=voti[i];
			}
		}
		return min;
	}
	static int trovaMax(int[]voti) {
		int max=voti[0];
		for(int i=1;i<voti.length;i++) {
			if(voti[i]>max) {
				max=voti[i];
			}
		}
		return max;
	}
	static double trovaMedia(int[]voti) {
		double media= 0.0;
		for(int i=0;i<voti.length;i++) {
			media+=voti[i];
		}
		return media/voti.length;
	}
	static int trovaModa(int[]v) {
		int fMax=1,moda=0;
		for(int i=0;i<v.length;i++) {
			int fCorr=1;//frequenza di v[i]
			for(int j=i+1;j<v.length;j++) {
				if(v[i]==v[j]) {
					fCorr++;
				}
			}
			if(fCorr>=fMax) {
				fMax=fCorr;
				moda=v[i];
			}
		}
		return moda;
	}
	static int calcolaModa(int[]v) {
		int []frequenze=new int[13];
		//frequenze[0]= quante volte si ripete il 18
		//frequenze[1]=quante volte si ripete il 19
		//frequenze[2]=quante volte si ripete il 20 e così via
		for(int i=0;i<frequenze.length;i++) {
			frequenze[i]=0;
		}
		for(int i=0;i<v.length;i++) {
			frequenze[v[i]-18]++;
		}
		int max=frequenze[0];
		int indiceMax=0;
		for(int i=0;i<frequenze.length;i++) {
			if(frequenze[i]>max) {
				max=frequenze[i];
				indiceMax=i;
			}
		}
		return indiceMax+18;
	}
	static void stampaVoti(int min,int max,double media,int moda) {
		System.out.println("min: "+min);
		System.out.println("max: "+max);
		System.out.println("media: "+media);
		System.out.println("moda: "+moda);
	}
	

}
