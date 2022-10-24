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
		
		//punto della situazione
		//m[i][j]=elemento in riga i e colonna j
		//m[i]= tutta la riga
		for(int i=0;i<m.length;i++) {
			for(int j=0;j<m[0].length;j++) {
				m[i][j]=(i==j)?1:0;
			}
		}
		
		
	}
	static int[][] sommmaMatrici(int[][]m1,int[][]m2){
		if(m1.length!=m2.length || m1[0].length!=m2.length) {
			System.out.println("dimensioni diverse");
			System.exit(-1);
		}
		int[][]res=new int[m1.length][m1[0].length];
		for(int i=0;i<m1.length;i++) {
			for(int j=0;j<m1[0].length;j++) {
				res[i][j]=m1[i][j]+m2[i][j];
			}
		}
		return res;
	}
	
	//matrice quadrata= dimensione righe e colonne uguale
	static int[][]moltiplicazione(int[][]m1,int[][]m2){
		if(m1.length!=m2[0].length) {
			System.out.println("non è possibile moltiplicare queste due matrici");
			System.exit(-1);
		}
		int [][]matrixRes=new int[m1.length][m1.length];
		for(int i=0;i<m1.length;i++) {
			for(int j=0;j<m1[0].length;j++) {
				int res=0;
				for(int k=0;k<matrixRes.length;k++) {
					res=res+m1[i][k]*m2[k][j];
				}
				matrixRes[i][j]=res;
			}
		}
		return matrixRes;
	}
//{
//	{1,2,3},
//	{3,4,5},
//	{6,7,8}
//}
//{
//	{1,2,3},
//	{3,4,5},
//	{6,7,8}
//}
//{
	//{res1,res2,res3}
	//
//}

}
