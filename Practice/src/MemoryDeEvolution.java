import java.io.*;
import java.util.Arrays;
public class MemoryDeEvolution {

	public static void main(String args[]) throws Exception{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String arr[]=br.readLine().split(" ");
		int n= Integer.parseInt(arr[0]);
		int k=Integer.parseInt(arr[1]);
		if(n==k)
			System.out.println(0);
		else if(2*k>n)
			System.out.println(3);
		else{
			int a[]= new int[3];
			Arrays.fill(a, n);
			int p=0;
			while(a[0]!=k || a[1]!=k || a[2]!=k){
				Arrays.sort(a);
				if(p==0){
					a[0] = 2*k-1;
				}
				else{
					a[2] = a[1]-a[0]+1;
					if(a[2]<k)
						a[2]=k;
				}
				p++;
			}
			System.out.println(p);
		}
		
	}
}
