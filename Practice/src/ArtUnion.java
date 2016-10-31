import java.io.*;
public class ArtUnion {

	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		String s[]=br.readLine().split(" ");
		int pic = Integer.parseInt(s[0]);
		int painter = Integer.parseInt(s[1]);
		
		String t[][]=new String[pic][painter];
		for(int i=0;i<pic;i++){
			t[i]=br.readLine().split(" ");
		}
		
		int dp[][]= new int[pic][painter];
		dp[0][0] = Integer.parseInt(t[0][0]);
		
		for(int i=1;i<pic;i++){
			dp[i][0] += dp[i-1][0]+Integer.parseInt(t[i][0]);
		}
		for(int i=1;i<painter;i++){
			dp[0][i] += dp[0][i-1]+Integer.parseInt(t[0][i]);
		}
		
		for(int i=1;i<pic;i++){
			for(int j=1;j<painter;j++){
				
				if(dp[i-1][j] >= dp[i][j-1])
					dp[i][j] = dp[i-1][j] + Integer.parseInt(t[i][j]);
				else
					dp[i][j] = dp[i][j-1] +  Integer.parseInt(t[i][j]);
			}
		}
		for(int i=0;i<pic;i++){
			pw.print(dp[i][painter-1]+" ");
			pw.flush();
		}
		
	}
}
