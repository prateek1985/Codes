import java.io.*;
import java.util.*;
public class MysteriousPresent {

	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s[]=br.readLine().split(" ");
		int n =Integer.parseInt(s[0]);
		int w = Integer.parseInt(s[1]);
		int h = Integer.parseInt(s[2]);
		Chain arr[]= new Chain[n];
		int p=0;
		for(int i=1;i<=n;i++){
			String q[]=br.readLine().split(" ");
			if(Integer.parseInt(q[0])> w && Integer.parseInt(q[1]) > h )
				arr[p++] = new Chain(i,Integer.parseInt(q[0]),Integer.parseInt(q[1]));
		}

		Arrays.sort(arr,0,p);
		StringBuilder dp[]= new StringBuilder[p];
		int lis[]=new int[p];
		
		for(int i=0;i<p;i++){
			lis[i]=1;
			dp[i]=new StringBuilder(""+arr[i].ind);
		}

		for(int i=1;i<p;i++){
			for(int j=0;j<i;j++){
				if(arr[i].h > arr[j].h && arr[i].w > arr[j].w && lis[i] <lis[j]+1){
					lis[i]=lis[j]+1;
					StringBuilder sb = new StringBuilder(dp[j]);
					dp[i] = new StringBuilder(sb.append(" "+arr[i].ind));
					
				}
			}//System.out.println(i+" ef "+dp[i]);
			
		}
		
		int max=-1;
		int ans=-1;
		for(int i=0;i<p;i++){
			if( max < lis[i]){
				max=lis[i];
				ans=i;
			}
		}
		PrintWriter pw = new PrintWriter(System.out);
		if(ans==-1)
			pw.println(0);
		else{
			pw.println(max);
			pw.flush();
			pw.println(dp[ans]);
		}
			pw.flush();
	}
	private static class Chain implements Comparable<Chain>{
		int ind;
		int w;
		int h;
		public Chain(int ind,int w,int h){
			this.ind=ind;
			this.w=w;
			this.h=h;
		}
		public int compareTo(Chain c){
			return w-c.w;
		}
	}
	
}
