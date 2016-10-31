import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;
public class LakesBerland {
	static char c[][];
	static int n,m, island;
	static boolean vis[][];
	static ArrayList<cc>al= new ArrayList<cc>();
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		String s[]= br.readLine().split(" ");
		 n = Integer.parseInt(s[0]);
		 m = Integer.parseInt(s[1]);
		int k = Integer.parseInt(s[2]);
		
		c = new char[n][m];
		vis =  new boolean[n][m];
		for(int i=0;i<n;i++){
			c[i] = br.readLine().toCharArray();
		}
		for(int i=0;i<n;i++){
			if(c[i][0]=='.' && !vis[i][0])
				dfs1(i,0);
			if(c[i][m-1]=='.' && !vis[i][m-1])
				dfs1(i,m-1);
		}
		for(int i=0;i<m;i++){
			if(c[0][i]=='.' && !vis[0][i])
				dfs1(0,i);
			if(c[n-1][i]=='.' && !vis[n-1][i])
				dfs1(n-1,i);
		}
		/*
		for(int i=0;i<n;i++){
			System.out.println(new String(c[i]));
		}*/
		
		for(int i=1;i<n-1;i++){
			for(int j=1;j<m-1;j++){
				if(c[i][j] == '.' && !vis[i][j]){
					island=0;
					dfs(i,j);
					al.add(new cc(island,i,j));
				}
			}
		}
		
		
		if(al.size() == k)
			pw.println(0);
		else{
			Collections.sort(al);
			int l = al.size()-k;
			int sum=0;
			for(int i=0;i<l;i++){
				cc p = al.get(i);
				sum += p.s;
				dfs2(p.i,p.j);
			}
			pw.println(sum);
			
		}
		pw.flush();
		for(int i=0;i<n;i++){
			pw.println(new String(c[i]));
			pw.flush();
		}
		
	}
	static void dfs1(int i, int j){
		if(i>=n || j>=m || i<0||j<0 || vis[i][j] || c[i][j] == '*')
			return;
		
		vis[i][j]=true;
	//	c[i][j]  ='x';
		
		dfs1(i+1,j);
		dfs1(i,j+1);
		dfs1(i-1,j);
		dfs1(i,j-1);
	}
	
	static void dfs(int i, int j){
		if(i>=n-1 || j>=m-1 || i<1||j<1 || vis[i][j] || c[i][j] == '*')
			return;
		
		vis[i][j]=true;
		island++;
		
		dfs(i+1,j);
		dfs(i,j+1);
		dfs(i-1,j);
		dfs(i,j-1);
	}
	
	static void dfs2(int i, int j){
		if(i>=n-1 || j>=m-1 || i<1||j<1 || c[i][j] == '*')
			return;
		//System.out.println(i+" "+j);
		c[i][j] = '*';
		
		dfs2(i+1,j);
		dfs2(i,j+1);
		dfs2(i-1,j);
		dfs2(i,j-1);
	}
	
	private static class cc implements Comparable<cc>{
		int s;
		int i;
		int j;
		public cc(int s, int i ,int j){
			this.s=s;
			this.i=i;
			this.j =j;
		}
		@Override
		public int compareTo(cc arg0) {
			
			return s - arg0.s;
		}
	}
}
