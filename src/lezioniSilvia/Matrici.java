package lezioniSilvia;
import java.util.*;
public class Matrici {
	public static void main(String[] args) {
		//un array bidimensionale 
		int[][]m=new int[3][4];
		//3 è il numero delle righe e 4 è il numero delle colonne quindi una matrice 3x4;
		//una matrice è solo un array di array, ovvero in ogni posizione dell'array c'è un array
		
		//inizializzazione
		for(int i=0;i<3;i++) {
			for(int j=0;j<4;j++) {
				m[i][j]=0;
			}
		}
	
		for(int i=0;i<m.length;i++) {
			for(int j=0;j<m[i].length;j++) {//supponiamo che m[0].length==m[i].length
				m[i][j]=0;
			}
		}
//		Scanner sc=new Scanner(System.in);
//		for(int i=0;i<m.length;i++) {
//			for(int j=0;j<m[i].length;j++) {
//				m[i][j]=sc.nextInt();
//			}
//		}
		;
		int [][] matrix= {{1,2,3},{3,4,5},{6,7,8}};
		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix[i].length;j++) {
				System.out.print(matrix[i][j]);
			}
			
			if(i<m[0].length-1) {
				System.out.print(",");
				System.out.println();
			}
		}
		
		//1,2,3
		//4,5,6
		//7,8,9
	}

}
