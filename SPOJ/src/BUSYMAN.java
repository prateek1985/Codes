import java.util.*;
import java.io.*;

public class BUSYMAN {
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		
		PrintWriter pw = new PrintWriter(System.out);
		int t= Integer.parseInt(br.readLine());
		for(int r=0;r<t;r++){
			int n =Integer.parseInt(br.readLine());
			Act a[]=new Act[n];
			for(int i=0;i<n;i++){
				String s[]=br.readLine().split(" ");
				a[i]=new Act(Integer.parseInt(s[0]),Integer.parseInt(s[1]));
			}
			
			Arrays.sort(a);
			int count=1;
			Act lastAct = a[0];
			for(int i=1;i<n;i++){
				if(a[i].s>=lastAct.e)
				{
					count++;
					lastAct = a[i];
				}
			}
			pw.println(count);
			pw.flush();
		}
	}
	private static class Act implements Comparable<Act>{
		int s;
		int e;
		public Act(int s, int e){
			this.s=s;
			this.e=e;
		}
		
		public int compareTo(Act a){
			if(a.e<e)
				return 1;
			else if(a.e>e)
				return -1;
			else
				return (e-s)-(a.e-a.s);
		}
		
	}
}
