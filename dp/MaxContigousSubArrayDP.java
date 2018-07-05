package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaxContigousSubArrayDP {

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		for(int r=0;r<t;r++){							
			String s=br.readLine();
			String []arr=br.readLine().split(" ");
			
			int sum[]=new int [arr.length];
			sum[0]=Integer.parseInt(arr[0]);
			for(int i=1;i<arr.length;i++){
				sum[i] = Math.max(sum[i-1]+Integer.parseInt(arr[i]), Integer.parseInt(arr[i]));
			}
			int max=Integer.MIN_VALUE;
			for(int x:sum){
				System.out.println(x);
				if(max<x)
					max=x;
			}
			
			int nonContigousSum=0,tmp=0;
			int nonContigousMax=Integer.MIN_VALUE;
			for(String x: arr){
				int p=Integer.parseInt(x);
				if(p>0)
					nonContigousSum+=p;
				else{
					tmp++;
					if(nonContigousMax<p){
						nonContigousMax=p;
					}
				}
					
			}
			if(tmp!=arr.length)
				System.out.println(max+" "+nonContigousSum);
			else
				System.out.println(nonContigousMax+" "+nonContigousMax);
			
			
		}

	}

}
