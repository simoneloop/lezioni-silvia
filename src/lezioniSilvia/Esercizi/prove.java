package lezioniSilvia.Esercizi;

import java.util.Scanner;

public class prove {
	public static void main(String[]args) {
		int[][]m={{1,2,3,4},{2,3,4,5},{3,4,5,6},{3,5,6,7}};
		int sommaPrecedenti=0;
		for(int i=0; i<m.length; i++) {
		      int sommaRiga = 0;
		      for(int j=0; j<m[0].length; j++) {
		        sommaRiga=m[i][j];
		        if(j>0) {
		        	for(int k=0; k<=j-1; k++) {
		        		sommaPrecedenti+=m[i][k];
		        	}
		        }
		        if(sommaRiga!=sommaPrecedenti) {  
		        	System.out.println("Riga "+i+", elemento "+sommaRiga+", somma precedenti "+sommaPrecedenti);
		    
		        }
		      }
		}
	}
}
