import java.io.*;
import java.util.*;
public class ACPC10D {

	public static void main(String args[]) throws IOException{
		PrintWriter pw = new PrintWriter(System.out);
	//	Scanner s= new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count=1;
		while(true){
			int n=Integer.parseInt(br.readLine());
			if(n==0)
				return;
			String arr[][]=new String[n][3];
			for(int i=0;i<n;i++){
				
					arr[i]=br.readLine().split(" ");
				
			}
			int dp[][]=new int[n][3];
			dp[0][1]=Integer.parseInt(arr[0][1]);
			dp[0][2]=dp[0][1]+Integer.parseInt(arr[0][2]);
			
			dp[1][0]=dp[0][1]+Integer.parseInt(arr[1][0]);
			dp[1][1]=Math.min(dp[1][0], Math.min(dp[0][1], dp[0][2]))+Integer.parseInt(arr[1][1]);
			dp[1][2]=Math.min(dp[1][1], Math.min(dp[0][1], dp[0][2]))+Integer.parseInt(arr[1][2]);
			
			
			for(int i=2;i<n;i++){
				dp[i][0]=Math.min(dp[i-1][0], dp[i-1][1])+Integer.parseInt(arr[i][0]);
				dp[i][1]=Math.min(dp[i][0], Math.min(dp[i-1][0], Math.min(dp[i-1][1],dp[i-1][2])))+Integer.parseInt(arr[i][1]);
				dp[i][2]=Math.min(dp[i][1], Math.min(dp[i-1][1], dp[i-1][2]))+Integer.parseInt(arr[i][2]);
			}
			pw.println(count++ +". "+ dp[n-1][1]);
			pw.flush();
		}
		
	}
}
