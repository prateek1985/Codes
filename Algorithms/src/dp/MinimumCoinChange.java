package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MinimumCoinChange {
	/*Given a value V, if we want to make change for V cents,
	 *  and we have infinite supply of each of C = { C1, C2, .. , Cm} valued coins,
	 *  what is the minimum number of coins to make the change?*/
	 

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int sum=Integer.parseInt(br.readLine());
		String coins[]= br.readLine().split(" ");
		int c[] =  new int [sum+1];
		c[0]=0;
		
		for(int i=1;i<sum+1;i++){
		
			c[i] = Integer.MAX_VALUE;
			for(int j=0;j<coins.length;j++){
				
				if(i>=Integer.parseInt(coins[j])){
					
					c[i]= Math.min(c[i] , c[i-Integer.parseInt(coins[j])] + 1 );
					
				}
					
			}
			
		}
		
		System.out.println("minimum no of coins "+ c[sum]);
	
	}

}
