import java.io.*;
import java.util.*;
public class AMR10G {

	public static void main(String args[]) throws Exception{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		PrintWriter pw = new PrintWriter(System.out);
		int t=Integer.parseInt(br.readLine());
		
		for(int r=0;r<t;r++){
			String s[]=br.readLine().split(" ");
			int n=Integer.parseInt(s[0]);
			int k=Integer.parseInt(s[1]);
			String a[]=br.readLine().split(" ");
			int arr[]= new int[n];
			for(int i=0;i<n;i++){
				arr[i]=Integer.parseInt(a[i]);
				
			}
			Arrays.sort(arr);
			
			int i=0,j=k-1;
			int min=Integer.MAX_VALUE;
			while(j<n){
				if(arr[j]-arr[i] <min){
					min =arr[j]-arr[i];
				}
				j++;i++;
			}
			pw.println(min);
			pw.flush();
		}
	}
}
