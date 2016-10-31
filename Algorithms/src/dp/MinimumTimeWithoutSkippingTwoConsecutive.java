 package dp;

import java.util.Scanner;

public class MinimumTimeWithoutSkippingTwoConsecutive {
/*
 * Given time taken by n tasks.
 *  Find the minimum time needed to finish the tasks such that skipping of tasks is allowed,
 *   but can not skip two consecutive tasks.
 */
	public static void main(String args[]){
		Scanner s= new Scanner(System.in);
		int n = s.nextInt();
		int time[]= new int[n];
		for(int i=0;i<n;i++){
			time[i] = s.nextInt();				// solution is not same as geeksforgeeks but is easy and correct
		}
		
		int dp[][]= new int[n][2];
		
		// dp[i][0] means i th task is skipped and dp[i][1] means i th task is included
		
		dp[0][0]=0;
		dp[0][1] =time[0];
		for(int i=1;i<n;i++){
			dp[i][0] = dp[i-1][1];
			dp[i][1] = Math.min(dp[i-1][0], dp[i-1][1]) + time[i];
		}
		
		System.out.println(Math.min(dp[n-1][0], dp[n-1][1]));
	}
	
}
