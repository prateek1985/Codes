package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class DifferentWaysCoinChange {			// CORRECT

	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int sum=Integer.parseInt(br.readLine().split(" ") [0]);
		String coins[]= br.readLine().split(" ");
		Arrays.sort(coins);
		
		
		long c[][] =  new long [coins.length][sum+1];
		for(int i=0;i<coins.length;i++){
			c[i][0]=1;
		}
		for(int i=1;i<sum+1;i++){
			if(i%Integer.parseInt(coins[0])==0)
				c[0][i]=1;
			else
				c[0][i]=0;
		}
		
		for(int i=1;i<coins.length;i++){
			
			for(int j=0;j<sum+1;j++){
				if(j>=Long.parseLong(coins[i])){
					c[i][j] = c[i-1][j] + c[i][j-Integer.parseInt(coins[i])] ;   
					/*coins to compute sum j not considering ith coin + coins to compute (j-value of ith coin) when 
					 * considering ith coin
					 * */
				}
				else{
					c[i][j] = c[i-1][j];
					// coins to compute sum j not taking ith coin as it is bigger then sum
				}
			
				}
			}
			
		System.out.println(c[coins.length-1][sum]);
		}
		
	
	}



