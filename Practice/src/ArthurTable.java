import java.io.*;
import java.util.*;
public class ArthurTable {
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		String len[]=br.readLine().split(" ");
		String cost[]=br.readLine().split( " " );
		int freq[]= new int[100001];
		//pair arr[]= new pair[n];
		int dp[][]= new int [201][100001];
		for(int i=0;i<n;i++){
		//	arr[i] = new pair(Integer.parseInt(len[i]),Integer.parseInt(cost[i]));
			freq[Integer.parseInt(len[i])]++;
			dp[Integer.parseInt(cost[i])][Integer.parseInt(len[i])]++;
		}
	//	Arrays.sort(arr);
		
		for(int i=0;i<dp.length;i++){
			for(int j=1;j<dp[i].length;j++){
				dp[i][j] += dp[i][j-1];
			}
		}
		
		int totalCost[]= new int[100001];
		ArrayList<Integer> al =new ArrayList<Integer>();
		int p=0;
		int sum =0;
		for(int i=0;i<n;i++){
			int a = Integer.parseInt(len[i]);
			sum += Integer.parseInt(cost[i]);
			if(totalCost[a]>0)
				totalCost[a]+=Integer.parseInt(cost[i]);
			else{
				totalCost[a]=Integer.parseInt(cost[i]);
				al.add(a);
			}
		}
		Collections.sort(al);
		int legs=0;
		int min = Integer.MAX_VALUE;
		for(int i=0;i<al.size();i++){
			int a = al.get(i);
			sum-=totalCost[a];
			legs += freq[a];
			if(((float)legs)/2 < freq[a]){
				if(min > sum)
					min =sum;
			}
			else{
				int del = legs - (2*freq[a]-1);
				int extra=0;
				for(int j=1;j<dp.length;j++){
					if(del==0)
						break;
					if(dp[j][a-1] <= del){
						del-=dp[j][a-1];
						extra += dp[j][a-1]*j;
					}
					else{
						extra += del*j;
						del=0;
					}
				}
				if(min > sum+extra)
					min = sum+extra;
			}
		}
		System.out.println(min);
	}
	/*private static class pair implements Comparable<pair>{
		int l;
		int c;
		public pair(int l, int c){
			this.l=l;
			this.c=c;
		}
		public int compareTo(pair p){
			return c - p.c;
		}
	}*/
}

