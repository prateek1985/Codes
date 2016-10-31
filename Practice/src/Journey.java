import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Journey {
	static Graph g[];
	static int n;
	static int max =0;
	static String ans="";
	static HashSet<Integer> hs = new HashSet<Integer>();
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s[]=br.readLine().split(" ");
		 n=Integer.parseInt(s[0]);
		int m=Integer.parseInt(s[1]);int t=Integer.parseInt(s[2]);
		
		g=new Graph[n+1];
		for(int i=1;i<n+1;i++)
			g[i] = new Graph();
		for(int i=0;i<m;i++){
			String e[]=br.readLine().split(" ");
			int  u = Integer.parseInt(e[0]);
			int  v = Integer.parseInt(e[1]);
			int  w = Integer.parseInt(e[2]);
			edge ee = new edge(v,w);
			g[u].al.add(ee);
		}
		dfs2(1,"1");
	//	System.out.println(hs);
		dfs(1,"1",t);
		System.out.println(ans.split(" ").length);
		System.out.println(ans);
	}
	
	static void dfs2(int s,String p){
		if(s!=n)
			g[s].vis=true;
		if(s == n){
			String arr[]=p.split(" ");
			for(String x:arr)
				hs.add(Integer.parseInt(x));
		}
		for(int i=0;i<g[s].al.size();i++){
			edge e = g[s].al.get(i);
	     	if(!g[e.v].vis)
	     		dfs2(e.v,p+" "+e.v);
		}
	}
	
	static void dfs(int s,String p, int t){
		
		if(t<0)
			return;
		if(s == n){
			String arr[]=p.split(" ");
			if(max <arr.length){
				max = arr.length;
				ans = new String(p);
			}
			return;
		}
		if(t==0)return;
		
		for(int i=0;i<g[s].al.size();i++){
			edge e = g[s].al.get(i);
			if(hs.contains(e.v))
				dfs(e.v , p+" "+e.v, t-e.w);
		}
		
	}
	

	
	private static class edge{
		int v;
		int w;
		public edge(int v, int w){
			this.v=v;
			this.w=w;
		}
	}
	private static class Graph{
		ArrayList<edge>al=new ArrayList<edge>();
		boolean vis=false;
	}
}
