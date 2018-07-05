package dp;

public class MaximuSumIncreasingSubSequence {

	public static void main(String args[]){
		
		int arr[]={-11, 101, 2, 3, 100, 4, 5};
		
		int MSIS[] = new int[arr.length];
		
		for(int i=0;i<arr.length;i++){        // if initialize with zero then in inner for loop put j<=i
			MSIS[i] = arr[i];
		}
		
		for (int i=1;i<arr.length;i++){
			for(int j=0;j<i;j++){
				if(arr[i] > arr[j] && MSIS[i] < MSIS[j] +arr[i]){ //	second condition is necessary as arr can contain negative integer too use maximum concept	
					MSIS[i] = MSIS[j] + arr[i];
				}
			}
		}
		
		int max=Integer.MIN_VALUE;
		for(int i=0;i<arr.length;i++){
			if(max<MSIS[i])
				max=MSIS[i];
		}
		
		System.out.println(max);
	}
}
