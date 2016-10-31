package dp;

public class CuttingARod {

	public static void main(String args[]){
		
		int price[] ={1, 5, 8, 9, 10, 17, 17, 20};
		int n = price.length;
		
		int val[]= new int[n+1];
		
		val[0] = 0;
		
		for(int i=1;i<=n;i++){
			
			for(int j=0;j<i;j++){       // j=0 means cutting a length of 1 from rod
				
				val[i] = Math.max(val[i] , val[i - j-1] + price[j]);
			}
		}
		
		System.out.println(val[n]);
	}
}
