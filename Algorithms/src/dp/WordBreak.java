package dp;
import java.util.*;import java.io.*;
/*
 * Given an input string and a dictionary of words, find out if the input 
 * string can be segmented into a space-separated sequence of dictionary words
 */
public class WordBreak {
	public static void main(String args[]) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s= br.readLine();
		String arr[]=br.readLine().split(" ");
		
		HashSet<String> dic = new HashSet<String>();
		for(int i=0;i<arr.length;i++){
			dic.add(arr[i]);
		}
		// Create the DP table to store results of subproblems. The value dp[i]
	    // will be true if s[0..i-1] can be segmented into dictionary words,
	    // otherwise false.
		boolean dp[]= new boolean[s.length()+1];
		for(int i=1;i<s.length()+1;i++){
			
			if(!dp[i]  && dic.contains(s.substring(0,i)))
				dp[i]=true;
			
			if(i==s.length() && dp[i])
			{
				System.out.println("Yes");
				return;
			}
			
			if(dp[i]){
				for(int j=i+1;j<s.length()+1;j++){
					if(!dp[j] && dic.contains(s.substring(i,j)))
							dp[j]=true;
					if(dp[j] && j==s.length()){
						System.out.println("Yes");
						return;
					}
				}
			}
		}
		
		System.out.println("No");
	}
}
