import java.util.*;
import java.io.*;
public class LABYR1 {
static StringBuilder[] c;
static int row,col, max;
	public static void main(String aargs[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine());
		for(int r=0;r<t;r++){
			String s[]=br.readLine().split(" ");
			row=Integer.parseInt(s[1]);
			col=Integer.parseInt(s[0]);
			max=0;
			c = new StringBuilder[row];
			for(int i=0;i<row;i++){
				c[i] =new StringBuilder(br.readLine());
			}
			
			for(int i=0;i<row;i++){
				for(int j=0;j<col;j++){
					if(c[i].charAt(j)=='.'){
						dfs(i,j,0);
					}
				}
			}
			pw.println("Maximum rope length is "+max+".");
			pw.flush();
		}
	}
	
	static void dfs(int i, int j, int p){
		c[i].setCharAt(j,'#');
		//System.out.println(i+"cc"+j);
		if(i+1<row && c[i+1].charAt(j)=='.'){
			
			dfs(i+1,j,p+1);
		}
		if(i>=1 && c[i-1].charAt(j)=='.')
			dfs(i-1,j,p+1);
		if(j+1<col && c[i].charAt(j+1)=='.')
			dfs(i,j+1,p+1);
		if(j>=1 && c[i].charAt(j-1)=='.')
			dfs(i,j-1,p+1);
		
		if(max<p){
			max=p;
		}
	}
}
