package dp;

public class MaximumProductCutting {
	   // A Dynamic Programming solution for Max Product Problem
	static int maxProd(int n)
	{
	    int val[]= new int[n+1];
	     val[1] = 1;
	     val[2] =2;
	    
	    // Build the table val[] in bottom up manner and return
	    // the last entry from the table
	    for (int i = 3; i <= n; i++)
	    {
	 
	    	for (int j = 1; j <= i; j++)
	    		val[i] = Math.max(val[i],j*val[i-j]);
	    	 
	    }
	    return val[n];
	}

	/* Driver program to test above functions */
	public static void main(String args[])
	{
	    System.out.println(maxProd(5));
	}
}
