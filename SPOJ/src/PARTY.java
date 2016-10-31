import java.util.*;
public class PARTY {

	public static void main(String args[]) throws Exception{
		Scanner s = new Scanner(System.in);
		while(true){
		int pb =s.nextInt();
		int n=s.nextInt();
		if(pb==0 && n==0)
			break;
		
		long dp[][]=new long[n+1][pb+1];
		int pc[]=new int[n+1];
		int fun[]=new int[n+1];
		
		for(int r=1;r<=n;r++){
			pc[r]=s.nextInt();
			fun[r]=s.nextInt();
			
		}
		
		for(int i=1;i<=n;i++){
		
			for(int j=0;j<pb+1;j++){
			
				if(j==0)
					dp[i][j]=0;
				else if(j-pc[i]>=0)
					dp[i][j] =Math.max(dp[i-1][j], dp[i-1][j-pc[i]] + fun[i]);
				else
					dp[i][j]=dp[i-1][j];
			}
	//		System.out.println(dp[i][pb]+"  "+i);
		}
		
		long maxFun=-1;
		int minMoney=-1;
		for(int i=0;i<pb+1;i++){
			if(maxFun<dp[n][i]){
				maxFun=dp[n][i];
				minMoney=i;
				
			}
		}
		
		System.out.println(minMoney +" "+ maxFun);
		}
	}
}
