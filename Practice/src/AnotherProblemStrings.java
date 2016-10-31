import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class AnotherProblemStrings {

	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		int k =Integer.parseInt(br.readLine());
		String s= br.readLine();
		
		long count=0;
		int dp[]= new int[s.length()];
		dp[0]= Integer.parseInt(s.charAt(0)+"");
		for(int i=1;i<s.length();i++){
			dp[i] = dp[i-1]+Integer.parseInt(s.charAt(i)+""); 
		}
		
		for(int l=1;l<=s.length();l++){
			for(int i=0;i<s.length()-l+1;i++){
				int j=i+l-1;
				int one=-1;
				if(i==0)
					one = dp[j];
				else
					one = dp[j]-dp[i-1];
				if(one == k)
					count++;
			}
		}
		pw.println(count);
		pw.flush();
		
	}
}
