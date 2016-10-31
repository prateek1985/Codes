package dp;

import java.io.*;
import java.util.*;

public class RedJohnIsBack {


	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		int t= Integer.parseInt(br.readLine());
		int bricks[] = new int[41];
		bricks[0]=0;
		bricks[1]=1;bricks[2]=1;bricks[3]=1;bricks[4]=2;
		int deg=3;
		for(int i=5;i<41;i++){
			bricks[i] =  bricks[i-1] + bricks[i-4];
		}
		
		for(int r=0;r<t;r++){
			int n=Integer.parseInt(br.readLine());
			//System.out.println(bricks[n]);
			pw.println(numberOfPrime(bricks[n]));
			pw.flush();
		}

	}
	
	static int numberOfPrime(int n){
		int primes[] = new int[n+1];
		for(int i=2;i<=Math.sqrt(n);i++){
			if(primes[i]==0){
				for(int j=i*i;j<=n;j+=i){
					primes[j]=1;
					
				}
			}
		}
		int num=0;
		for(int x=2;x<primes.length;x++){
			if(primes[x]==0)
				num++;
		}
		return num;
	}

}
