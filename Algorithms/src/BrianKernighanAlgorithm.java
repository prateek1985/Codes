import java.io.*;
import java.util.*;

// Count set bits in an integer

// it takes O(log n) time complexity;

public class BrianKernighanAlgorithm {

	public static void main(String args[]) throws Exception{
		Scanner s = new Scanner(System.in);
		int count=0;
		int n = s.nextInt();
		
		while(n>0){
			n = n & (n-1);
			count++;
		}
		System.out.println(count);
	}
	
}
