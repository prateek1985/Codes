import java.io.*;
import java.util.*;
public class WORDS1 {
	static Graph g[];
//	static HashSet<Integer> vis;
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		int t=Integer.parseInt(br.readLine());
		for(int r=0;r<t;r++){
			int n = Integer.parseInt(br.readLine());
			ArrayList<String> al = new ArrayList<String>();
			HashMap<Character,Integer> hm = new HashMap<Character,Integer>();
			int p=0;
			for(int i=0;i<n;i++){
				String str= br.readLine();
				if(!hm.containsKey(str.charAt(0)))
					hm.put(str.charAt(0), p++);
				if(!hm.containsKey(str.charAt(str.length()-1)))
					hm.put(str.charAt(str.length()-1), p++);
				al.add(""+str.charAt(0)+str.charAt(str.length()-1));
			}
			g = new Graph[hm.size()];
			int inDeg[]=new int[hm.size()];
			for(int i=0;i<g.length;i++){
				g[i]= new Graph();
			}
			
			for(int i=0;i<n;i++){
				String  c = al.get(i);
				g[hm.get(c.charAt(0))].al.add(hm.get(c.charAt(1)));
				inDeg[hm.get(c.charAt(1))]++;
			}
			boolean b=false;
			int count =0;int count2 =0;
			for(int i=0;i<g.length;i++){
				if(Math.abs(inDeg[i] - g[i].al.size()) ==1){
					count++;
				}		
				else if(Math.abs(inDeg[i] - g[i].al.size()) ==0){
					count2++;
					//break;
				}
				else{
					b=true;
					break;
				}
			}
		/*	vis = new HashSet<Integer>();	
			for(int i=0;i<g.length;i++){
				dfs(i);
				if(vis.size()==g.length){
					b=true;
					break;
				}
				vis.clear();
				
			}*/
			
			if(n!=1&&!b&&(count == 2 || count2==g.length-2))
				pw.println("Ordering is possible.");
			else
				pw.println("The door cannot be opened.");
			pw.flush();
		}
	}
	/*
	private static void dfs(int s){
		vis.add(s);
		
		for(int i=0;i<g[s].al.size();i++){
			int v = g[s].al.get(i);
			if(!vis.contains(v)){
				dfs(v);
			}
		}
	}
*/
	private static class Graph{
		ArrayList<Integer> al = new ArrayList<Integer>();
	}
}
