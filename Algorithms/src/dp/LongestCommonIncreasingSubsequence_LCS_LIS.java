package dp;

public class LongestCommonIncreasingSubsequence_LCS_LIS {

	public static void main(String args[]){
		int a[]= {3,4,9,1};
		int b[]= {5, 3, 8, 9, 10, 2, 1};
		
		int lcis[]= new int[b.length];
		
		for(int i=0;i<a.length;i++){
			int len=0;
			for(int j=0;j<b.length;j++){
				
				if(a[i] == b[j]){			// common element
					if(lcis[j] < 1 + len)
						lcis[j] = 1+len;
				}
				// update value of len till a[i] is common with b[j]
				 /* Now seek for previous smaller common
	               element for current element of 'a' */
				if(a[i] > b[j]){
					if(lcis[j] > len){     // len>0 shows that jth element is common with 'a' array
						len = lcis[j];
					}
				}
			}
		}
		
		int max=-1;
		for(int x:lcis){
			if(max < x)
				max = x;
		}
		System.out.println(max);
	}
}
