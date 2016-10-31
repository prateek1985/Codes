package dp;

import java.util.Scanner;

// Given n, how many structurally unique BST's (binary search trees) 
//that store values 1...n?
public class UniqueBinarySearchTrees {

	// explaination: https://discuss.leetcode.com/topic/8398/dp-solution-in-6-lines-with-explanation-f-i-n-g-i-1-g-n-i
	
	//dp[n]: the number of unique BST for a sequence of length n.
	
	// F(i, n), 1 <= i <= n: the number of unique BST, where the number i is the root of BST, 
	//and the sequence ranges from 1 to n.
	
	//G(n) = F(1, n) + F(2, n) + ... + F(n, n). 
	
	// F(i, n) = G(i-1) * G(n-i)
	
	//=> G(n) = G(0) * G(n-1) + G(1) * G(n-2) + … + G(n-1) * G(0) 
	
	public static void main(String args[]) throws Exception{
		Scanner s=new Scanner(System.in);
		int n= Integer.parseInt(s.nextLine());
		
		int dp[]= new int[n+1];
		dp[0] =1;
		dp[1] =1;
		
		/*
	 	n’th Catalan Number can also be evaluated using direct formula.
	   T(n) = (2n)! / (n+1)!n!
		 */
		
		for(int i=2;i<=n;i++){
			for(int j=1;j<=i;j++){
				dp[i] += dp[j-1] * dp[i-j];
 			}
		}
		System.out.println(dp[n]);
	}
	
}
