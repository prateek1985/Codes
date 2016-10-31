import java.util.*;
public class Z_Algorithm {

	public static void main(String args[]){
		String text = "GEEKS FOR GEEKS";
		String pattern  = "GEEK";
		
		String finalString = pattern+"$"+text;
		
		int Z[] = calculateZArray(finalString.toCharArray());
		
		for(int i=0;i<Z.length;i++){
			if(Z[i]==pattern.length()){
				System.out.println(i-pattern.length()-1);
			}
		}
		
	}
	static int[] calculateZArray(char c[]){
		int z[] = new int[c.length];
		int r=0,l=0;  // right , left
		for(int i=1;i<c.length;i++){
			
			if(i>r){
				l=r=i;
				while(r<c.length && c[r]==c[r-l]){
					r++;
				}
				z[i] = r-l;
				r--;   // r-- is done so that z box can be formed
			}
			else{
				// k = i-l so k corresponds to number which
	            // matches in [L,R] interval.
				int k = i-l;
				
				// if Z[k] is less than remaining interval i.e. does not touches right bound
	            // then Z[i] will be equal to Z[k].
				if(z[k]<r-i+1)
					z[i] = z[k];
				else{
					
				//  else start from R  and check manually
					
					l=i;  // here r=i is not written because i is in z array so no need to compare char again from i to r
					while(r<c.length && c[r]==c[r-l]){
						r++;
					}
					
					z[i] = r-l;
					r--;
					
				}
			}
			
		}
		return z;
	}
}
