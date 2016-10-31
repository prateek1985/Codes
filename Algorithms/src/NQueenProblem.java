import java.io.*;

public class NQueenProblem{
	static int n;
	public static void main(String args[]) throws Exception{
		
		int board[][] = {{0, 0, 0, 0},
	            {0, 0, 0, 0},
	            {0, 0, 0, 0},
	            {0, 0, 0, 0}
	        };
	 
		n=4;
		
		if(!nqueen(board , 0)){
			System.out.println("not possible");
		}
		else
		{
			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++){
					System.out.print(board[i][j]+" ");
				}
				System.out.println();
			}
		}
	}
	
	static boolean nqueen(int board[][] , int col){
		if(col >= n)
			return true;
		
		for(int i=0;i<n;i++){
			if(safe(board , i, col)){
				board[i][col]=1;
				if(nqueen(board , col+1)){
					return true;
				}
				
				board[i][col]=0;
			}
		}
		/* If queen can not be place in any row in
        this colum col, then return false */
		return false;			
	}
	
	static boolean safe(int board[][] , int row, int col){
		
		for(int i=0;i<col;i++){
			if(board[row][i]==1){
				return false;
			}
		}
		
		
		for(int i=row,j=col; i>=0&&j>=0;i--,j--){
			if(board[i][j]==1){
				return false;
			}
		}
		
		for(int i=row,j=col;i<n&&j>=0;i++,j--){
			if(board[i][j]==1){
				return false;
			}
		}
		
		return true;
	}
}