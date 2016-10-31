package dp;

public class CoinChange {  // same as different ways coin change problem


	public static void main(String[] args) {
		int coins[] = {2,5,3,6};
		int sum = 10;
		
		int noOfWays[][] = new int[coins.length+1][sum+1];
		
		for(int i=0;i<coins.length+1;i++){
			noOfWays[i][0] = 1 ;
		}
		for(int j=0;j<sum+1;j++){
			noOfWays[0][j] = 0 ;
		}
		
		for(int i=1;i<coins.length+1;i++){
			for(int j=1;j<sum+1;j++){
				 
				if(j >= coins[i-1]){
					
					noOfWays[i][j] = noOfWays[i-1][j]+noOfWays[i][j-coins[i-1]] ;
					
				}
				else
					noOfWays[i][j] = noOfWays[i-1][j];
			}
			
		}
		System.out.println(noOfWays[coins.length][sum]);
		
		// single  
		int dp[]= new int[sum+1];
		dp[0]=1;
		for(int i=0;i<coins.length;i++){
			for(int j=1;j<sum+1;j++)
				if(j>=coins[i])
					dp[j] += dp[j - coins[i]]; 
		}
		
		System.out.println(dp[sum]);
	}

}
