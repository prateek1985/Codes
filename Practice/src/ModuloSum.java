import java.io.*;
public class ModuloSum {

	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s[]=br.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int m = Integer.parseInt(s[1]);
		String arr[]=br.readLine().split(" ");
		
	//  not understood this statement 
			if(n>m){
			//  not understood this statement 
				System.out.println("YES");
				return;
			}
			
		boolean dp[][] = new boolean[n][m];
		
		for(int i=0;i<n;i++){
			dp[i][Integer.parseInt(arr[i])%m] =true;
		}
		
		
		
		for(int i=0;i<n-1;i++){
			for(int j=0;j<m;j++){
				if(dp[i][0]){
					System.out.println("YES");
					return;
				}
				if(dp[i][j]){
					dp[i+1][j] = true;
					dp[i+1][( j+Integer.parseInt(arr[i+1])) %m] =true;
				}
			}
		}
		
		if(dp[n-1][0]){
			System.out.println("YES");
		}
		else
			System.out.println("NO");
	}
}
