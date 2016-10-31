package dp;
import java.util.*;
public class nonDecreasingNumbersWithNdigits {
/*A number is non-decreasing if every digit (except the first one) is greater than or equal to previous digit. 
 * For example, 223, 4455567, 899, are non-decreasing numbers.
So, given the number of digits n, you are required to find the count of
 total non-decreasing numbers with n digits.*/
	
	public static void main(String args[]){
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		
		int dp[][]=new int[n+1][10];
		
		for(int i=0;i<10;i++){
			dp[1][i] =1;
		}
		
		for(int d=2;d<=n;d++){
			for(int i=0;i<=9;i++){
				
				for(int j=0;j<=i;j++){
					
					dp[d][i] += dp[d-1][j];  
				}
			}
		}
		
		int sum=0;
		for(int i=0;i<=9;i++){
			sum+=dp[n][i];
		}
		System.out.println(sum);
	}
}
