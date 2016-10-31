package dp;

import java.util.*;
import java.io.*;
public class KnapSack {

	
	public static void main(String[] args) throws Exception{
		int n= 3;
		int W = 770;
		int val[] ={60,100,120};  // i
		int wt []={10,20,30};     // j
		
		int B[][]= new int[n+1][W+1];
		
		for(int i=0;i<=n;i++){
			B[i][0] = 0;
			B[0][i] = 0;
		}
		
		for(int i=1;i<=n;i++){
			for(int j=1;j<=W;j++){
				
				if(j<wt[i-1]){
					B[i][j] = B[i-1][j];
				}
				else{
					B[i][j] = Math.max( B[i-1][j], B[i-1][j-wt[i-1]] + val[i-1]);
				}
			}
		}
		
		System.out.println(B[n][W]);
	}

}
