import java.io.*;
public class DZYLovesSequences {

	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String s[]=br.readLine().split(" ");
		int l[]= new int[n];
		int r[]=new int[n];
		l[0]=1;
		r[n-1]=1;
		for(int i=1;i<n;i++){
			if(Integer.parseInt(s[i]) >Integer.parseInt(s[i-1]))
				l[i]=l[i-1]+1;
			else
				l[i]=1;
		}
		for(int i=n-2;i>=0;i--){
			if(Integer.parseInt(s[i+1]) > Integer.parseInt(s[i]))
				r[i]=r[i+1]+1;
			else
				r[i]=1;
		}
		int max=1;
		
		for(int i=0;i<n;i++){
			if(i!=n-1)
				max = Math.max(l[i]+1, max);
			if(i!=0)
				max = Math.max(r[i]+1, max);	
			if(i!=0&&i!=n-1 && Integer.parseInt(s[i+1]) > Integer.parseInt(s[i-1])+1){
				max = Math.max(max, l[i-1]+r[i+1]+1);
			}
		}
		System.out.println(max);
		
	}
	
}
