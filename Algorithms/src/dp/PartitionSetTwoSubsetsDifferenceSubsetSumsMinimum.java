package dp;

public class PartitionSetTwoSubsetsDifferenceSubsetSumsMinimum {
//Given a set of integers, the task is to divide it into two sets S1 and S2
	//such that the absolute difference between their sums is minimum.
	public static void main(String args[]){
		int arr[]= {1,6,11,5};
		int n =arr.length;
		int sum=0;
		for(int i=0;i<n;i++)
			sum+=arr[i];
		
		// minimize sum - 2*sumOfSet s1
		boolean dp[][] = new boolean[n+1][sum+1];
		for(int i=1;i<=n;i++){
			dp[i][0] = true;
		}
		for(int i=1;i<=n;i++){
			for(int j=1;j<=sum;j++){
				if(j<arr[i-1])
					dp[i][j] = dp[i-1][j];
				else 
					dp[i][j] = dp[i-1][j]|| dp[i-1][j - arr[i-1]];
			}
		}
		int diff = Integer.MAX_VALUE;
		for(int j=sum/2 ;j>=0 ;j--){
			if(dp[n][j])
			{
				diff = sum - 2*j;
				break;
			}
		}
		System.out.println(diff);
	}
}