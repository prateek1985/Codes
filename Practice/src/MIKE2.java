import java.io.*;
import java.util.Arrays;
public class MIKE2 {
	public static void main(String args[]) throws Exception	{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String s[]=br.readLine().split(" ");
		int n =Integer.parseInt(s[0]);
		int k = Integer.parseInt(s[1]);
		String ss[]=br.readLine().split(" ");
		int arr[]= new int[n];
		for(int i=0;i<n;i++){
			arr[i] = Integer.parseInt(ss[i]);
		}
		
		Arrays.sort(arr);
		int uf=0;
		int f=0;
		for(int i=0;i<n;i++){
			int y = (int) Math.ceil((double)arr[i]/2);
			if(y>k){
				uf = n-i;
				break;
			}
			else{
				f=i;
				k -=y;
			}
		}
		int sf=0;
		for(int i=0;i<=f;i++){
			int y = arr[i] - (int) Math.ceil((double)arr[i]/2);
			if(y>k){
		
				break;
			}
			else{
				k -=y;
				sf++;
			}
		}
		System.out.println(uf+" "+sf);
	}
}
