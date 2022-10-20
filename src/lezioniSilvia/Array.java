package lezioniSilvia;
import java.util.*;
public class Array {
	public static void main(String[]args) {
		Scanner sc=new Scanner(System.in);
		//è una struttura dati, più semplice
		//un array è una collezione omogenea di dati
		int[]a=new int[5];
		int b[]=new int[5];
		System.out.println(a);
		a[0]=0;
		//a è un puntatore che punta alla prima cella di memoria occupata dall'array
		for(int i=0;i<a.length;i++) {
			a[i]=0;
		}
//		for(int i=0;i<a.length;i++) {
//			a[i]=sc.nextInt();
//		}
		for(int i=0;i<a.length;i++) {
			System.out.print(a[i]+" ");
		}
		for(int i=a.length-1;i>=0;i--) {
			System.out.println(a[i]);
		}
		//se esco fuori dall'intervallo 0/ a.length-1 mi darà sempre un errore IndexOutOfBoundsException
		
		double[] d=new double[5];
		String []s=new String[10];
		//boolean ecc
		//il tipo di un array può essere una qualsiasi classe(o oggetto) java
		String []mesi= {"gennaio","febbraio","marzo","aprile","maggio","giugno","luglio","agosto","settembre","ottobre","novembre","dicembre"};
		Random randomGen=new Random();
		System.out.println(mesi[randomGen.nextInt(12)]);
		
		//ricerca lineare
		
	}
	//tempo computazione O(d) con d=v.length
	static int ricercaLineare(int []v,int x) {
		int i=-1;
		for(int j=0;j<v.length;j++) {
			if(v[j]==x) {
				i=j;
			}
		}
		return i;
	}
	static int altraRicercaLineare(int []v,int x) {
		int i=0;
		while(i<v.length && v[i]!=x) {
			i++;
		}
		if(i<v.length)return i;
		
		return -1;
	}

}
//[1,2,3,4,5,6,7];//ricerca binaria =O(log(d))
