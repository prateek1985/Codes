import java.io.*;
import java.util.*;

public class HardProblem {

	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		String cost[]= br.readLine().split(" ");
		String arr[]= new String[n];
		for(int i=0;i<n;i++){
			arr[i]= br.readLine();
		}
		
		long dp[][]= new long[n][2];
		dp[0][1] = Long.parseLong(cost[0]);  // for reverse
		
		for(int i=1;i<n;i++){
			dp[i][0] = dp[i][1]= 10000000000000000L;
			StringBuilder sb1 = new StringBuilder(arr[i-1]).reverse();
			StringBuilder sb2 = new StringBuilder(arr[i]).reverse();
			
			if(arr[i-1].compareTo(arr[i]) <= 0)
				dp[i][0] = Math.min(dp[i][0], dp[i-1][0]);
			
			if(arr[i-1].compareTo(sb2.toString())<=0)
				dp[i][1] = Math.min(dp[i][1], dp[i-1][0] + Long.parseLong(cost[i]));
			
			if(sb1.toString().compareTo(arr[i]) <=0)
				dp[i][0] = Math.min(dp[i][0], dp[i-1][1]);
			
			if(sb1.toString().compareTo(sb2.toString()) <= 0)
				dp[i][1] = Math.min(dp[i][1], dp[i-1][1] + Long.parseLong(cost[i]));
			
		}
		
		if(dp[n-1][0] == 10000000000000000L && dp[n-1][1] == 10000000000000000L)
			System.out.println(-1);
		else
			System.out.println(Math.min(dp[n-1][0], dp[n-1][1]));
		
	}
}
