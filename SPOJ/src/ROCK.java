import java.util.*;
import java.io.*;
public class ROCK {

	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		int  t=Integer.parseInt(br.readLine());
		for(int r=0;r<t;r++){
			String s= br.readLine();
			int n =Integer.parseInt(s);
			char c[]=br.readLine().toCharArray();
			int dp[]=new int[n];
			
				if(c[0]=='1')
					dp[0] = 1;
				
				if(c[1]=='1')
					dp[1] = dp[0]+1;
			
			
			for(int i=2;i<n;i++){
				
				for(int j=0;j<=i;j++){
					int ones=0;
					for(int k=j;k<=i;k++){
						if(c[k] == '1')
							ones++;
					}
					int zeros=i-j+1-ones;
					if(j!=0){
					if(ones > zeros)
						dp[i] = Math.max(dp[j-1]+i-j+1 , dp[i]);
					
					else
						dp[i] = Math.max(dp[j-1], dp[i]);
					}
					else{
						if(ones > zeros){
							dp[i] = i-j+1;
							break;
						}
					}
				}
			}
			
			pw.println(dp[n-1]);
			pw.flush();
		}
	}
}
