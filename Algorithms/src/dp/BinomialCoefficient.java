package dp;

public class BinomialCoefficient {

	public static void main(String []args) {  // Binomial Coefficient C(n, k)   or it is n choose k
		int n=10;
		int k = 3;
		
		int C[][]= new int[n+1][k+1];
		
		for(int i=0;i<=n;i++){
			for(int j=0;j<=Math.min(i,k);j++){
				
				if(i==j || j==0){
					C[i][j] =1;
				}
				else if(i>j)
					C[i][j] = C[i-1][j-1] + C[i-1][j];
			}
		}
		
		System.out.println(C[n][k]);
	}

}
