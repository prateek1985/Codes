package dp;

public class SubsetSumProblem {

	/*
	  Given a set of non-negative integers, and a value sum,
	  determine if there is a subset of the given set with sum equal to given sum.
	 */
	public static void main (String args[]){
		int set[] = {3, 34, 4, 12, 5, 2};
		int sum = 9;
		
		// The value of subset[i][j] will be true if there is a subset of set[0..j-1]
	    //  with sum equal to i
		boolean subSet[][] = new boolean[sum+1][set.length+1];
		
		// If sum is 0, then answer is true
		for(int i=0;i<set.length+1;i++){
			subSet[0][i] = true;
		}
		
		// If sum is not 0 and set is empty, then answer is false
		for(int i=1;i<sum+1;i++){
			subSet[i][0] = false;
		}
		
		for(int i=1;i <= sum;i++){
			
			for(int j=1;j<= set.length;j++){
				
				if(i < set[j-1]){
					subSet[i][j]  = subSet[i][j-1];
 				}
				else{
					
					subSet[i][j]  = subSet[i][j-1]  || subSet[ i - set[j-1] ][j-1];
				}
			}
		}
		
		System.out.println(subSet[sum][set.length]);
	
	}
}
