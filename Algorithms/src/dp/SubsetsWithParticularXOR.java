package dp;

public class SubsetsWithParticularXOR {

	public static void main(String args[]) {
		int arr[]={1, 2, 3, 4, 5};
		int k = 4;
		
		int max=Integer.MIN_VALUE;
		for(int i=0;i<arr.length;i++){
			if(max < arr[i])
				max = arr[i];
		}
		
		int m =(1 << (int)((Math.log(max)/Math.log(2)) + 1) ) - 1; // not understood this value
		// m is the maximum possible value of xor can be formed using array
		
		int n=arr.length;
		// The value of dp[i][j] is the number of subsets having
	    // XOR of their elements as j from the set arr[0...i-1]
		int dp[][]= new int[n+1][max*max+1];
		dp[0][0]=1; // The xor of empty subset is 0
		
		for(int i=1;i<=n;i++){
			for(int j=0;j<=m;j++){
				// not including ith and including ith element
				dp[i][j] = dp[i-1][j] + dp[i-1][j^arr[i-1]];   
			}
		}
		
		System.out.println(dp[n][k]);
	}
}
