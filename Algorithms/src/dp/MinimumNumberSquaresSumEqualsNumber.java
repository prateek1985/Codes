package dp;

import java.util.Scanner;

/*
 * A number can always be represented as a sum of squares of other numbers.
 *  Note that 1 is a square and we can always break a number as (1*1 + 1*1 + 1*1 + …). Given a number n,
 *  find the minimum number of squares that sum to X.
 * */
public class MinimumNumberSquaresSumEqualsNumber {

	public static void main (String args[]) {
		Scanner s = new Scanner(System.in);
		int n  = s.nextInt();
		
		int dp[]=new int[n+1];
		dp[1]=1;
		dp[2]=2;
		dp[3]=3;
		dp[4]=1;
		if(n<=4){
			System.out.println(dp[n]);
		}
		
		for(int i=5;i<n+1;i++){
			// max value is i as i can always be represented
            // as 1*1 + 1*1 + ...
			dp[i] =i;
			for(int x = 1;x<=Math.sqrt(i);x++){
				dp[i] = Math.min(dp[i], dp[i-(x*x)]+1);
			}
		}
		
		System.out.println(dp[n]);
	}
}
