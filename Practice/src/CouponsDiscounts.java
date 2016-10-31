	import java.io.BufferedReader;
	import java.io.InputStreamReader;
	import java.util.*;
	public class CouponsDiscounts {
		public static void main(String args[]) throws Exception{
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			String s=br.readLine();
			int n=Integer.parseInt(s);
			String arr[]= br.readLine().split(" ");
			int a[]= new int[n];
			for(int i=0;i<n;i++){
				a[i]=Integer.parseInt(arr[i]);
			}
			for(int i=0;i<n-1;i++){
				if(a[i]%2 !=0 && a[i]>0){
					a[i]--;
					if(a[i+1]>0)
						a[i+1]--;
					else{
						System.out.println("NO");
						return;
					}
				}
				
			}
			boolean flag=true;
			for(int i=0;i<n;i++){
				if(a[i]%2!=0){
					flag=false;
					break;
				}
			}
			if(flag)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}
