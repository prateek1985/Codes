package dp;
import java.io.*;
public class CountWaysReach_Nth_Stair {

	public static void main(String as[]) throws IOException{
		
		/*There are n stairs, a person standing at the bottom wants to reach the top.
		 *  The person can climb either 1 stair or 2 stairs at a time.
		 *  Count the number of ways, the person can reach the top.*/
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int dp[]=new int[n+1];
		dp[1] = 1;
		dp[2] = 2;
		
		for(int i=3;i<n+1;i++){
			dp[i] = dp[i-1] + dp[i-2];
		}
		
		System.out.println(dp[n]);
	}
}
