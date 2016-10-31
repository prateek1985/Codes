import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class COLORINT {
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		for(int r=0;r<t;r++){
			String s[]=br.readLine().split(" ");
			int n = Integer.parseInt(s[0]);
			int m = Integer.parseInt(s[1]);
			int x = Integer.parseInt(s[2]);
			String w[]=br.readLine().split(" ");
			String c[]=br.readLine().split(" ");
			
			boolean dp[][]= new boolean[x+1][m+1];
			ArrayList<ArrayList<Integer>> al = new ArrayList<ArrayList<Integer>>();
			for(int i=0;i<=m;i++){
				al.add(new ArrayList<Integer>());
			}
			for(int i=0;i<n;i++){
				al.get(Integer.parseInt(c[i])).add(Integer.parseInt(w[i]));
			}
	//		System.out.println(al);
			dp[0][0]=true;
			
			for(int cap=1;cap<=x;cap++){
				for(int i=1;i<=m;i++){
					for(int j=0;j<al.get(i).size();j++){
						int wi = al.get(i).get(j);
						if(wi <= cap)
							dp[cap][i] = dp[cap][i] || dp[cap - wi][i-1];
					}
				}
			}
			
			boolean b=false;
			for(int cap = x;cap>=0;cap--){
				if(dp[cap][m]){
					System.out.println(x-cap);
					b=true;
					break;
				}
			}
			if(!b)
				System.out.println(-1);
		}
	}
}
