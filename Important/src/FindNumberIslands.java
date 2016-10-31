
public class FindNumberIslands {
static int mat[][];
	public static void main(String args[]){
		mat =  new int[][] {{1, 1, 0, 0, 0},
				            {0, 1, 0, 0, 1},
				            {1, 0, 0, 1, 1},
				            {0, 0, 0, 0, 0},
				            {1, 0, 1, 0, 1}
				           };
				           
		boolean vis[][]= new boolean[mat.length][mat.length];
		int count=0;
		for(int i=0;i<mat.length;i++){
			for(int j=0;j<mat.length;j++){
				if(!vis[i][j] && mat[i][j] ==1)
				{
					dfs(i,j,vis);
					count++;
				}
			}
		}
		System.out.println(count);
	}
	
	static void dfs(int i , int j , boolean vis[][]){
		if(i<0||j<0||i>=mat.length||j>=mat.length)
			return;
		if(mat[i][j]==1 && !vis[i][j])
			vis[i][j]= true;
		else 
			return;
		
		dfs(i+1,j,vis);
		dfs(i,j+1,vis);
		dfs(i-1,j,vis);
		dfs(i,j-1,vis);
		
		dfs(i+1,j+1,vis);
		dfs(i-1,j+1,vis);
		dfs(i-1,j-1,vis);
		dfs(i+1,j-1,vis);
	}
}
