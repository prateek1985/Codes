import java.io.*;
public class Cormen {

	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s[]=br.readLine().split(" ");
		int n=Integer.parseInt(s[0]);
		int k=Integer.parseInt(s[1]);
		String a[]= br.readLine().split(" ");
		int arr[]=new int[n];
		for(int i=0;i<n;i++){
			arr[i] = Integer.parseInt(a[i]);
		}
		int count=0;
		for(int i=0;i<n-1;i++){
			if(arr[i]+arr[i+1] < k){
				count += k - (arr[i]+arr[i+1]);
				arr[i+1] += k - (arr[i]+arr[i+1]);
			}
		}
		System.out.println(count);
		for(int x:arr){
			System.out.print(x+" ");
		}
	}
}
