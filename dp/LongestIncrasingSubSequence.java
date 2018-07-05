package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LongestIncrasingSubSequence {

	static String s[];
	static int num ;
	public static void main(String[] args) throws IOException {
	//10 22 9 33 21 50 41 60 80
		//9 33 21 25
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		s=br.readLine().split(" ");
		int LIS[]=new int[s.length];
		Arrays.fill(LIS, 1);
		
		for(int i=1;i<s.length;i++){
			
			for(int j=0; j<i;j++){
				
				if(Integer.parseInt(s[i]) > Integer.parseInt(s[j])  && LIS[i] < LIS[j]+1){
					LIS[i] =LIS[j]+1;
				}
				
			}
			
		}
		int max=Integer.MIN_VALUE;
		for(int x: LIS){
		
			if(x>max)
				max=x;
		}
		
		System.out.println(max);
	}
	
}

