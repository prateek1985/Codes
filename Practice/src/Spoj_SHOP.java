import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Spoj_SHOP {
static char c[][];static int min ;
static int n,m;
static boolean vis[][];
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true){
			String s[]=br.readLine().split(" ");
			 m=Integer.parseInt(s[0]);
			 n =Integer.parseInt(s[1]);
			 
			 if(m==0 && n==0)
				 return;
			
			c=new char[n][m];
			min = Integer.MAX_VALUE;
			int si=0,sj=0;
		
			for(int i=0;i<n;i++){
				c[i]=br.readLine().toCharArray();
				for(int j=0;j<m;j++){
					if(c[i][j] == 'S'){
						si=i;sj=j;
					}
					
				}
			}
			vis = new boolean[n][m];
			dfs(si,sj,0);
			System.out.println(min);
			
			 String tmp=br.readLine();
		}
	}
	
	static void dfs(int i, int j,int d){
		if(c[i][j]=='D')
		{
			if(min > d)min=d;
			return;
		}
		
		if(i>=n || j>=m)
			return;
		
		if(c[i][j]=='X')
			return;
		if(d>=min)
			return;
		
		vis[i][j] =true;
		int num =0;
		
		if(c[i][j] != 'S')
			num= Integer.parseInt(c[i][j]+"");
		
		if(i <=n-2 && !vis[i+1][j])
			dfs(i+1,j,d + num);
		
		if(j <=m-2 && !vis[i][j+1])
			dfs(i,j+1,d + num);
		
		if(i >0 && !vis[i-1][j])
			dfs(i-1,j,d + num);
		
		if(j>0 && !vis[i][j-1])
			dfs(i,j-1,d + num);
		
		vis[i][j] =false;
		
	}
}
