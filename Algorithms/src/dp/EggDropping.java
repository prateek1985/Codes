package dp;

public class EggDropping {

	public static void main(String args[]){
		int n = 2;  // no. of eggs 
		int k = 36;   // no of floors
		
		int eggTrials[][] = new int[n+1][k+1];
		
		for(int i=1;i<n+1;i++){
			eggTrials[i][0] = 0;
			eggTrials[i][1] = 1;
		}
		
		for(int j=1;j<k+1;j++){
			eggTrials [0][j] = 0;
			eggTrials [1][j] = j;
		}
		
		for(int i=2 ; i<n+1;i++){
			
			for(int j=2;j<k+1;j++){
				eggTrials[i][j]=Integer.MAX_VALUE;
				
				for(int x =1;x<=j;x++){
					
					int trials = 1 + Math.max(eggTrials[i-1][x-1], eggTrials [i][j-x]);
					
					if(eggTrials[i][j] > trials)
							eggTrials[i][j] = trials;
				}
				
			}
		}
		
		System.out.println(eggTrials[n][k]);
		
	}
}
