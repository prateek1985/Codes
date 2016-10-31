package dp;

import java.util.Arrays;
/*
We are given a string consisting of digits, we may group these digits into
sub-groups (but maintaining their original order). The task is to count number
of groupings such that for every sub-group except the last one, sum of digits in a sub-group is
less than or equal to sum of the digits in the sub-group immediately on its right
*/
public class CountDigitGroupingOfNumber {
static int dp[][];
	public static void main(String args[]){
		String num = "1234";
		dp = new int[num.length()][9*num.length()+1];
		for(int i=0;i<dp.length;i++){
			Arrays.fill(dp[i],-1);
		}
		int ans = count(num,0,0);
		System.out.println(ans);
	}
	
	static int count(String num,int pos, int prevSum){
		if(pos==num.length())
			return 1;
		
		if(dp[pos][prevSum]!=-1){
			return dp[pos][prevSum];
		}
		
		int sum =0;
		int ans=0;
		for(int i=pos;i<num.length();i++){
			sum += Integer.parseInt(num.charAt(i)+"");
			if(sum>=prevSum){
				ans += count(num,i+1,sum);
			}
		}
		
		dp[pos][prevSum] = ans;
		
		return ans;
	}
}
