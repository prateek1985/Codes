import java.util.*;
import java.io.*;
public class ABCPATH {
static byte b[][];
static int dp[][];static int n, m;
	public static void main(String aargs[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		int testCase=1;
while(true){		
		String s[]= br.readLine().split(" ");
		n = Integer.parseInt(s[0]);
		m = Integer.parseInt(s[1]);
		if(n==0 && m==0)
			return;
		
		b =  new byte[n][m];
		for(int i=0;i<n;i++){
			b[i]=br.readLine().getBytes();
		}
		
		dp=new int[n][m];
		int max=0;
		
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				if(b[i][j]==(byte)'A')
				{
					int a = bfs(i,j);
					if(a>max)
						max=a;
				}
			}
		}
		pw.println("Case "+testCase+": "+max);
		pw.flush();
		testCase++;
		
	/*	for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				System.out.print(dp[i][j]+" ");
			}
			System.out.println();
		}*/
}
	}
	
	static int bfs(int i, int j){
		byte bb = b[i][j];
		int max =0;
		if(dp[i][j]!=0)
			return dp[i][j];
		
		if(i-1>=0 && b[i-1][j]==bb+1){
			int a=bfs(i-1,j);
			if(max<a)
				max=a;
		}
		if(i+1<n && b[i+1][j]==bb+1){
			int a=bfs(i+1,j);
			if(max<a)
				max=a;
		}
		if(j-1>=0 && b[i][j-1]==bb+1){
			int a=bfs(i,j-1);
			if(max<a)
				max=a;
		}
		if(j+1<m && b[i][j+1]==bb+1){
			int a=bfs(i,j+1);
			if(max<a)
				max=a;
		}
		if(i+1<n && j+1<m && b[i+1][j+1]==bb+1){
			int a=bfs(i+1,j+1);
			if(max<a)
				max=a;
		}
		if(i-1>=0 &&j-1>=0 && b[i-1][j-1]==bb+1){
			int a=bfs(i-1,j-1);
			if(max<a)
				max=a;
		}
		if(i+1<n && j-1 >=0 && b[i+1][j-1]==bb+1){
			int a=bfs(i+1,j-1);
			if(max<a)
				max=a;
		}
		if(i-1>=0 && j+1<m && b[i-1][j+1]==bb+1){
			int a=bfs(i-1,j+1);
			if(max<a)
				max=a;
		}
			
		dp[i][j]=max+1;
		
		return max+1;
	}
}
