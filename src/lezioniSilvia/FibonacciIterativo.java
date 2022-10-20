package lezioniSilvia;
import java.util.*;
public class FibonacciIterativo {
	public static void main(String[]args) {
		long n1=0;
		long n2=1;
		long res=-1;
		Scanner sc=new Scanner(System.in);
		int number=sc.nextInt();
		if(number==1) {
			System.out.println(1);
			System.exit(0);
		}
		for(int i=2;i<=number;i++) {
			res=n1+n2;
			n1=n2;
			n2=res;
			
		}
		System.out.println(res);
	}
//0-11235813
}
