package dp;
import java.util.Scanner;
public class CountDecodingsOfDigitSequence {
	/*
 Let 1 represent ‘A’, 2 represents ‘B’, etc. Given a digit sequence,
  count the number of possible decodings of the given digit sequence.
Examples:
Input:  digits[] = "121"
Output: 3
// The possible decodings are "ABA", "AU", "LA"
	 */
	public static void main(String args[]) throws Exception{
		Scanner s = new Scanner(System.in);
		String num = s.nextLine();
		int n = num.length();
		int dp[] = new int[n+1];
		dp[0] =1;
		dp[1] =1;
		for(int i=2;i<n+1;i++){
			if(Integer.parseInt(num.charAt(i-1)+"") >0)
				dp[i] = dp[i-1];
			if(Integer.parseInt(num.charAt(i-2)+""+num.charAt(i-1)) <=26)
				dp[i] += dp[i-2];
		}
		System.out.println(dp[n]);
	}
}
