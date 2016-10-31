package dp;

public class LongestConsecutivePathFromStartingCharacter {

	static int dp[][];
	public static void main(String args[])
    {
		char mat[][] = { {'a','c','d'},
                { 'h','b','a'},
                { 'i','g','f'}};
		
		dp= new int[mat.length][mat[0].length];
  
        System.out.println(getLen(mat , 'b') );
    }
	
	static int getLen(char mat[][] , char c){
		
		int ans=0;
		
		for(int i=0;i<mat.length;i++){
			for(int j = 0;j<mat[0].length;j++){
				// check for each possible starting point
				if(mat[i][j] == c){
					// recur for all eight adjacent cells
					ans = Math.max(ans, 1 + dfs(mat,i+1,j,c));
					ans = Math.max(ans, 1 + dfs(mat,i-1,j,c));
					ans = Math.max(ans, 1 + dfs(mat,i,j-1,c));
					ans = Math.max(ans, 1 + dfs(mat,i,j+1,c));
					ans = Math.max(ans, 1 + dfs(mat,i-1,j-1,c));
					ans = Math.max(ans, 1 + dfs(mat,i-1,j+1,c));
					ans = Math.max(ans, 1 + dfs(mat,i+1,j-1,c));
					ans = Math.max(ans, 1 + dfs(mat,i+1,j+1,c));
				}
			}
		}
		return ans;
	}
	
	static int dfs(char mat[][], int i, int j, char prev){
		
		if(i<0||j<0 || i>=mat.length || j>=mat[0].length){
			return 0;
		}
		if(mat[i][j] - prev !=1) // not adjacent char in abcd
			return 0;
		
		if(dp[i][j]>0)
			return dp[i][j];
		
		int ans=0;
		char c = mat[i][j];
		
		// recur for paths with differnt adjacent cells and store
        // the length of longest path.
		
		ans = Math.max(ans, 1 + dfs(mat,i+1,j,c));
		ans = Math.max(ans, 1 + dfs(mat,i-1,j,c));
		ans = Math.max(ans, 1 + dfs(mat,i,j-1,c));
		ans = Math.max(ans, 1 + dfs(mat,i,j+1,c));
		ans = Math.max(ans, 1 + dfs(mat,i-1,j-1,c));
		ans = Math.max(ans, 1 + dfs(mat,i-1,j+1,c));
		ans = Math.max(ans, 1 + dfs(mat,i+1,j-1,c));
		ans = Math.max(ans, 1 + dfs(mat,i+1,j+1,c));
		
		dp[i][j]=ans;
		
		return ans;
		
	}
	
}
