package dp;
import java.util.*;
public class PrintingLongestCommonSubsequence {
	//Given two sequences, print the longest subsequence present in both of them.
	public static void main(String args[]){
		
		Scanner s = new Scanner(System.in);
		String a=s.nextLine();
		String b=s.nextLine();
		
		int n = a.length();
		int m = b.length();
		
		int lcs[][]=new int[n+1][m+1];
		
		for(int i=1;i<n+1;i++){
			
			for(int j=1;j<m+1;j++){
				
				if(a.charAt(i-1)==b.charAt(j-1)){
					lcs[i][j]= 1+lcs[i-1][j-1];
				}
				else
					lcs[i][j]  = Math.max(lcs[i-1][j], lcs[i][j-1]);
			}
		}
		
		//System.out.println(lcs[n][m]);
		
		String str="";
		int i=n;
		int j=m;
		while(i>0 && j>0){
			
			if(a.charAt(i-1) == b.charAt(j-1)){
				str = a.charAt(i-1) + str;
				i--;
				j--;
			}
			else{
				if(lcs[i-1][j] > lcs[i][j-1]){
					i--;
				}
				else
					j--;
			}
		}
		
		System.out.println(str);
	}
}
