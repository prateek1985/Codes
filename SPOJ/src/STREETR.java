import java.io.*;
import java.util.*;
public class STREETR {
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int arr[]=new int[n];
		for(int i=0;i<n;i++){
			arr[i]=Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
	
		int hcf = arr[1]-arr[0];
		for(int i=2;i<n;i++){
			hcf = gcd(hcf , arr[i]-arr[i-1]);
		}
		
		//System.out.println(hcf+"vdv");
	
		int trees = ((arr[n-1]-arr[0])/hcf)+1;
		System.out.println(trees - n);
	}
	static int gcd(int a , int b){
		if(b==0)
			return a;
		
		return gcd(b,a%b);
	}
}
