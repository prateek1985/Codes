import java.io.*;
import java.util.Arrays;
public class BookingSystem {

	public static void main(String args[]) throws Exception{
		BufferedReader rb= new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(rb.readLine());
		pair arr[]=new pair[n];
		for(int i=0;i<n;i++){
			String s[]=rb.readLine().split( " ");
			arr[i] = new pair(Integer.parseInt(s[0]), Integer.parseInt(s[1]), i+1);
		}
		Arrays.sort(arr);
		int tt=Integer.parseInt(rb.readLine());
		String tables[]=rb.readLine().split(" ");
		tab t[]=new tab[tt];
		for(int i=0;i<tt;i++){
			t[i]=new tab(i+1,Integer.parseInt(tables[i]));
		}
		Arrays.sort(t);
		int req=0,money=0;
		
		boolean occ[]=new boolean[tt];
		String str="";
		for(int i=0;i<n;i++){
			int ind = Arrays.binarySearch(t, new tab(0,arr[i].r));
			if(ind<0)
				ind = -ind-1;
			else{
				while(ind>0&&t[ind].t==t[ind-1].t)
					ind--;
			}
			for(int j=ind;j<tt;j++){
				if(!occ[j]){
					req++;
					money+=arr[i].c;
					str+= arr[i].i+" "+ t[j].i+"\n";
					occ[j]=true;
					break;
				}
			}
		}
		System.out.println(req +" "+money);
		System.out.println(str);
	}
	private static class pair implements Comparable<pair>{
		int r;
		int c;
		int i;
		public pair(int r, int c, int i){
			this.r=r;
			this.c=c;
			this.i=i;
		}
		public int compareTo(pair p){
			if(c==p.c){
				return r-p.r;
			}
			else
				return p.c-c;
		}
	}
	private static class tab implements Comparable<tab>{
		int i;
		int t;
		public tab(int i, int t){
			this.i=i;
			this.t=t;
		}
		@Override
		public int compareTo(tab arg0) {
			return t-arg0.t;
		}
		public boolean equals(Object o){
			if(o instanceof tab){
				tab tt = (tab)o;
				return tt.t == t;
			}
				return false;
		}
	}
}
