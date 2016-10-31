import java.util.*;
import java.io.*;
public class MonkeyBananaProblem {

		public static void main(String args[]) throws Exception{
			Scanner scan = new Scanner(System.in);
			int t = scan.nextInt();
			for(int r=1;r<=t;r++){
				int n=scan.nextInt();
				int s[][]=new int[2*n-1][];
				int col=0;
				for(int i=0;i<2*n-1;i++){
					if(i<=(2*n-1)/2){
						col++;
					}
					else{
						col--;
					}
					s[i]= new int[col];
					for(int j=0;j<col;j++){
						s[i][j]=scan.nextInt();
					}
				}
				int dp[][]=new int[2*n-1][];
				dp[0] = new int[1];
				dp[0][0] =s[0][0];
				for(int i=1;i<2*n-1;i++){
					int m = s[i].length;
					dp[i]=new int[m];
					if(i<=(2*n-1)/2){
						
						for(int j=0;j<m;j++){
							if(j==0){
							//	System.out.println(i);
								dp[i][j] = dp[i-1][j]+s[i][j];
							}
							else if( j==m-1){
								dp[i][j] = dp[i-1][j-1]+s[i][j];
							}
							else
								dp[i][j] = Math.max(dp[i-1][j-1],dp[i-1][j])+s[i][j];
						}
					}
					else{
						for(int j=0;j<m;j++){
							dp[i][j] = Math.max(dp[i-1][j+1],dp[i-1][j])+s[i][j];
						}
					}
				}
				
				
				System.out.println("Case "+r+": "+dp[2*n-2][0]);
			}
		}
}
