import java.io.*;
import java.util.Arrays;
public class PotionsHomework {

	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n =Integer.parseInt(br.readLine());
		int a[]=new int[n];
		for(int i=0;i<n;i++){
			a[i] =Integer.parseInt(br.readLine());
		}
		Arrays.sort(a);
		long ans=0;
		for(int i=0;i<n;i++){
			ans += ((long)a[i]*(long)a[n-i-1])%10007;
		}
		System.out.println(ans%10007);
	}
}
