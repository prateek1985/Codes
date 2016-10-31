import java.util.*;
import java.io.*;
public class ACPC11B {


	public static void main(String[] args) throws IOException{
      
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner s = new Scanner(System.in);
		long t=s.nextInt();
		PrintWriter pw = new PrintWriter(System.out);
		for(long r=0;r<t;r++){
			
			int n1 = s.nextInt();
			long alt1[]= new long[n1];
			for(int i=0;i<n1;i++){
				alt1[i]=s.nextLong();
			}
			
			int n2 = s.nextInt();
			long arr[]= new long[n2];
			for(int i=0;i<n2;i++){
				arr[i]=s.nextLong();
			}
			
			Arrays.sort(arr);
			long min=Integer.MAX_VALUE;
			
			for(int i=0;i<n1;i++){
				long key = alt1[i];
				int x = Arrays.binarySearch(arr, key);
				if(x>=0){
					min=0;
					break;
				}
				else{
					int a = -x-1;
					if(a<alt1.length){
					    if(a>0){
						long m = Math.min(arr[a]-key,key-arr[a-1]);
						if(min>m)
							min=m;
					    }
					    else{
					    	if(min>arr[a]-key)
						    	min=arr[a]-key;
					    }
					}
					else{
						if(min>key-arr[a-1])
							min=key-arr[a-1];
					}
				
				}
			   
			}
			
			 pw.println(min);
			 pw.flush();
			 System.gc();
		}
		
	}

}
