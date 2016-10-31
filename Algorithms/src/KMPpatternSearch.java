
public class KMPpatternSearch {

	public static void main(String args[]){
		
		String s = "bacbabababacaca"; 
		String p = "ababaca"; 
		
		char pattern[]=p.toCharArray();
		int arr[] = prefixArray(pattern);
		char c[]=s.toCharArray();
		
		int i=0,j=0;
		while(i<c.length){
			if(c[i] == pattern[j]){
				
				if(j==pattern.length-1){
					System.out.println(i-j);
					return;
				}
				else{
					i++;j++;
				}
				 
			}
			else if(j>0){
				j=arr[j-1];
			}
			else{
				i++;
			}
		}
		
		System.out.println(-1);
	}
	
	static int[] prefixArray(char pattern[]){
		int arr[] = new int[pattern.length];
		int i=1,j=0;
		if(pattern.length==1)
			return arr;
		else{
			while(i<pattern.length){
				if(pattern[i]==pattern[j]){
					arr[i] = j+1;
					i++;
					j++;
					
				}
				else if(j>0){
					j = arr[j-1];
					
				}
				else{
					arr[i]=0;
					i++;
				}
			}
			return arr;
		}
		
	}
}
