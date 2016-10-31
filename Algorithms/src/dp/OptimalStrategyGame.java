package dp;

public class OptimalStrategyGame {
/*
 * Consider a row of n coins of values v1 . . . vn, 
 * where n is even. We play a game against an opponent by alternating turns. 
 * In each turn, a player selects either the first or last coin from the row,
 * removes it from the row permanently, and receives the value of the coin.
 * Determine the maximum possible amount of money we can 
 * definitely win if we move first.
 */
	public static void main(String args[])
	{
		int coins[] = {8, 15, 3, 7 };
		int n=coins.length;
		int dp[][]=new int[n][n];
		
		for(int l=1;l<=n;l++){
			for(int i=0;i<n-l+1;i++){
				int j = i+l-1;
				// if first user chooses ith coin
				// then second player can choose i+1 or jth coin optimally
//The opponent intends to choose the coin which leaves the user with minimum value.
				int a = 0,b=0,c=0;
				if(i+2<n)
					a = dp[i+2][j];
				if(i+1<n&&j-1>=0)
					b= dp[i+1][j-1];
				
				if(j-2>=0)
					c = dp[i][j-2];
				
				int x = coins[i] + Math.min(a, b);
					
				// if first user chooses jth coin
				// then second player can choose j-1 or ith coin optimally
				int y=coins[j] + Math.min(c ,b);
				
				//
				dp[i][j] = Math.max(x, y);
			}
		}
		System.out.println(dp[0][n-1]);
	}
}
