import java.io.*;
public class Zuma {

	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		String arr[]=br.readLine().split(" ");
		int dp[][]=new int[n][n];
		
		for(int l=1;l<=n;l++){
			for(int i=0;i<n-l+1;i++){
				int j=i+l-1;
				if(l==1){
					dp[i][j] = 1;
				}
				else if(l==2){
					if(arr[i].equals(arr[j]))
						dp[i][j]=1;
					else
						dp[i][j]=2;
				}
				else{
					dp[i][j] = Integer.MAX_VALUE;
					if(arr[i].equals(arr[j])){
						dp[i][j] = dp[i+1][j-1];
					}
					else{
						dp[i][j] = dp[i+1][j-1] + 2;
					}
					//System.out.println(dp[i][j] + " "+i+" "+j);
					for(int k=i;k<j;k++){
						if(dp[i][k]+dp[k+1][j] < dp[i][j])
							dp[i][j] = dp[i][k]+dp[k+1][j];
					}
					//System.out.println(dp[i][j] + " "+i+" "+j);
				}
			}
		}
		System.out.println(dp[0][n-1]);
	}
}
