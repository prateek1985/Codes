package dp;

import java.util.Scanner;

public class K_Palindrome {
	/*
	 * Given a string, find out if the string is K-Palindrome or not. 
	 * A K-palindrome string transforms into a palindrome on removing at most k characters from it.
*/
	public static void main(String args[]){
		// find longest palindrome subsequence 
		// total length - length of longest palindrome subsequence <= k
		
		Scanner s= new Scanner(System.in);
		String str = s.nextLine();
		int k = Integer.parseInt(s.nextLine());
		int lps[][]=new int[str.length()][str.length()];
		
		for(int i=0;i<str.length();i++){
			lps[i][i] =1;
		}
		
		for(int l=2;l<=str.length();l++){
			for(int i=0;i<str.length()-l+1;i++){
				int j=i+l-1;
				if(l==2 ){
					if(str.charAt(i)==str.charAt(j))  // combine this condition with upper if loop
						lps[i][j]=2;
					else
						lps[i][j]=1;
				}
				else if(str.charAt(i)==str.charAt(j))
						lps[i][j] = lps[i+1][j-1] +2;
				else
					lps[i][j] = Math.max(lps[i+1][j],lps[i][j-1]);
				}
			}
		
	//	System.out.println(lps[0][str.length()-1]);
		if(str.length() - lps[0][str.length()-1] <= k)
			System.out.println("yes");
		else
			System.out.println("no");
	}
}
