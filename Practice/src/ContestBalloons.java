import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ContestBalloons {
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		pair arr[]= new pair[n];
		for(int i=0;i<n;i++){
			String s[]= br.readLine().split(" ");
			arr[i]=new pair(i+1,Long.parseLong(s[0]),Long.parseLong(s[1]));
		}
		Arrays.sort(arr);
		int r=0;
		for(int i=0;i<n;i++){
			if(arr[i].ind ==1){
				r = i;
				break;
			}
		}
		int rank=r+1;
		long oppBal = Integer.MIN_VALUE;
		if(r!=n-1){
			oppBal = arr[r+1].b;
		}
		
		c a[]= new c[r];
		for(int i=0;i<r;i++)
			a[i]=new c(arr[i].b,arr[i].w);
		
		Arrays.sort(a);
		long bal = arr[r].b;
		long wei  = arr[r].w;
		/*for(c cc:a)
			System.out.println(cc.b);*/
		for(int i=0;i<rank;i++){
			long diff = a[i].w-a[i].b+1;
			
			if(bal>diff && bal-diff >= oppBal){
				
				bal-=diff;
				if(bal>wei){
					rank--;
				}
				else
					break;
			}
			else
				break;
		}
		System.out.println(rank);
	}
	
	static private class c implements Comparable<c>{
		long b;
		long w;
		public c(long b,long w){
			this.b=b;
			this.w=w;
		}
		
		public int compareTo(c p){
			long a = (w-b) - (p.w-p.b);
			if(a>0)
				return 1;
			else if(a==0)
				return 0;
			else
				return -1;
		}
	}
	
	private static class pair implements Comparable<pair>{
		int ind;
		long b;
		long w;
		public pair(int ind ,long b, long w){
			this.b=b;
			this.w=w;
			this.ind=ind;
		}
		@Override
		public int compareTo(pair p) {
			// TODO Auto-generated method stub
			if (b-p.b <0)
				return 1;
			else if(b-p.b>0)
				return -1;
			else
				return ind-p.ind;
		}
		
	}
}
