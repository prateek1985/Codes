import java.io.*;
import java.util.*;
public class MrKitayutaColorfulGraph {

	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		String s[]=br.readLine().split(" ");
		int n=Integer.parseInt(s[0]);
		int m=Integer.parseInt(s[1]);
		HashSet g[][]= new HashSet[n+1][n+1];
		for(int i=1;i<n+1;i++){
			for(int j=1;j<n+1;j++){
				g[i][j] = new HashSet<Integer>();
			}
		}
		for(int i=0;i<m;i++){
			String e[]=br.readLine().split(" ");
			int u=Integer.parseInt(e[0]);
			int v= Integer.parseInt(e[1]);
			int c = Integer.parseInt(e[2]);
			g[u][v].add(c);
			g[v][u].add(c);
		}
		int q=Integer.parseInt(br.readLine());
		
		for(int k=1;k<n+1;k++){
			for(int i=1;i<n+1;i++){
				for(int j=1;j<n+1;j++){
					if(!g[i][k].isEmpty() && !g[k][j].isEmpty()){
						HashSet<Integer> hs = new HashSet<Integer>(g[i][k]);
						hs.retainAll(g[k][j]);
						
						g[i][j].addAll(hs);
					}
				}
			}
		}
		
		//System.out.println(g[3][4]);
		
		for(int i=0;i<q;i++){
			String query[]=br.readLine().split(" ");
			int u=Integer.parseInt(query[0]);
			int v= Integer.parseInt(query[1]);
			pw.println(g[u][v].size());
			pw.flush();
		}
		
	}
}
