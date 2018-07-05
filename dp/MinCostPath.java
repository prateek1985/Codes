package dp;

public class MinCostPath {

	
	public static void main(String[] args) {
		
		int arr[][] = {{1,2,3},{4,8,2},{1,5,3}} ;
		int cost[][]=new int[arr[0].length][arr[0].length];
		cost[0][0] =arr[0][0];									
		
		for(int i=1;i<arr[0].length;i++){
			cost[i][0] = cost[i-1][0] + arr[i][0];
		}
		for(int j=1;j<arr[0].length;j++){
			cost[0][j] = cost[0][j-1] + arr[0][j];
		}
		
		for(int i=1;i<arr[0].length ; i++){
			for(int j=1;j<arr[0].length;j++){		// can move only down ,right , diagnally 
				
				cost[i][j]= Math.min(Math.min(cost[i-1][j], cost[i][j-1]) ,cost[i-1][j-1] )  + arr[i][j];
			}
		}
		
		System.out.println(cost [arr[0].length-1] [arr[0].length-1]);
	}

}