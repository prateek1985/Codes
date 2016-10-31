package dp;

import java.util.Arrays;

public class LIS_NLogN {

	public static void main(String args[]){
		int arr[]= {8, 1, 9, 8, 3, 4, 6, 1, 5, 2};
		int n = arr.length;
		int I[]=new int[n+1];
		int lis[]=new int[n];
		
		Arrays.fill(I, Integer.MAX_VALUE);
		I[0] = Integer.MIN_VALUE;
		
		for(int i=0;i<n;i++){
			int ind = Arrays.binarySearch(I, arr[i]);
			if(ind<0)
				ind = -ind-1;
			I[ind] = arr[i];
			lis[i] = ind;
		}
		
		int max =Integer.MIN_VALUE;
		for(int i=0;i<n;i++){
			if(max < lis[i])
				max =lis[i];
		}
		
		System.out.println(max);
		
	}
}
