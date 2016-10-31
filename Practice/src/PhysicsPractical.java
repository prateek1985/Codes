import java.io.*;
import java.util.*;
public class PhysicsPractical {
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n =Integer.parseInt(br.readLine());
		String s[]=br.readLine().split(" ");
		int freq[]=new int[5001];
		HashSet<Integer> hs = new HashSet<Integer>();
		for(int i=0;i<n;i++){
			hs.add(Integer.parseInt(s[i])); 
		}
		int arr[]= new int[hs.size()];
		int p=0;
		for(int i=0;i<n;i++){
			if(freq[Integer.parseInt(s[i])]==0)
				arr[p++] = Integer.parseInt(s[i]);
			freq[Integer.parseInt(s[i])]++; 
		}
		Arrays.sort(arr);
		int dp[][]= new int[arr.length][arr.length];
		
		for(int l=2;l<=arr.length;l++){
			for(int i=0;i<arr.length-l+1;i++){
				int j = i+l-1;
				if(arr[j] > 2*arr[i])
					dp[i][j] = Math.min(dp[i+1][j] + freq[arr[i]], dp[i][j-1] + freq[arr[j]]);
				else
					dp[i][j] = 0;
			}
		}
		
		System.out.println(dp[0][arr.length-1]);
	}
}
