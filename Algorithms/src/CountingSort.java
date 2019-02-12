import java.util.Arrays;

public class CountingSort {
	
	// Counting sort is efficient if the range of input data is not significantly greater than the number of objects to be sorted. 
	 //Consider the situation where the input sequence is between range 1 to 10K and the data is 10, 5, 10K, 5K.

	public static void main (String args[]) {
		int arr[] = new int[] {31,23,1,100,1000,123,1213};
		int max= Integer.MIN_VALUE;
		
		for(int x:arr) if(x > max) max = x;
			
		int count[] = new int[max+1];
		
		for(int i =0;i<arr.length;i++) {
			count[arr[i]]++;
		}
		
		for(int i=1;i<count.length;i++) {
			count[i] = count[i] + count[i-1];
		}
		int sorted[]= new int[arr.length];
		
		for(int i =0;i<arr.length;i++) {
			sorted[ count[arr[i]] - 1 ] = arr[i];
			count[arr[i]]--;
		}
		Arrays.stream(sorted).forEach(s -> System.out.println(s));
	}
}
