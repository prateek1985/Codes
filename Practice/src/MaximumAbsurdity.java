import java.util.*;
import java.io.*;

public class MaximumAbsurdity {

	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s[]=br.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int k =Integer.parseInt(s[1]);
		String arr[]  =br.readLine().split(" ");
		long dp[]= new long[n];
		dp[0] = Integer.parseInt(arr[0]);
		for(int i=1;i<n;i++){
			dp[i] = dp[i-1]+Integer.parseInt(arr[i]);
		}
		long max1=-1;
		long max2=-1;
		int l=0,r=0;
		
		for(int i=0;i<n-k+1;i++){
			int j = i+k-1;
			if(i==0){
				if(max1 < dp[j]){
					max1=dp[j];
					l=i;
					r=j;
				}
			}
			else{
				if(max1 < dp[j]-dp[i-1]){
					max1 = dp[j] - dp[i-1]; l=i;r=j;
				}
			}
			
		}
	//	System.out.println(max1 + " " + l);
		int l2=0;
		for(int i=0;i<n-k+1;i++){
			int j=i+k-1;
			if(j<l || i>r){
				if(i==0){
					if(max2 < dp[j]){
						max2=dp[j];l2=i;
					}
				}
				else{
					if(max2 < dp[j]-dp[i-1]){
						max2 = dp[j] - dp[i-1];
						l2=i;
					}
				}
			}
		}
		
		long max =-1;
		int l3=0;
		for(int i=0;i<n-(2*k)+1;i++){
			int j = i+(2*k)-1;
			if(i==0){
				if(max < dp[j]){
					max=dp[j];
					l3=i;
				}
			}
			else{
				if(max < dp[j]-dp[i-1]){
					max = dp[j] - dp[i-1];
					l3=i;
				}
			}
			
		}
		//	System.out.println(l3+ "       "+ (l+  " " +l2));
		if(l>l2){
			int tmp=l;
			l = l2;
			l2 = tmp;
		}
		if(max1 + max2 > max){
			
				System.out.println(l+1 + " "+ (l2+1));
		
		}
		else if(max1 + max2 < max)
			System.out.println(l3+1 + " "+ (l3+k+1));
		else{
			if(l<l3)
				System.out.println(l+1 + " "+ (l2+1));
			else if(l>l3)
				System.out.println(l3+1 + " "+ (l3+k+1));
			else{
				if(l2<l3+k)
					System.out.println(l3+1 + " "+ (l2+1));
				else
					System.out.println(l3+1 + " "+ (l3+k+1));
			}
		}
		
		//System.out.println(Math.max(max1+max2, max));
	}
}
