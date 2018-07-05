package dp;

import java.util.*;

public class MaximumChainLength {
	
	/*
	 * You are given n pairs of numbers. In every pair, the first number is always smaller than the second number. 
	 * A pair (c, d) can follow another pair (a, b) if b < c.
	 *  Chain of pairs can be formed in this fashion. Find the longest chain which can be formed from a given set of pairs
*/
	public static void main(String args[]){
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		pair arr[]=new pair[n];
		for(int i=0;i<n;i++){
			int a = s.nextInt();
			int b = s.nextInt();
			arr[i] = new pair(a,b); 
		}
		Arrays.sort(arr);
		
		int mcl[]= new int[n];
		 /* Initialize MCL (max chain length) values for all indexes */
		for(int i=0;i<n;i++){
			mcl[i]=1;
		}
		
		for(int i=1;i<n;i++){
			for(int j=0;j<i;j++){
				if(arr[i].a > arr[j].b && mcl[i] < mcl[j]+1) {
					mcl[i] = mcl[j] + 1;
				}
			}
		}
		// mcl[i] now stores the maximum chain length ending with pair i
		 
		   /* Pick maximum of all MCL values */
		int max = Integer.MIN_VALUE;
		for(int x : mcl){
			if(x>max)
				max = x;
		}
		System.out.println(max);
		
	}
	private static class pair implements Comparable<pair>{
		int a;
		int b;
		public pair(int a, int b){
			this.a=a;
			this.b=b;
		}

		public int compareTo(pair p) {
			return a-p.a;
		}
	}
}
