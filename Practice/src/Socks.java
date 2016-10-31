import java.util.*;
import java.io.*;

public class Socks {
static int count=0 , num;
static Graph g[];
static HashMap<Integer,Integer> hm;
static String colors[];
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s[]=br.readLine().split(" ");
		int n=Integer.parseInt(s[0]);
		int m=Integer.parseInt(s[1]);
		int k=Integer.parseInt(s[2]);
		colors= br.readLine().split(" ");
		 g= new Graph[n+1];
		for(int i=1;i<n+1;i++){
			g[i]= new Graph();
		}
		
		for(int i=0;i<m;i++){
			String e[]= br.readLine().split( " " );
			int u=Integer.parseInt(e[0]);
			int v= Integer.parseInt(e[1]);
			g[u].al.add(v);
			g[v].al.add(u);
		}
		
		for(int i=1;i<n+1;i++){
			if(!g[i].vis){
				hm=new HashMap<Integer,Integer> ();
				num=0;
				dfs(i);
				int max =0;
				for(Map.Entry<Integer, Integer> entry : hm.entrySet()){
					int x=entry.getValue();
					if( x>max)
						max =x;
				}
				count += num - max;
			}
		}
		System.out.println(count);
	}
	private static void dfs(int s){
		g[s].vis=true;
		num++;
		if(hm.containsKey(Integer.parseInt(colors[s-1]))){
			hm.put(Integer.parseInt(colors[s-1]) , hm.get(Integer.parseInt(colors[s-1]))+1);
		}
		else{
			hm.put(Integer.parseInt(colors[s-1]), 1);
		}
		for(int i=0;i<g[s].al.size();i++){
			int v= g[s].al.get(i);
			if(!g[v].vis)
				dfs(v);
		}
		
		
	}
	private static class Graph{
		boolean vis=false;
		ArrayList<Integer> al = new ArrayList<Integer>();
	}
}
