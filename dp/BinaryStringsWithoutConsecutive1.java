package dp;
import java.util.*;

public class BinaryStringsWithoutConsecutive1 {

	/*Given a positive integer N, count all possible distinct binary
	  strings of length N such that there are no consecutive 1’s.*/
	
	public static void main(String args[]) throws Exception{
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		
		/*
		 * Let a[i] be the number of binary strings of length i which do not contain any two consecutive 1’s 
		 * and which end in 0. Similarly, let b[i] be the number of such strings which end in 1.
		 *  We can append either 0 or 1 to a string ending in 0,
		 *  but we can only append 0 to a string ending in 1 
		 *  
		 *  indexes start from 0. So a[i] represents the number of binary strings for input length i+1.
		 *   Similarly, b[i] represents binary strings for input length i+1.
		 */
		
		int a[]=new int[n];
		int b[]=new int[n];
		
		a[0] = 1;
		b[0] =1;
		
		for(int i=1;i<n;i++){
			a[i]  = a[i-1] + b[i-1];
			b[i] = a[i-1];
		}
		
		System.out.println(a[n-1]+b[n-1]);
	}
	
}
