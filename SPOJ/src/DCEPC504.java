import java.io.*;
public class DCEPC504 {

	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for(int r=0;r<t;r++){
			String s[]=br.readLine().split(" ");
			int n = Integer.parseInt(s[0]);
			long k = Long.parseLong(s[1]);
			
			n--;
			k--;
			
			int g = gender(n,(long)Math.pow(2,n)-1+k);
			if(g==1)
				System.out.println("Male");
			else
				System.out.println("Female");
		}
	}
	
	static int gender(int n , long index){
		
		if(n==0 && index==0)
			return 1;
		
		long parent = (index-1)/2;
	
		int g = gender(n-1 , parent);
		
		if(index == 2*parent+1)    // left child
			return g;
		else						// right child
			return 1-g;
	}
}
