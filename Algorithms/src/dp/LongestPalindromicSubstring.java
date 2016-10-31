package dp;
import java.util.*;
public class LongestPalindromicSubstring {

	/*Given a string, find the longest substring which is palindrome.
	 *  For example, if the given string is “forgeeksskeegfor”, the output should be “geeksskeeg”.
	 * */
	public static void main (String args[]) {
		Scanner s = new Scanner(System.in);
		String str = s.nextLine();
		int n = str.length();
		boolean palindrome[][] = new boolean [n][n];
		
		for(int i=0;i<n;i++){
			palindrome[i][i] = true;
		}
		int max = 1;
		int start = 0;
		for(int l=2;l<=n;l++){
			
			for(int i=0;i<n-l+1;i++){
				int j = i+l-1;
				if(l==2 && str.charAt(i) == str.charAt(j)){
					palindrome[i][j] = true;
					if(max <l){
						max = l;
						start = i;
					}
				}
				
				if(str.charAt(i) == str.charAt(j) && palindrome[i+1][j-1]){
					palindrome[i][j] = true;
					if(max <l){
						max = l;
						start = i;
					}
				}
			}	
		}
		System.out.println(max);
		System.out.println(str.substring(start, start+max));
	}
}
