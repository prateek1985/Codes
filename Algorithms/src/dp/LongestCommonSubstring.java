package dp;

import java.util.Scanner;

public class LongestCommonSubstring {

	public static void main(String args[]){
		Scanner s = new Scanner(System.in);
		String a = s.nextLine();
		String b = s.nextLine();
		
		int lcSub[][]= new int[a.length()+1][b.length()+1];
		int max =-1;
		for(int i=1;i<a.length()+1;i++){
			for(int j=1;j<b.length()+1;j++){
				
				if(a.charAt(i-1)==b.charAt(j-1)){
					lcSub[i][j] = lcSub[i-1][j-1] + 1; 
				}
				else
					lcSub[i][j] = 0;
				
				max = Math.max(max, lcSub[i][j]);
			}
		}
		
		System.out.println(max);
	}
}
