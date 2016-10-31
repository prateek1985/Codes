package dp;

public class PalindromePartition {    // O(n^2)

	public static void main (String args[]){
		String str =  "ababbbabbababa";
		int n = str.length();
		/*
		P[i][j] = true if substring str[i..j] is palindrome, else false
			       Note that C[i] is 0 if P[0][i] is true */
		    int C[] = new int[n];
		    boolean P[][] = new boolean[n][n];
		  
		    int i, j, L; // different looping variables
		  
		    // Every substring of length 1 is a palindrome
		    for (i=0; i<n; i++)
		    {
		        P[i][i] = true;
		    }
		  
		  
		    for (L=2; L<=n; L++)
		    {
		        // For substring of length L, set different possible starting indexes
		        for (i=0; i<n-L+1; i++)
		        {
		            j = i+L-1; // Set ending index
		  
		            // If L is 2, then we just need to compare two characters. Else
		            // need to check two corner characters and value of P[i+1][j-1]
		            if (L == 2)
		                P[i][j] = (str.charAt(i) == str.charAt(j));
		            else
		                P[i][j] = (str.charAt(i) == str.charAt(j) && P[i+1][j-1]);
		  
		        }
		    }
		    
		    for(i=0;i<n;i++){
		    	if(P[0][i]){
		    		C[i] = 0;
		    	}
		    	else{
		    		C[i] = Integer.MAX_VALUE;
		    		for(j=0;j<i;j++){
		    			if(P[j+1][i]  && C[i] > 1+C[j]){
		    				C[i] = 1 + C[j];
		    			}
		    		}
		    	}
		    }
		  
		System.out.println(C[n-1]);
	}
}
