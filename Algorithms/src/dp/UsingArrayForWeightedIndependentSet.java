package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UsingArrayForWeightedIndependentSet {  // we can't take consecutive terms

	/**
	 using dynamic programming
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		String []s=br.readLine().split(" ");
		
		int maxSum[] = new int[s.length+1];
		maxSum[0]=0;
		maxSum[1]=Integer.parseInt(s[0]);
		for(int i=2;i<=s.length;i++){
			maxSum[i] = Math.max(maxSum[i-1], maxSum[i-2] + Integer.parseInt(s[i-1]));
		}
		
		System.out.println(maxSum[s.length]);
	}

}