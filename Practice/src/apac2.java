import java.util.*;
import java.io.*;

public class apac2 {
static float p,q;
static int st,n,m;
static double max;
static String mat[][];
	public static void main(String args[]) throws Exception{
		BufferedWriter output = new BufferedWriter(new FileWriter("output.txt")); 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		/*
        output.append("Case #"+y+": "+arr[min]);
        output.newLine();
        output.close();*/
		int t = Integer.parseInt(br.readLine());
		
		for(int y=1;y<=t;y++){
			String a[]=br.readLine().split(" ");
			 n =Integer.parseInt(a[0]);
			 m =Integer.parseInt(a[1]);
			int r =Integer.parseInt(a[2]);
			int c =Integer.parseInt(a[3]);
			 st =Integer.parseInt(a[4]);
			String pob[]=br.readLine().split(" ");
			 p=Float.parseFloat(pob[0]);
			 q=Float.parseFloat(pob[1]);
			mat= new String[n][m];
			int vis[][] = new int[n][m];
			for(int i=0;i<n;i++){
				
					mat[i] = br.readLine().split(" ");
			}
			max =-1;
			dfs(r,c+1,1,0, vis);
			dfs(r+1,c,1,0,vis);
			dfs(r,c-1,1,0,vis);
			dfs(r-1,c,1,0,vis);
			if(max >0)
			output.append("Case #"+y+": "+max);
			else
				output.append("Case #"+y+": "+0);
	        output.newLine();
		}
		 output.close();
	}
	
	
	static void dfs(int r, int c, int k,double d, int vis[][]){
		if(r<0||r>=n || c<0 || c>=m || k==st+1)
			return;
		double dd=0;
		
		if(mat[r][c].charAt(0) == 'A'){
			 dd= d+p*Math.pow(1-p,vis[r][c]);
		}
		else{
			dd= d+q*Math.pow(1-q,vis[r][c]);
		}
	//	System.out.println(dd);
			vis[r][c]++;
		if(mat[r][c].charAt(0) == 'A'){
			dfs(r,c+1,k+1,dd,vis);
			dfs(r+1,c,k+1,dd,vis);
			dfs(r,c-1,k+1,dd,vis);
			dfs(r-1,c,k+1,dd,vis);
		}
		else{
			
			dfs(r,c+1,k+1,dd,vis);
			dfs(r+1,c,k+1,dd,vis);
			dfs(r,c-1,k+1,dd,vis);
			dfs(r-1,c,k+1,dd,vis);
		}
		
		if(k==st){
			if(max < dd){
			//	System.out.println(r+" "+c);
				max =dd;
			}
			
		}
		
		
		vis[r][c]--;
	}
	
}
