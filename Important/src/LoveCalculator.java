import java.util.Scanner;

//http://www.lightoj.com/volume_showproblem.php?problem=1013
// Total number of unique shortest strings which contain the names as subsequence.
public class LoveCalculator {
	static String a,b;
	public static void main(String args[]) throws Exception{
		Scanner s = new Scanner(System.in);
		int t = Integer.parseInt(s.nextLine());
		for(int r=1;r<=t;r++){
			a = s.nextLine();
			b = s.nextLine();			// LCS 
										// The length of the shortest string that contains the names as subsequence.
			int m = b.length();
			int n = a.length();
			int lcs[][]=new int[n+1][m+1];
			
			for(int i=1;i<=n;i++){
				for(int j=1;j<=m;j++){
					if(a.charAt(i-1) == b.charAt(j-1)){
						lcs[i][j] = 1+lcs[i-1][j-1];
					}
					else{
						lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);	
					}
				}
			}
			
			int ans = n+m-lcs[n][m];
			
		//	long unq = unique(lcs , n,m);
			
			long unq_DP = unique_DP(lcs,n,m);
			
			System.out.println("Case "+(r)+": "+ans+" "+unq_DP);
			
		}
	}
	
	static long unique(int lcs[][] , int i , int j){ // Total number of unique shortest strings which contain the names as subsequence.
		if(i==0 || j==0){
			return 1;
		}
		
		if(a.charAt(i-1) == b.charAt(j-1)){
			return unique(lcs,i-1,j-1);
		}
		else{
			if(lcs[i-1][j] > lcs[i][j-1]){
				return unique(lcs , i-1,j);
			}
			else if(lcs[i-1][j] < lcs[i][j-1]){
				return unique(lcs , i,j-1);
			}
			else
				return unique(lcs , i-1,j) + unique(lcs , i,j-1);
		}
		
		
	}
	
	static long unique_DP(int lcs[][], int n , int m){
		
		long dp[][]= new long[n+1][m+1];
		
		for(int i=1;i<n+1;i++){
			for(int j=1;j<m+1;j++){
				if(a.charAt(i-1) == b.charAt(j-1)){
					dp[i][j] = dp[i-1][j-1];
				}
				else{
					if(lcs[i-1][j] > lcs[i][j-1]){
						dp[i][j] = dp[i-1][j];
					}
					else if(lcs[i-1][j] < lcs[i][j-1]){
						dp[i][j] = dp[i][j-1];
					}
					else
						dp[i][j] = dp[i-1][j] + dp[i][j-1];
				}
			}
		}
		return dp[n][m];
	}
}
