package dp;

import java.util.Arrays;

public class FloydWarshallAlgorithm {

	public static void main(String args[]){
		int graph[][] = { {0,   5,  Integer.MAX_VALUE, 10},
                {Integer.MAX_VALUE,  0,  3,  Integer.MAX_VALUE},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, 0,   1},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 0} };
		
		int distance[][]=new int [graph[0].length][graph[0].length];
		
		for(int i=0;i<graph[0].length;i++){
			
			for(int j=0;j<graph[0].length;j++){
				
				distance [i][j] = graph[i][j];
			}
		}
		
		for(int k=0;k<graph[0].length;k++){
			
			for(int i=0;i<graph[0].length;i++){
				
				for(int j=0;j<graph[0].length;j++){
					
					if(distance[i][k] != Integer.MAX_VALUE && distance[k][j] !=Integer.MAX_VALUE && distance[i][j] > distance[i][k]+distance[k][j]){
						
						distance[i][j] = distance[i][k]+distance[k][j];
					}
				}
			}
		}
		
		for(int i=0;i<graph[0].length;i++){
			
			for(int j=0;j<graph[0].length;j++){
				
				System.out.print(distance [i][j]+" ");
				
				
			}
			System.out.println();
		}
	}
}
