package dp;

public class MinimumSumOneOfEveryThreeConsecutiveElementsTaken {

	public static void main(String args[]){
		int arr[]={1, 2, 3, 6, 7, 1, 8, 6, 2,7, 7, 1};
		//  sum[i] is going to store
	    // minimum possible sum when arr[i] is
	    // part of the solution.
		int n=arr.length;
		int sum[]=new int[n];
	
		sum[0] = arr[0];
		sum[1] = arr[1];
		sum[2] = arr[2];
		
		for(int i=3;i<n;i++){
			sum[i] = arr[i] + Math.min(sum[i-1], Math.min(sum[i-2] , sum[i-3]));
		}
		System.out.println(Math.min(sum[n-1], Math.min(sum[n-2] , sum[n-3])));
	}
}
