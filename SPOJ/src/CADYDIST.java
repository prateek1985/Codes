import java.io.*;
import java.util.*;
public class CADYDIST {

	public static void main(String aargs[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		while(true){
			int n = Integer.parseInt(br.readLine());
			if(n==0)
				break;
			String s1[]=br.readLine().split(" ");
			String s2[]= br.readLine().split(" ");
			int c[] =new int[n];
			int p[]=new int[n];
			for(int i=0;i<n;i++){
				c[i]=Integer.parseInt(s1[i]);
				p[i]=Integer.parseInt(s2[i]);
			}
			Arrays.sort(c);
			Arrays.sort(p);
			long ans=0;
			for(int i=0;i<n;i++){
				ans+=((long)c[i]*p[n-i-1]);
			}
			pw.println(ans);
			pw.flush();
		}
	}
}
