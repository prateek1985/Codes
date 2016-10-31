package dp;

import java.util.Scanner;

public class CountWaysToPartitionSetInto_K_subsets {

	//Given two numbers n and k where n represents number of elements in a set,
	//find number of ways to partition the set into k subsets.
	public static void main(String args[]){
		Scanner s=new Scanner(System.in);
		int n = s.nextInt();
		int k=s.nextInt();
		
		int dp[][]=new int[n+1][k+1];
		// dp[i][j] denotes till ith element no. ways to form j subsets
		for(int i=1;i<=n;i++){
			for(int j=1;j<=k;j++){
				if(j==1 || i==j)
					dp[i][j]=1;
				else
					dp[i][j] = j*dp[i-1][j] + dp[i-1][j-1];
				// ith element goes to already formed j subsets or it can form new subset of its own
		
			}
		}
		System.out.println(dp[n][k]);
	}
}
