import java.util.*;
import java.io.*;
public class NY10E {

	public static void main(String aargs[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		int t=Integer.parseInt(br.readLine());
		
		long dp[][]=new long[65][11];
		for(int i=0;i<65;i++){
			
			for(int j=1;j<11;j++){
				if(i==0)
					dp[i][j]=1;
				else{
					
					dp[i][j] = dp[i][j-1]+dp[i-1][j];
					
				}
				
			}
			
		}	
		
		for(int i=1;i<=t;i++){
			String s[]=br.readLine().split(" ");
			//System.out.println(Integer.parseInt(s[1]));
			pw.println(i+" "+dp[Integer.parseInt(s[1])][10]);
			pw.flush();
		}
	}
}
