package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Knapsack_litleDifferent {
											// WRONG  IMPLEMENTATION
				
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		for(int r=0;r<t;r++){	
			String s[]=br.readLine().split(" ");
			int k=Integer.parseInt(s[1]);
			
			String w[]=br.readLine().split(" ");
			int B[][]=new int[w.length+1][k+1];
			int y=1;
			for(int i=0;i<w.length;i++){
				B[y++][Integer.parseInt(w[i])] =1;
				
			}
			
			for(int i=1;i<w.length+1;i++){
				for(int j=1;j<k+1;j++){
					if(j<Integer.parseInt(w[i-1]))
						B[i][j] = B[i-1][j];
					else
						B[i][j] = Math.max(B[i-1][j], B[i-1][j-Integer.parseInt(w[i-1])] + Integer.parseInt(w[i-1]));
				}
			}
			
			System.out.println(B[w.length][k]);
		}

	}

}
