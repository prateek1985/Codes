package dp;

public class TradingSharesAtmost_K_TimesForProfit {
//In share trading, a buyer buys shares and sells on future date. 
//Given stock price of n days, the trader is allowed to make at most k transactions,
//where new transaction can only start after previous transaction is complete, 
//find out maximum profit that a share trader could have made.
	
	//http://www.geeksforgeeks.org/maximum-profit-by-buying-and-selling-a-share-at-most-k-times/
	public static void main(String args[]){
		int price[] = {12, 14, 17, 10, 14, 13, 12, 15};   // share price on nth day
		int k = 3;  //  max transaction that can be done
		int n=price.length;
		
		int profit[][] = new int[k+1][n+1];
		
		// For day 0, you can't earn money
	    // irrespective of how many times you trade
	    for (int i = 0; i <= k; i++)
	        profit[i][0] = 0;
	 
	    // profit is 0 if we don't do any transaction
	    // (i.e. k =0)
	    for (int j= 0; j <= n; j++)
	        profit[0][j] = 0;
		
		for(int t=1;t<=k;t++){
			for(int i=1;i<n;i++){
				
				profit[t][i] = Integer.MIN_VALUE;
				for(int j=0;j<i;j++){
					profit[t][i] = Math.max(profit[t][i], profit[t-1][j] + price[i]-price[j]);
				}
				
				profit[t][i] = Math.max(profit[t][i], profit[t][i-1]);   // no transaction in ith day
			}
		}
		System.out.println(profit[k][n-1]);
	}
}
