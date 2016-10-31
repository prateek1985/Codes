import java.io.*;
import java.util.Arrays;
public class GeometricProgression {
static obj a[];
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s[]=br.readLine().split(" ");
		int n=Integer.parseInt(s[0]);
		int r = Integer.parseInt(s[1]);
		String arr[]=br.readLine().split(" " );
		 a=new obj[n];
		 
		for(int i=0;i<n;i++){
			a[i]=new obj(i,Integer.parseInt(arr[i]));
		}
		
		Arrays.sort(a);
		
		long c=0;
		for(int i=1;i<n-1;i++){
			float ff = (float)a[i].val/r;
			float ll = (float)a[i].val*r;
			
			int f=0;
			int l = 0;
	//		System.out.println(ff+" "+f);
			if(ff==(int)ff)
				f=(int)ff;
			else
				continue;
			if(ll==(int)ll)
				l=(int)ll;
			else continue;
			
			if(f>1000000000L || l>1000000000L)
				continue;
			int i1=Arrays.binarySearch(a,new obj(-1,f));
			if(i1<0)
				continue;
		
		
				int i2=Arrays.binarySearch(a, new obj(-1,l));
				if(i2<0)
					continue;
				long c1 = count1(i1,a[i].ind);
				long c2 = count2(i2,a[i].ind);
			//	System.out.println(c1+" "+c2);
				c+= c1*c2;
			
		}
		System.out.println(c);
	}
	static int count1(int e, int ind){
		int c=0;
		for(int i=e-1;i>=0;i--){
			if(a[i+1].equals(a[i])){
				if(a[i].ind < ind)
					c++;
			}
			else
				break;
		}
		for(int i=e+1;i<a.length;i++){
			if(a[i].equals(a[i-1])){
				if(a[i].ind <ind)
					c++;
			}
			else
				break;
		}
		if(a[e].ind <ind)
			c++;
		return c;
	}
	static int count2(int e, int ind){
		int c=0;
		for(int i=e-1;i>=0;i--){
			if(a[i+1].equals(a[i])){
				if(a[i].ind > ind)
					c++;
			}
			else
				break;
		}
		for(int i=e+1;i<a.length;i++){
			if(a[i].equals(a[i-1])){
				if(a[i].ind >ind)
					c++;
			}
			else
				break;
		}
		if(a[e].ind >ind)
			c++;
		return c;
	}
	
	private static class obj implements Comparable<obj>{
		int ind;
		int val;
		public obj(int ind, int val){
			this.ind=ind;
			this.val = val;
		}
		
		public int compareTo(obj o){
			return val-o.val;
		}
		
		public boolean equals(Object o){
			if(o instanceof obj){
				obj o1=(obj)o;
				return o1.val == val;
			}
			return false;
		}
	}
}
