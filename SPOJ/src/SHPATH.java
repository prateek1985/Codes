import java.util.*;
import java.io.*;
public class SHPATH {
static Graph g[];static int n;
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine());
		
		for(int r=0;r<t;r++){
			n=Integer.parseInt(br.readLine());
			HashMap <String , Integer>hm= new HashMap<String , Integer>();
			 g = new Graph[n+1];
			for(int i=1;i<n+1;i++){
				g[i] = new Graph();
			}
			for(int c=1;c<=n;c++){
				hm.put(br.readLine() , c);
				int p =Integer.parseInt(br.readLine());
				for(int i=0;i<p;i++){
					String s[]=br.readLine().split(" ");
					Edge e = new Edge(c, Integer.parseInt(s[0]), Integer.parseInt(s[1]));
					g[c].al.add(e);
				}
			}
			
			int paths=Integer.parseInt(br.readLine());
			for(int y=0;y<paths;y++){
				String cities[]=br.readLine().split(" ");
				pw.println(dijkstra(hm.get(cities[0]) , hm.get(cities[1])));
				pw.flush();
			}
			
			br.readLine();
		}
		
	
	}
	
	
static long dijkstra(int source , int destination){
	long distance[] = new long[n+1];
	Arrays.fill(distance, Integer.MAX_VALUE);
	distance[source]=0;
	//boolean visited []=new boolean[n+1];
	//visited[source]=true;
	 HashSet<Edge> hs = new HashSet<Edge>();
	
	PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
	
	pq.add(new Edge(source , source, 0));
	while(!pq.isEmpty()){
		Edge e = pq.poll();
		long d = distance[e.u]+e.w;
		//visited[e.v]=true;
		
		if(distance[e.v]>d){
			distance[e.v] =d;
			
		}
	/*	if(visited[destination]){
			return distance[destination];
		}*/
		for(int i=0;i<g[e.v].al.size();i++){
			Edge e2 = g[e.v].al.get(i);
			 if(!hs.contains(e2)){
                 pq.add(e2);
                 hs.add(e2);
             }
		}
	}
	
	return distance[destination];
	// 3 6 8 11 7 12 10 18 4 8 3 6 12 1 2 10 1 8 5 6 9 9 8 17 11 12 8 
}


	private static class Graph{
		ArrayList<Edge> al = new ArrayList<Edge> ();
		
	}
	private static class Edge implements Comparable<Edge>{
		int v;
		int u;
		int w;
		public Edge(int u,int v ,int w){
			this.v=v;
			this.u=u;
			this.w=w;
			
		}
		public int compareTo(Edge e){
			return w-e.w;
		}
		
		 public boolean equals(Object o){
	            if(o instanceof Edge){
	                Edge e = (Edge)o;
	                return ((u==e.u&&v==e.v&&w==e.w) || (u==e.v&& v==e.u && w==e.w));
	            }
	            return false;
	        }
	}
}
