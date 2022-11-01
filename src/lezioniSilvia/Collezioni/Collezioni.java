package lezioniSilvia.Collezioni;

import java.util.ArrayList;

import lezioniSilvia.Eccezioni.EccezioneListaVuota;

public class Collezioni {

	public static void main(String[]args)throws Exception {
		int[] a=new int[2];
		a[0]=1;
		a[1]=2;
		int[] b=new int[a.length*2];
		for(int i=0;i<a.length;i++) {
			b[i]=a[i];
		}
		b[2]=3;
		for(int i=0;i<b.length;i++) {
			System.out.println(b[i]);
		}
		ArrayList<Integer> arrayList=new ArrayList();
		arrayList.add(0);
		arrayList.add(2);
		arrayList.add(1);
		//System.out.println(arrayList);
		//arrayList.clear();
		
		Integer x=1;
		arrayList.remove(x);
		
		arrayList.size();
		
		//arrayList.remove(0);
		arrayList.get(0);
		
		ArrayList<ArrayList<Integer>> matrice=new ArrayList();
		
		matrice.add(arrayList);
		
		
		ArrayList<Integer> lista2=new ArrayList();
		lista2.add(1);
		
		matrice.add(lista2);
		System.out.println(matrice);
		
		
		
		
		ArrayList<Integer> lista3=new ArrayList();
		lista3.add(1);
		System.out.println(lista3);
		
		System.out.println(lista3.equals(lista2));
		matrice.remove(lista3);
		
		//m[i][j]
		//m.get(i).get(j)
		arrayList.clear();
		if(arrayList.size()==0) {
			throw new EccezioneListaVuota();//runtimeException
		}
		
		
		
	}
}
