package dp;
/*
 * 
 Ugly numbers are numbers whose only prime factors are 2, 3 or 5. The sequence
1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, …
 */
public class UglyNumbers {

	public static void main(String args[]){
		int n = 150;
		int i2=0,i3=0,i5=0;
		int dp[]= new int[n];
		dp[0] =1;
		
		for(int i=1;i<n;i++){
			int next_multiple_2 = dp[i2] * 2;
			int next_multiple_3 = dp[i3] * 3;
			int next_multiple_5 = dp[i5] * 5;
			
			int min = Math.min(next_multiple_2, Math.min(next_multiple_3, next_multiple_5));
			dp[i] = min;
			
			if(min == next_multiple_2){
				i2++;
			}
			if(min == next_multiple_3){
				i3++;
			}
			if(min == next_multiple_5){
				
				i5++;
			}
			
		}
		System.out.println(dp[n-1]);
	}
}
