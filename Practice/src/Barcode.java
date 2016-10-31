import java.io.*;
import java.util.*;
public class Barcode {
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s[]= br.readLine().split(" ");
		int n=Integer.parseInt(s[0]);
		int m=Integer.parseInt(s[1]);
		int x=Integer.parseInt(s[2]);
		int y=Integer.parseInt(s[3]);
		char c[][]= new char[n][m];
		for(int i=0;i<n;i++){
			c[i]= br.readLine().toCharArray();	
		}
		
		int w[]=new int[m];
		int b[]= new int[m];
		for(int j=0;j<m;j++){
			int p=0;
			for(int i=0;i<n;i++){
				if(c[i][j]=='.')
					p++;
			}
			w[j] = n-p;
			b[j] = p;
		}
		
		for(int j=1;j<m;j++){
			w[j]+=w[j-1];
			b[j] +=b[j-1];
			//System.out.println(w[j]+" efe");
		}
		
		int dp[][]= new int[2][m];
	
		for(int j=0;j<m;j++){
			dp[0][j]=Integer.MAX_VALUE;
			dp[1][j] = Integer.MAX_VALUE;
			for(int k=j-y;k<=j-x;k++){
				if(k>=0 && dp[0][k]!=Integer.MAX_VALUE && dp[1][k]!=Integer.MAX_VALUE){
					dp[1][j] = Math.min(dp[1][j], dp[0][k] + w[j] - w[k]);
					dp[0][j] = Math.min(dp[0][j], dp[1][k] + b[j] - b[k]);
				}
				else{
					if(j+1>=x&& j+1<=y){
						dp[1][j] = w[j];
						dp[0][j] = b[j];
					}
				}
			}
		//	System.out.println(dp[0][j] +" "+dp[1][j]);
		}
		System.out.println(Math.min(dp[0][m-1], dp[1][m-1]));
	}
}
