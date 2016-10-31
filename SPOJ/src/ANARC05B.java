import java.util.*;
import java.io.*;
public class ANARC05B {
	public static void main(String[] args) throws IOException{
	    
		Scanner s = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		
		for(;;){
			int n1 = s.nextInt();
			if(n1==0){
				return;
			}
			int arr1[]=new int[n1];
			
			//String s1[] = br.readLine().split(" ");
			
			//String s2[]=br.readLine().split(" ");
			
			for(int i=0;i<n1;i++){
				arr1[i]=s.nextInt();
			}
			
			int n2 = s.nextInt();
			int arr2[]=new int[n2];
			for(int i=0;i<n2;i++){
				arr2[i]=s.nextInt();
			}
			
			int dp1[]=new int[n1+1];
			int dp2[]=new int[n2+1];
			
			dp1[1]=arr1[0];
			dp2[1]=arr2[0];
			
			TreeSet <Integer> hs1 = new TreeSet<Integer>();
			HashSet <Integer> hs2 = new HashSet<Integer>();
			
			hs1.add(arr1[0]);
			hs2.add(arr2[0]);
			
			for(int i=1;i<n1;i++){
				int x = arr1[i];
				dp1[i+1]=dp1[i]+x;
				hs1.add(x);
				//arr1[i]=x;
			}
			for(int i=1;i<n2;i++){
				int x =arr2[i];
				dp2[i+1]=dp2[i]+x;
			//	arr2[i]=x;
				hs2.add(x);
			}
		
			hs1.retainAll(hs2);
			int ans=0,u=0,v=0;
			
			for(int x : hs1){
				 int a = Arrays.binarySearch(arr1, x);
				 int b = Arrays.binarySearch(arr2,x);
				 ans+=Math.max(dp1[a]-dp1[u], dp2[b]-dp2[v]);
			//	 System.out.println(ans);
				 u=a;v=b;
			}
			ans+=Math.max(dp1[dp1.length-1]-dp1[u], dp2[dp2.length-1]-dp2[v]);
			pw.println(ans);
			pw.flush();
			
		}
		
	}
}
