import java.io.*;
public class MemoryCrow {
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		String arr[]=br.readLine().split(" ");
		for(int i=0;i<n-1;i++){
			System.out.print(Long.parseLong(arr[i]) + Long.parseLong(arr[i+1])+" ");
			
		}
		System.out.print(arr[n-1]);;
	}
}
