package dp;
/*
 *Remove minimum elements from either side 
 *such that 2*min becomes more than max
 */
public class RemoveMinimumElementsFromEitherSide {
static int arr[];
static int dp1[][];
	public static void main(String args[]) {
		 arr = new int[]{4, 5, 100, 9, 10, 11, 12, 15, 200};
		// TOP DOWN approach using recursion
		 dp1 = new int[arr.length][arr.length];
		 System.out.println(recur(0,arr.length-1));
	
		 ///////////////////////////////////////////
		 // BOTTOM UP APPROACH O(n^3)
		 //////////////////////////////////////////
		 
		 int dp[][]= new int[arr.length][arr.length];
		 for(int l=1;l<=arr.length;l++){
			 for(int i=0;i<arr.length-l+1;i++){
				 int j = i+l-1;
				 	int min = Integer.MAX_VALUE;
					int max = Integer.MIN_VALUE;
					for(int k=i;k<=j;k++){
						if(min >arr[k])
							min = arr[k];
						if(max < arr[k])
							max = arr[k];
					}
				if(2*min >max){
					dp[i][j]=0;
				}
				else
					dp[i][j] = Math.min(dp[i+1][j], dp[i][j-1])+1;
			 }
		 }
		 
		 
	}
	
	static int recur(int i, int j){
		if(i>=j)
			return 0;
		if(dp1[i][j] >0)
			return dp1[i][j];
		
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for(int k=i;k<=j;k++){
			if(min >arr[k])
				min = arr[k];
			if(max < arr[k])
				max = arr[k];
		}
		if(2*min > max)
			return 0;
		
		int ans  = Math.min(recur(i+1,j),recur(i,j-1)) + 1;
		dp1[i][j] = ans;
		return ans;
	}
}
