package dp;

public class LongestZigZagSubsequence {
//x1 < x2 > x3 < x4 > x5 < …. xn or  all elements of this are alternating.
// x1 > x2 < x3 > x4 < x5 > …. xn 
	public static void main(String args[]){
		int arr[]={10, 22, 9, 33, 49, 50, 31, 60};
		int n=arr.length;
		
		int dp[][]=new int[n][2];
	//	dp[i][0]: ending at index i and last element is greater than its previous element
//		dp[i][1]: ending at index i and last element is less than its previous element
		
		for(int i=0;i<n;i++)
			dp[i][0] = dp[i][1] =1;
		
		int max =-1;
		for(int i=1;i<n;i++){
			for(int j=0;j<i;j++){
				if(arr[i] > arr[j] && dp[i][0] < dp[j][1]+1)
					dp[i][0] = dp[j][1]+1;
				
				if(arr[i] < arr[j] && dp[i][1] < dp[j][0]+1)
					dp[i][1]=dp[j][0]+1;
			}
			
			if(max < Math.max(dp[i][0], dp[i][1]))
				max = Math.max(dp[i][0], dp[i][1]);
		}
		
		System.out.println(max);
	}
}
