import java.util.*;
import java.io.*;
public class ValeraAndElections {
static Graph g[];
static int par[];
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		g=new Graph[n+1];
		for(int i=1;i<n+1;i++)
			g[i]=new Graph();
		int k=0;
		boolean repairVertex[]= new boolean[n+1];
		HashMap<String,Boolean> hm=new HashMap<String ,Boolean>();
		for(int i=1;i<n;i++){
			String s[]=br.readLine().split(" ");
			int u=Integer.parseInt(s[0]);
			int v=Integer.parseInt(s[1]);
			int r = Integer.parseInt(s[2]);
			if(r==2){
				k++;
				repairVertex[u]=true;
				repairVertex[v]=true;
				hm.put(u+" "+v, true);
				hm.put(v+" "+u, true);
			}
			Edge e1= new Edge(v,r);
			Edge e2= new Edge(u,r);
			g[u].al.add(e1);
			g[v].al.add(e2);
		}
		
		par = new int[n+1];
		dfs(1,0);
		Stack<Integer>st=new Stack<Integer>();
		boolean vis[]=new boolean[n+1];
		int ans=0;
		while(k>0){
			int max=-1;
			int u=0;
			for(int i=1;i<n+1;i++){
				if(g[i].k > max &&!vis[i] && repairVertex[i]){
					max =g[i].k;
					u=i;
				}
			}
			if(u!=0){
				ans++;
				st.push(u);
			}
			
			while(u!=1){
			//	System.out.println(u+" wdwd");
				vis[u] = true;
				int v = par[u];
				if(hm.containsKey(u+" "+v) && hm.get(u+" "+v)){
					k--;
					hm.put(u+" "+v, false);
					hm.put(v+" "+u, false);
				}
				u = v;
				
			}
		}
		PrintWriter pw=new PrintWriter(System.out);
		pw.println(ans);
		pw.flush();
		while(!st.isEmpty()){
			pw.print(st.pop()+" ");
			pw.flush();
		}
	}
	
	private static void dfs(int src,int k){
		g[src].k = k;
		g[src].vis=true;
		for(int i=0;i<g[src].al.size();i++){
			Edge e = g[src].al.get(i);
			if(!g[e.v].vis){
				par[e.v] = src;
				if(e.r==2)
					dfs(e.v,k+1);
				else
					dfs(e.v,k);
			}
		}
	}
	
	private static class Graph{
		ArrayList<Edge> al = new ArrayList<Edge>();
		int k=0;
		boolean vis=false;
	}
	private static class Edge{
		int v;
		int r;
		public Edge(int v , int r){
			this.v= v;
			this.r=r;
		}
	}
}
