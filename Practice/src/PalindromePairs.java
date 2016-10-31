import java.io.*;
import java.util.*;

public class PalindromePairs {
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s= br.readLine();
		int n = s.length();
		boolean pal[][]= new boolean[n][n];
		for(int i=0;i<n;i++){
			pal[i][i] = true;
		}
		
		for(int l=2;l<=n;l++){
			for(int i=0;i<n-l+1;i++){
				int j = i+l-1;
				if(l==2 && s.charAt(i)== s.charAt(j)){
					pal[i][j] = true;
				}
				else if(s.charAt(i)== s.charAt(j) && pal[i+1][j-1])
					pal[i][j] = true;
			}
		}
		
		long ans=0;
		
		long dp[][] = new long[n][n];
		for(int l=1;l<=n;l++){
			for(int i=0;i<n-l+1;i++){
				int j = i+l-1;
				if(l==1){
					dp[i][j] =1;
				}
				else if(l==2){
					dp[i][j] = dp[i][j-1] + dp[i+1][j];
					if(s.charAt(i) == s.charAt(j))
						dp[i][j]++;
				}
				else{
					dp[i][j] = dp[i][j-1] + dp[i+1][j] - dp[i+1][j-1];
					if(s.charAt(i) == s.charAt(j) && pal[i+1][j-1])
						dp[i][j]++;
				}
			}
		}
		
		for(int l=1;l<=n;l++){
			for(int i=0;i<n-l+1;i++){
				int j = i+l-1;
				
				if(pal[i][j]){
					if(j+1<n)
						ans += dp[j+1][n-1];
				}
			}
		}
		System.out.println(ans);
	}
}
