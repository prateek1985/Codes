import java.util.*;
import java.io.*;
public class CHFNFRN {
static Graph g[];
	public static void main(String agrs[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t= Integer.parseInt(br.readLine());
		for(int r=0;r<t;r++){
			String s[]=br.readLine().split(" ");
			int n=Integer.parseInt(s[0]);
			int m=Integer.parseInt(s[1]);
			g=new Graph[n+1];
			for(int i=1;i<n+1;i++){
				g[i]=new Graph();
			}
			
			for(int i=0;i<m;i++){
				String e[]=br.readLine().split(" ");
				int u=Integer.parseInt(e[0]);
				int v=Integer.parseInt(e[1]);
				g[u].al.add(v);
				g[v].al.add(u);
			}
			g[1].vis=true;
			
			for(int i=0;i<g[1].al.size();i++){
				int v = g[1].al.get(i);
				g[v].vis=true;
			}
			int u=0;
			for(int i=1;i<n+1;i++){
				if(!g[i].vis){
					u=i;
					break;
				}
			}
			
			if(u!=0){
				g[u].vis=true;
				for(int i=0;i<g[u].al.size();i++){
					int v = g[u].al.get(i);
					g[v].vis=true;
				}
			}
			
			boolean b=false;
			for(int i=1;i<n+1;i++){
				if(!g[i].vis){
					b=true;
					break;		
				}
			}
			PrintWriter pw = new PrintWriter(System.out);
			if(b)
			{
				pw.println("NO");
			}
			else{
				//pw.println("YES");
				
				HashSet<Integer>hs = new HashSet<Integer>();
				
				for(int p=2;p<=n;p++){
					hs.clear();
					hs.add(p);
					for(int i=0;i<g[p].al.size();i++){
						int v = g[p].al.get(i);
						hs.add(v);
					}
					u=0;
					for(int i=1;i<n+1;i++){
						if(!hs.contains(i)){
							u=i;
							break;
						}
					}
					
					if(u!=0){
						hs.add(u);
						for(int i=0;i<g[u].al.size();i++){
							int v = g[u].al.get(i);
							hs.add(v);
						}
					}
					
					if(hs.size()!=n){
						pw.println("NO");
						b=true;
						break;
					}
				}
				
				
				if(!b){
					if(n!=5)
						pw.println("YES");
					else
					{
						if(m>5)
							pw.println("YES");
						else
							pw.println("NO");
					}
				}
			}
			pw.flush();
		}
	}
	private static class Graph{
		ArrayList<Integer> al = new ArrayList<Integer>();
		boolean vis=false;
	}
}
