package dp;
/*
We are given an array of digits (values lie in range from 0 to 9).
The task is to count all the sub sequences possible in array such that in each
subsequence every digit is greater than its previous digits in the subsequence.
*/

import java.util.Arrays;

public class CountAll_IncreasingSubsequences {
	public static void main(String args[]) {
		int arr[] = {3, 2, 4, 5, 4};
		int n =arr.length;
		int dp[]= new int[n];
		Arrays.fill(dp, 1);
		for(int i=1;i<n;i++){				// O(n^2)
			for(int j=0;j<i;j++){
				if(arr[i] > arr[j]){
					dp[i] += dp[j];
				}
			}
			
		}
		int ans=0;
		for(int x:dp)
			ans+=x;
		System.out.println(ans);
		
		///////////////////////////////////////////////////////////
		//We are given an array of digits (values lie in range from 0 to 9).
		//use the fact that we have only 10 possible values in given array. 
		
		int count[] = new int[10];
		for(int i=0;i<n;i++){					// O(10*n) ~~ O(n)
			for(int j = arr[i]-1;j>=0;j--){
				count[arr[i]] += count[j];
			}
			count[arr[i]]++;
		}
		int result = 0;
	    for (int i=0; i<10; i++)
	        result += count[i];
	 
	    System.out.println(result);
	}
}
