package dp;
import java.util.*;
public class PermutationCoefficient {

	public static void main(String args[]){
		Scanner s= new Scanner(System.in);
		int n=s.nextInt();
		int k= s.nextInt();
		
		int P[][]=new int[n+1][k+1];
		for(int i=0;i<=n;i++){
			P[i][0]=1;
		}
		
		for(int i=1;i<=n;i++){
			for(int j=1;j<=Math.min(k, i);j++){
				P[i][j] = P[i-1][j] + (j*P[i-1][j-1]);   // property
			}
		}
		System.out.println(P[n][k]);
	}
}
