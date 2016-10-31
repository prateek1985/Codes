import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;

public class ColorFence {
static String s[];
static int min=Integer.MAX_VALUE;
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		int n=Integer.parseInt(br.readLine());
		s=br.readLine().split(" ");
		String dp[][]= new String[n+1][s.length];
		for(int i=0;i<s.length;i++){
			dp[0][i]="";
		}
		
		for(int j=0;j<s.length;j++){
			if(min > Integer.parseInt(s[j]))
				min = Integer.parseInt(s[j]);
		}
		
		String str = f(dp,n);
		
	//	&& max < Integer.parseInt(dp[n][j])
		
		if(!str.isEmpty())
			System.out.println(str);
		else
			System.out.println(-1);
	}
	
	static String f(String dp[][], int n){
		
		if(n < min)
			return "";
		
			for(int j=0;j<s.length;j++){
				int flag=0;
				dp[n][j]="";
				for(int k=0;k<(n/Integer.parseInt(s[j]));k++){
						dp[n][j] +=(j+1);
						flag=1;
				}
		
				if(flag==1)
					dp[n][j] += f(dp,n%Integer.parseInt(s[j]));
				
			}
			
			BigInteger max = new BigInteger("-1");
			for(int j=0;j<s.length;j++){
				//System.out.println(dp[n][j]);
			
				if(!dp[n][j].isEmpty() && max.compareTo(new BigInteger(dp[n][j]))<0)
					max = new BigInteger(dp[n][j]);
				//System.out.println(dp[n][j]);
			}
			return max+"";
	}
}
