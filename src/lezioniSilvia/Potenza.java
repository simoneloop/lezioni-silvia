package lezioniSilvia;
import java.util.*;

public class Potenza {
	public static void main(String[]args) {
		System.out.println("calcolo della potenza p^n, p int, n int >=0");
		Scanner sc=new Scanner(System.in);
		System.out.print("p=");int p=sc.nextInt();
		System.out.print("n=");int n=sc.nextInt();
		if(p==0 && n==0) {
			System.out.println("0^0 forma indeterminata");
			System.exit(-1);
		}
		else if(n<0) {
			System.out.println("per il momento non esponenti negativi");
			System.exit(-1);
		}
		int potenza=1;
		int contatore=n;
		while(contatore>0) {
			potenza*=p;contatore--;
			
		}
		//2^3=2*2*2
		//contatore =3, potenza=1; potenza=>1*2 contatore=>2
		System.out.println(potenza);
		int pp=(int)Math.pow(p, n);
		
		int resMetodo=potenzaConControlli(p,n);
		//tante
		//altre
		//operazioni
	}
	static int potenza(int a, int c) {
		int potenza=1;
		int contatore=c;
		while(contatore>0) {
			potenza*=a;contatore--;
			
		}
		return potenza;
	}
	static int potenzaConControlli(int a,int n) {
		if(a==0 && n==0) {
			System.out.println("potenza: 0^0 !");
			System.exit(-1);
		}
		else if(n<0) {
			System.out.println("per il momento non esponenti negativi");
			System.exit(-1);
		}
		//2^-3 =1/(2^3)
	
		int pot=1;
		for(int i=0; i<Math.abs(n);i++)
			pot*=a;//prima si fa la potenza e poi in caso se negativa va al denominatore
		if(n<0)return(1/pot);
		
		return pot;
	}
	

}
