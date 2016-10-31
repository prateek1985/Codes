import java.io.*;
import java.util.*;
public class AlyonaTree {
	static Graph g[];
	static String ver[];
	static int par[],count;
	static 	boolean vis[];
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		 ver=br.readLine().split(" ");
		g= new Graph[n+1];
		for(int i=1;i<n+1;i++){
			g[i]= new Graph();
		}
		for(int i=2;i<=n;i++){
			String s[]=br.readLine().split(" ");
			g[i].al.add(new edge(Integer.parseInt(s[0]), Integer.parseInt(s[1])));
			g[Integer.parseInt(s[0])].al.add(new edge(i, Integer.parseInt(s[1])));
		}
		par=new int[n+1];
		 count=0;
	    vis =  new boolean[n+1];
		dfs2(1,0,0);
	
		System.out.println(n-count);
	}
	 
	private static void dfs2(int s,long dis,long sum){
		if(dis>0)
			sum=dis;
		else{
			sum=0;
			dis=0;
		}
		if(sum> Integer.parseInt(ver[s-1])){
			vis[s] = true;
			return;
		}
		count++;
		for(int i=0;i<g[s].al.size();i++){
			edge e = g[s].al.get(i);
			if( par[s]!=e.v){
				par[e.v] =s;
				dfs2(e.v,dis+e.w,sum);
			}
		}
		
	}
	
	private static class Graph{
		ArrayList<edge> al = new ArrayList<edge>();
	}
	private static class edge{
		int v;
		int w;
		public edge(int v, int w){
			this.v=v;
			this.w=w;
		}
	}
}
