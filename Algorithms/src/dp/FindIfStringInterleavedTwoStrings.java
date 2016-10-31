package dp;
import java.io.*;
import java.util.*;
public class FindIfStringInterleavedTwoStrings {

	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s1= br.readLine();
		String s2= br.readLine();
		String s3= br.readLine();
		
		if(s1.length()+s2.length()!=s3.length())
		{
			System.out.println("NO");
			return;
		}
		
		boolean dp[][]=new boolean[s1.length()+1][s2.length()+1];
		
		for(int i=0;i<s1.length()+1;i++){
			for(int j=0;j<s2.length()+1;j++){
				
				if(i==0 && j==0)
					dp[i][j] =true;
				// s1 is empty
				else if(i==0 && s2.charAt(j-1) == s3.charAt(j-1))
					dp[i][j] = dp[i][j-1];
				// s2 is empty
				else if(j==0 && s1.charAt(i-1) == s3.charAt(i-1))
					dp[i][j] = dp[i-1][j];
				// Current character of s3 matches with that of both s1 and s2
				else if(i>0 && j>0 && s1.charAt(i-1)==s3.charAt(i+j-1) && s2.charAt(j-1)==s3.charAt(i+j-1))
					dp[i][j] = dp[i-1][j] || dp[i][j-1];
				
				else if(i>0 && s1.charAt(i-1)==s3.charAt(i+j-1))
					dp[i][j] = dp[i-1][j];
				else if(j>0 && s2.charAt(j-1)==s3.charAt(i+j-1))
					dp[i][j] = dp[i][j-1];
			} 
		}
		
		if(dp[s1.length()][s2.length()])
			System.out.println("YES");
		else
			System.out.println("NO");
	}
}