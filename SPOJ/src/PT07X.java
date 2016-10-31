import java.io.*;
import java.util.*;
public class PT07X {
	public static void main(String args[]) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Graph g[]=new Graph[n+1];
		for(int i=1;i<n+1;i++){
			g[i]=new Graph();
		}
		for(int i=0;i<n-1;i++){
			String s[]=br.readLine().split(" ");
			int u = Integer.parseInt(s[0]);
			int v = Integer.parseInt(s[1]);
			
			g[u].hs.add(v);
			g[v].hs.add(u);
		}
		int ans=0;
		while(true){
			int max = 0;
			int v=0;
			for(int i=1;i<n+1;i++){
				if(g[i].hs.size() >max){
					max  = g[i].hs.size();
					v=i;
				}
			}
		//	System.out.println(max);
			if(max==0){
				break;
			}
			ans++;
			Iterator it = g[v].hs.iterator();
			while(it.hasNext()){
				int u = (Integer) it.next();
				g[u].hs.remove(v);
			}
			g[v].hs.clear();
		}
		
		System.out.println(ans);
	}
	
	private static class Graph{
		HashSet<Integer> hs = new HashSet<Integer>();
	}
}
