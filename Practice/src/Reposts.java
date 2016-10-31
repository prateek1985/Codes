import java.io.*;
import java.util.*;

public class Reposts {
static Graph g[];
static int max = Integer.MIN_VALUE;
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		g= new Graph[n+1];;
		for(int i=0;i<n+1;i++){
			g[i]= new Graph();
		}
		HashMap<String,Integer> hm = new HashMap<String,Integer>();
		hm.put("polycarp", 0);
		
		for(int r=1;r<n+1;r++){
			String s[] = br.readLine().split(" ");
			String u =s[2].toLowerCase(); 
			String v =s[0].toLowerCase(); 
			hm.put(v,r);
			g[hm.get(u)].al.add(r);
		//	System.out.println(hm.get(u) +" "+ r);
		}
		
		dfs(0,1);
		System.out.println(max);
	}
	private static class Graph{
		ArrayList<Integer> al = new ArrayList<Integer>();
		boolean vis=false;
	}
	
	static void dfs(int src, int k){
	
		g[src].vis=true;
		if(max < k){
			max=k;
		}
		
		for(int i=0;i<g[src].al.size();i++){
			int v = g[src].al.get(i);
			if(!g[v].vis){
				dfs(v,k+1);
			}
		}
	}
}
