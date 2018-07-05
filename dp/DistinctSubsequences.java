package dp;
import java.util.*;
import java.io.*;

// spoj problem DSUBSEQ 

/*
dp[i] = number of distinct subsequences ending with c[i]
sum[i] = dp[1] + dp[2] + ... + dp[i]. So sum[n] will be your answer.
last[c[i]-'A'] = last(previous) position (position of last occurrence) of character c[i] in the given string.
 * 
 * 
 Initially, we assume we can append c[i] to all subsequences ending on previous characters, but this might violate
  the condition that the counted subsequences need to be distinct. Remember that last[c[i]-'A'] gives us the last
   position c[i] appeared on until now. The only subsequences we 
 overcount are those that the previous c[i] was appended to, so we subtract those
 */

public class DistinctSubsequences {

	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		PrintWriter pw = new PrintWriter(System.out);
		
		for(int r=0;r<t;r++){
			char c[]= br.readLine().toCharArray();
			long dp[]=new long[c.length+1];
			long sum[] = new long[c.length+1];
			int last[]= new int[26];
			
			dp[0] = 1;
			sum[0] = dp[0];
			int mod = 1000000007;
			for(int i=1;i<=c.length;i++){
				if(last[c[i-1]-'A']-1>=0){
					
					// avoid all mod for understanding, mod is used due to question demand in SPOJ
					
					dp[i]  =  (((sum[i-1] - sum[last[c[i-1] -'A'] -1] )%mod)+mod)%mod;     // subtracting if a letter repeats
				}
				else
					dp[i] = sum[i-1];
				
				sum[i] = sum[i-1] + dp[i];
				last[c[i-1]-'A'] =i;
			}
			
			pw.println(sum[c.length] % mod);
			pw.flush();
			
		}
		
	}
}
