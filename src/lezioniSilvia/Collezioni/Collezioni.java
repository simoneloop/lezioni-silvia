package lezioniSilvia.Collezioni;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

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
//		System.out.println(matrice);
		
		
		
		
		ArrayList<Integer> lista3=new ArrayList();
		lista3.add(1);
//		System.out.println(lista3);
		
//		System.out.println(lista3.equals(lista2));
		matrice.remove(lista3);
		
		//m[i][j]
		//m.get(i).get(j)
		arrayList.clear();
//		if(arrayList.size()==0) {
//			throw new EccezioneListaVuota();//runtimeException
//		}

		LinkedList<Integer> listaNumeri=new LinkedList();
		
		for(int i=0;i<10;i++) {
			listaNumeri.add(i);
		}
		LinkedList<String> cars=new LinkedList();
		cars.addLast("mazda");
		cars.addFirst("audi");
		cars.add("volvo");
		cars.add("volk");
		cars.get(2);
		
		ListIterator i=cars.listIterator();
//		while(i.hasNext()) {
//			if(i.next().equals("volvo")) {
//				System.out.println(j);
//			}
//			j++;
//		}
		int[]m=new int[2];
		for(int f=0;f<m.length-1;f++) {
			
		}
		for(ListIterator f=cars.listIterator();f.hasNext();f.next()) {
			System.out.println( f.next().equals("volvo"));
		}
		
		
//		System.out.println(cars.get(2));
//		if(cars.size()>=6) {System.out.println(cars.get(6));}
		
		Integer [] s= {5,6};
		
		ListaConcatenataInt listaConc=new ListaConcatenataInt(s);
		listaConc.aggiungiInTesta(0);
		listaConc.aggiungiInTesta(1);
		listaConc.aggiungiInCoda(2);
		System.out.println(listaConc.getTesta());
		listaConc.svuota();
		System.out.println(listaConc);
		
		listaConc.aggiungiInTesta(0);
		listaConc.aggiungiInTesta(1);
		listaConc.aggiungiInTesta(2);
		listaConc.aggiungiInTesta(3);
		System.out.println(listaConc);
		

		
		
	}
}
