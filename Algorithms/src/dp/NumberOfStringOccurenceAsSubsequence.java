package dp;

import java.util.Scanner;

public class NumberOfStringOccurenceAsSubsequence {   // wrong don't know why although code is same as geeksfgeeks

	public static void main(String args[]){  // http://www.geeksforgeeks.org/find-number-times-string-occurs-given-string/
		Scanner s = new Scanner(System.in);
		String a = s.nextLine();
		String b = s.nextLine();
		int n = a.length();
		int m = b.length();
		
		int dp[][] = new int[n+1][m+1];
		
		// If first string is empty
		for (int i = 0; i <= m; ++i)
			dp[0][i] = 0;
		
		for(int i=1;i<n+1;i++){
			dp[i][0] = 1;
		}
		
		for(int i=1;i<n+1;i++){
			for(int j=1;j<m+1;j++){
				// If last characters are same, we have two 
	            // options -
	            // 1. consider last characters of both strings
	            //    in solution
	            // 2. ignore last character of first string
				if(a.charAt(i-1) == b.charAt(j-1))
					dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
				
				 // If last character are different, ignore
                // last character of first string
				else
					dp[i][j] =dp[i-1][j];
			}
		}
		System.out.println(dp[n][m]);
	}
}
