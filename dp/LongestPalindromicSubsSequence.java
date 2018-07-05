package dp;
public class LongestPalindromicSubsSequence {

	public static void main(String args[]){
		
		String s = "GEEKSFORGEEKS";
		
		int LPS [][]=new int[s.length()][s.length()];
		
		for(int i=0;i<s.length();i++){
			LPS[i][i] =1;
		}
		
		for(int l=2;l<=s.length();l++){
			 
			for(int i=0;i<s.length()-l+1 ; i++){
				int j = i+l-1;
				if(s.charAt(i)==s.charAt(j) && l==2){
					LPS[i][j] = 2;
				}
				else if(s.charAt(i) == s.charAt(j))
				{
					LPS[i][j] = LPS[i+1][j-1] + 2;
				}
				else 
					LPS[i][j] = Math.max(LPS[i][j-1], LPS[i+1][j]);
			}
		}
		
		System.out.println(LPS[0][s.length()-1]);
	}
}
