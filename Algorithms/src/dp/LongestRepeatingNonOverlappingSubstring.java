package dp;

public class LongestRepeatingNonOverlappingSubstring {
	public static void main(String args[]){
		String s="geeksforgeeks";
		int n=s.length();
		
		/*
		 	dp(i,j) stores length of the matching and
            non-overlapping substrings ending 
            with i'th and j'th characters.
		*/
		int max =0;
		int index=0;
		int dp[][]= new int[n+1][n+1];
		for(int i=1;i<=n;i++){
			for(int j=i+1;j<=n;j++){
				if(s.charAt(i-1) == s.charAt(j-1) && (j-i) > dp[i-1][j-1])
					dp[i][j] = dp[i-1][j-1]+1;
				else
					dp[i][j]=0;
				
				if(dp[i][j] >max){
					max = dp[i][j];
					index = i;
				}
			}
		}
	
		System.out.println(s.substring(index - max , index));
	}
}
