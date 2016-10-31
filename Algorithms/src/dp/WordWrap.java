package dp;
import java.util.*;

public class WordWrap {
	/*
	Given a sequence of words, and a limit on the number of characters that can 
	be put in one line (line width). 
	Put line breaks in the given sequence such that the lines are printed neatly
	 */

	public static void main(String args[]) throws Exception{
		int arr[]={3, 2, 2, 5};
		int space = 6;
		int n=arr.length;
		
		int extra[][]= new int[n+1][n+1];
		int lineCost[][] = new int[n+1][n+1];
		int dp[]=new int[n+1];
		
		// calculate extra spaces in a single line.  The value extra[i][j]
	    // indicates extra spaces if words from word number i to j are
	    // placed in a single line
		
		for(int i=1;i<=n;i++){
			for(int j=1;j<=n;j++){
				if(i==j)
					extra[i][i] = space -arr[i-1];
				else
					extra[i][j]  = extra[i][j-1] - arr[j-1]-1;
			}
		}
		
		//The value lineCost[i][j] indicates cost of putting words from
	    // word number i to j in a single line
		
		for(int i=1;i<=n;i++){
			for(int j=i;j<=n;j++){
				if(extra[i][j] < 0 )
					lineCost[i][j] = Integer.MAX_VALUE;
				else if(j==n && extra[i][j] >=0)
					lineCost[i][j] = 0;
				else{
					lineCost[i][j] = extra[i][j] * extra[i][j];
				}
			}
		}
		
		int p[]= new int[n+1];
		
		for(int j=1;j<=n;j++){
			dp[j] = Integer.MAX_VALUE;
			for(int i=1;i<=j;i++){
				if(dp[i-1]!=Integer.MAX_VALUE && lineCost[i][j]!=Integer.MAX_VALUE && dp[j]>dp[i-1]+lineCost[i][j])
				{
					dp[j] = dp[i-1] + lineCost[i][j];
					p[j] = i;
				}
			}
		}	
		System.out.println(dp[n]);
		print(p,n);
	}
	static int print(int p[], int n){
		int k;
		if(n==1)
			k =1;
		else
			k = print(p,p[n]-1) +1;
		System.out.printf("Line number %d: From word no. %d to %d \n", k, p[n], n);
		return k;	
	}
}
