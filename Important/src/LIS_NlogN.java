import java.io.*;
import java.util.*;
public class LIS_NlogN {
	
	// http://www.lightoj.com/article_show.php?article=1000

	public static void main(String args[]){
		
		int seq[] = {8, 1, 9, 8, 3, 4, 6, 1, 5, 2};
		int n = seq.length;
		int arr[]= new int[n+1];
		Arrays.fill(arr, Integer.MAX_VALUE);
		arr[0] = Integer.MIN_VALUE;
		
		int lis[]=new int[n];
		
		for(int i=0;i<n;i++){
			int a = seq[i];
			int index = Arrays.binarySearch(arr,a);
			if(index < 0)
				index = -index-1;
			
			arr[index] = a;
			lis[i] = index;
		}
		
		int max = -1;
		for(int x : lis)
		{
			if(x>max)
				max =x;
			
		}
		
		System.out.println(max);
		
	}
}
