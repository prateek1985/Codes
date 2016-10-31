import java.io.*;
import java.util.*;
public class HORRIBLE {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		PrintWriter pw = new PrintWriter(System.out);
		for(int r=0;r<t;r++){
			String s[]=br.readLine().split(" ");
			Ftree ft1 = new Ftree(Integer.parseInt(s[0]));
			Ftree ft2 = new Ftree(Integer.parseInt(s[0]));
			for(int i=0;i<Integer.parseInt(s[1]);i++){
				String arr[]=br.readLine().split(" ");
				if(Integer.parseInt(arr[0])==0){
				int v = Integer.parseInt(arr[3]);
				int a = Integer.parseInt(arr[1]);
				int b = Integer.parseInt(arr[2]);
				
				
				ft1.update(v, a);
					
				ft1.update(-v,1+b);
				
				ft2.update(v*(a-1), a);
				ft2.update(-b*v, 1+b);
				
				//	for(int j=Integer.parseInt(arr[1]);j<=Integer.parseInt(arr[2]);j++)
				//		ft.update(Integer.parseInt(arr[3]), j);
					
				}
				else{
					
					int x = Integer.parseInt(arr[1]);
					int y = Integer.parseInt(arr[2]);
					long sumx = ft1.query(x-1)*(x-1) - ft2.query(x-1);
					long sumy = ft1.query(y)*y - ft2.query(y);
					pw.println(sumy-sumx);
					//
					pw.flush();
				}
				
			}
		}

	}
 private static class Ftree{
	int arr[];
	
	
	public Ftree(int n){
		arr=new int[n+1];
		/*for(int i=0;i<inp.length;i++){
			update(inp[i] , i+1);
		}*/
	}
	
	public void update(int val , int ind){
		while(ind<arr.length){
			arr[ind]+=val;
			ind = ind + (ind &(-ind));
		}
		
		for(int f:arr){
	//		System.out.println(f+"sdsd");
		}
	}
	
	public long query(int ind){
		long sum=0;
		while(ind>0){
		//	System.out.println(ind);
			sum+=arr[ind];
			ind = ind - (ind &(-ind));
		}
		return sum;
	}
	
}
}
